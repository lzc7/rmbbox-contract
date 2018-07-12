package com.zipi.utils;


import com.itextpdf.text.DocumentException;
import com.zipi.entity.*;
import com.zipi.enums.SealFileType;
import com.zipi.enums.contract.ContractType;
import com.zipi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 代偿协议
 * Created by linzhicheng 2018年5月9日19:43:16
 */
@Component
public class CompensatorAgreementUtil extends BasePdfUtil{

    @Autowired
    private ContractTemplateService contractTemplateService;
    @Autowired
    private RmbLoanRequestService rmbLoanRequestService;
    @Autowired
    private RmbLoanService rmbLoanService;
    @Autowired
    private RmbLoanRepaymentService rmbLoanRepaymentService;
    @Autowired
    private UserService userService;
    @Autowired
    private RmbboxLoanApplyService rmbboxLoanApplyService;
    @Autowired
    private RmbboxLoanServiceRepaymentService rmbboxLoanServiceRepaymentService;

    public byte[] createFile(String repaymentId, SealFileType fileType) {

        //数据校验
        if(null==fileType){
            logger.error("代偿合同失败：参数不足");
            return null;
        }

        //模版类型校验
        if(!SealFileType.AgreementForCompensator.equals(fileType)){
            logger.error("代偿合同失败：暂不支持{}文件的生成",fileType.name());
            return null;
        }
        byte[] out = null;
        try {
            PDFUtils.MediatorFields fields = this.info(repaymentId,fileType);
            // 获取template模板
            String contractType = ContractType.TEMPLET4COMPENSATORY.name();
            RmbContractTemplate template = contractTemplateService.getByType(contractType);
            if (null == template){
                logger.info("模板不存在");
                return null;
            }
            // 生成pdf
            out = PDFUtils.templateToMediatorPdf(fields, template.getContent());

        } catch (Exception ex) {
            logger.error("Can't fullfil the template!", ex);
        }

        return out;
    }


    /**
     * 出借金额、期限、利率等
     * @throws DocumentException
     */
    private PDFUtils.MediatorFields info(String repaymentId, SealFileType fileType) throws Exception{
        /**
         * 合同编号
         */
        String contractNo = "";
        //结算年月日
        String signTime = "";
        String year = "";
        String month = "";
        String day = "";
        /**
         * 原始借款方名称
         */
        String loanerName = "";
        String loanerIdNo = "";
        String loanAmount="";//借款金额
        String loanAmountChar="";//借款金额汉子
        String loanRate="";//借款利率
        String loanInterest="";//借款利息
        String purpose = "";
        String period = "";
        String repayMethod="";//还款方式
        String countDate="";//起息日
        String lendDate="";//借款日期
        String dueDateStr="";//借款到期日


        //代偿方
        String guarantorName = "";
        String guarantorIdNo = "";
        BigDecimal lenderAmount = BigDecimal.ZERO;
        String lenderAmountChar = "";

        RmbLoanRepayment repayment = rmbLoanRepaymentService.queryByloanRepaymentId(repaymentId);
        if (null == repayment) {
            logger.error("还款计划不存在");
            return null;
        }
        BigDecimal loanServiceAmount = rmbboxLoanServiceRepaymentService.getLoanServiceAmountByRepaymentId(repaymentId);
        lenderAmount = repayment.getRepayAmount().add(repayment.getAmountService()).add(loanServiceAmount);
        lenderAmountChar = MoneyFormateUtil.number2CNMontrayUnit(lenderAmount);//代偿金额【大写】

        //借款人信息
        RmbLoanRequest request=rmbLoanRequestService.getRmbLoanRequestByLoanId(repayment.getLoanId());
        if(null==request){
            logger.error("标的申请信息不存在");
            return null;
        }
        purpose=rmbboxLoanApplyService.getPurpose(request.getRequestId());//借款用途
        contractNo = repaymentId;
        //借款人
        if(request.getCoreUser().isEnterprise()){//企业借款用户
            loanerName=request.getCoreUser().getCompanyName();//公司名称
            loanerIdNo = request.getCoreUser().getUnifiedCode();
        }else{//个人借款用户
            loanerName=request.getCoreUser().getUserName();//用户名称
            loanerIdNo=request.getCoreUser().getIdNumber();//证件号
        }
        //担保人
        CoreUser compensatory = userService.findById(repayment.getActCompensatoryId());
        if(compensatory.isEnterprise()){//企业借款用户
            guarantorName=compensatory.getCompanyName();//公司名称
            guarantorIdNo=compensatory.getUnifiedCode();
        }else{//个人借款用户
            guarantorName=compensatory.getUserName();//用户名称
            guarantorIdNo=compensatory.getIdNumber();//证件号
        }


        signTime = DateUtils.sdf_YMD_local.format(repayment.getRepayTime());
        year = DateUtils.dateFormateString(repayment.getRepayTime(),"yyyy");
        month = DateUtils.dateFormateString(repayment.getRepayTime(),"M");
        day = DateUtils.dateFormateString(repayment.getRepayTime(),"dd");

        RmbLoan loan=rmbLoanService.getLoanByLoanId(repayment.getLoanId());
        if(null!=loan){
            loanAmount=loan.getLoanAmount().setScale(2, RoundingMode.DOWN)+"";//借款金额
            loanAmountChar= MoneyFormateUtil.number2CNMontrayUnit(loan.getLoanAmount().setScale(2, RoundingMode.DOWN));//借款金额【大写】
            loanRate=(Double.valueOf(loan.getRate())/100)+"";//借款利率
            lendDate= DateUtils.sdf_YMD_local.format(loan.getSettledTime());//借款日期
            //查询借款到期日
            Date dueDate=rmbLoanRepaymentService.getDueDateByLoanId(repayment.getLoanId());
            dueDateStr=null==dueDate?"": DateUtils.sdf_YMD_local.format(dueDate);//借款到期日（最后的回款时间）
            countDate= DateUtils.sdf_YMD_local.format(loan.getSettledTime());//起息日【即：标的结算时间】

            if(loan.getMonths()==0){
                period= DateUtils.betweenDays(loan.getSettledTime(),dueDate)+"天";//期限
            }else{
                period= loan.getMonths()+"个月";//期限
            }
            loanInterest=rmbLoanRepaymentService.getAmountInterestByloanId(repayment.getLoanId()).setScale(2, RoundingMode.DOWN)+"";//借款利息
            repayMethod=loan.getRepayMethod().getKey();
        }
        Map<String,Object> keyValue = new HashMap<>();
        keyValue.put("orderId",contractNo);
        keyValue.put("loanerName",loanerName);
        keyValue.put("loanerIdNumber",loanerIdNo);
        keyValue.put("year",year);
        keyValue.put("month",month);
        keyValue.put("day",day);
        keyValue.put("signTime",signTime);

        keyValue.put("lendDate",lendDate);
        keyValue.put("dueDateStr",dueDateStr);
        keyValue.put("countDate",countDate);
        keyValue.put("period",period);

        keyValue.put("loanAmount",loanAmount);
        keyValue.put("loanAmountChar",loanAmountChar);
        keyValue.put("loanRate",loanRate);
        keyValue.put("loanInterest",loanInterest);
        keyValue.put("repayMethod",repayMethod);

        keyValue.put("guarantorName",guarantorName);
        keyValue.put("guarantorIdNo",guarantorIdNo);
        keyValue.put("lenderAmountChar",lenderAmountChar);
        keyValue.put("lenderAmount",lenderAmount);
        keyValue.put("purpose",purpose);

        return PDFUtils.convertToPdfMediatorField(keyValue,fileType);
    }
}

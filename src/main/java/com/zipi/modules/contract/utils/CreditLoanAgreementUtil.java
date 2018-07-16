package com.zipi.modules.contract.utils;

import com.itextpdf.text.DocumentException;
import com.zipi.core.util.BasePdfUtil;
import com.zipi.core.util.DateUtils;
import com.zipi.modules.contract.entity.*;
import com.zipi.modules.contract.enums.SealFileType;
import com.zipi.modules.contract.enums.ContractType;
import com.zipi.modules.contract.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 信贷协议
 * Created by linzhicheng on 2017/7/12.
 */
@Component("CreditLoanAgreementUtil")
public class CreditLoanAgreementUtil extends BasePdfUtil {
    @Autowired
    private ContractTemplateService contractTemplateService;
    @Autowired
    private RmbLoanRequestService rmbLoanRequestService;
    @Autowired
    private RmbInvestService rmbInvestService;
    @Autowired
    private RmbLoanRepaymentService rmbLoanRepaymentService;
    @Autowired
    private RmbLoanService rmbLoanService;
    @Autowired
    private RmbboxLoanApplyService rmbboxLoanApplyService;

    @Resource
    private RmbboxLoanServiceRepaymentService rmbboxLoanServiceRepaymentService;

    public byte[] createFile(String investId, String loanId, String userId, SealFileType fileType) {
        //数据校验
        if(null==fileType){
            logger.error("信贷标借款协议失败：参数不足");
            return null;
        }
        if(SealFileType.CreditLoanAgreementForLend.equals(fileType)&& StringUtils.isBlank(investId)){
            logger.error("信贷标借款协议失败：投资ID不能为空");
            return null;
        }
        //模版类型校验
        if(!(SealFileType.CreditLoanAgreementForLend.equals(fileType)|| SealFileType.CreditLoanAgreementForLoan.equals(fileType))){
            logger.error("信贷标借款协议失败：暂不支持{}文件的生成",fileType.name());
            return null;
        }
        byte[] out = null;
        try {
            PDFUtils.MediatorFields fields = this.lendInfo(investId,loanId,userId,fileType);
            // 获取template模板
            String contractType = ContractType.CREDITFORLEND.name();
            if (SealFileType.CreditLoanAgreementForLoan.equals(fileType)){
                contractType = ContractType.CREDITFORLOAN.name();
            }
            RmbContractTemplate template = contractTemplateService.getByType(contractType);
            if (null == template){
                logger.info("模板不存在");
                throw new RuntimeException("模板不存在");
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
    private PDFUtils.MediatorFields lendInfo(String investId, String loanId, String userId, SealFileType fileType) throws Exception{
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
         * 借款方名称
         */
        String loanerName = "";
        String loanerIdNo = "";

        //借款年月日
        String lendDate="";//借款日期
        //借款到期年月日
        String dueDateStr="";//借款到期日
        //借款起息年月日
        String countDate="";//起息日

        //出借方名称
        String lenderName = "";
        String lenderIdNo = "";
        BigDecimal lenderAmount = BigDecimal.ZERO;
        String lenderAmountChar = "";
        Double lenderRate = 0.00;
        String purpose = "";
        BigDecimal lenderInterest = BigDecimal.ZERO;
        String period = "";
        String repayMethod="";//还款方式

        String loanAmount="";//借款金额
        String loanAmountChar="";//借款金额汉子
        String loanRate="";//借款利率
        String loanInterest="";//借款利息

        List<RmbInvest> investList = null;
        List<RmbLoanRepayment> repaymentList = null;

        //借款人信息
        RmbLoanRequest request=rmbLoanRequestService.getRmbLoanRequestByLoanId(loanId);
        if(null==request){
            logger.error("标的申请信息不存在");
            return null;
        }
        purpose = rmbboxLoanApplyService.getPurpose(request.getRequestId());
        contractNo = request.getRequestId();
        if(request.getCoreUser().isEnterprise()){//企业借款用户
            loanerName=request.getCoreUser().getCompanyName();//公司名称
            loanerIdNo=request.getCoreUser().getUnifiedCode();//法人名称
        }else{//个人借款用户
            loanerName=request.getCoreUser().getUserName();//用户名称
            loanerIdNo=request.getCoreUser().getIdNumber();//证件号
        }
        signTime= DateUtils.sdf_YMD_local.format(request.getSettledTime());
        year = DateUtils.dateFormateString(request.getSettledTime(),"yyyy");
        month = DateUtils.dateFormateString(request.getSettledTime(),"M");
        day = DateUtils.dateFormateString(request.getSettledTime(),"dd");
        if (SealFileType.CreditLoanAgreementForLend.equals(fileType)){

            //投资信息
            RmbInvest invest=rmbInvestService.selectInvestByInvestIdAndUserId(investId,userId);
            if(null!=invest){
                contractNo=invest.getOrderId();
                lenderName=invest.getUser().getUserName();
                lenderIdNo=invest.getUser().getIdNumber();
            }

            if(null!=invest){
                lenderAmount=invest.getInvestAmount().setScale(2, RoundingMode.DOWN);//出借金额
                lenderAmountChar= MoneyFormateUtil.number2CNMontrayUnit(invest.getInvestAmount().setScale(2, RoundingMode.DOWN));//投资金额【大写】
                lenderRate=(Double.valueOf(invest.getLoanRate())/100);//出借利率
//                purpose=null==invest.getPurpose()?"":invest.getPurpose().getKey();//出借用途
                lenderInterest=invest.getAmountInterest().setScale(2, RoundingMode.DOWN);//出借利息
                lendDate= DateUtils.sdf_YMD_local.format(invest.getSubmitTime());//出借日期（投资时间）
                //查询借款到期日
                Date dueDate=rmbLoanRepaymentService.getDueDateByLoanId(invest.getLoanId());
                dueDateStr=null==dueDate?"": DateUtils.sdf_YMD_local.format(dueDate);//借款到期日（最后的回款时间）
                countDate= DateUtils.sdf_YMD_local.format(invest.getSettledTime());//起息日【即：标的结算时间】

                RmbLoan loan = rmbLoanService.selectByLoanId(invest.getLoanId());
                if(loan.getDays()==0){
                    period= 12*loan.getYears()+loan.getMonths()+"个月";//期限
                }else{
                    period = loan.getDays()+"天";//期限
                }
                repayMethod=invest.getRepayMethod().getKey();//还款的方式
            }
        }else if (SealFileType.CreditLoanAgreementForLoan.equals(fileType)){
            RmbLoan loan=rmbLoanService.getLoanByLoanId(loanId);
            if(null!=loan){
                loanAmount=loan.getLoanAmount().setScale(2, RoundingMode.DOWN)+"";//借款金额
                loanAmountChar= MoneyFormateUtil.number2CNMontrayUnit(loan.getLoanAmount().setScale(2, RoundingMode.DOWN));//借款金额【大写】
                loanRate=(Double.valueOf(loan.getRate())/100)+"";//借款利率
//                purpose=null==loan.getPurpose()?"":loan.getPurpose().getKey();//借款用途
                loanInterest=rmbLoanRepaymentService.getAmountInterestByloanId(loanId).setScale(2, RoundingMode.DOWN)+"";//借款利息
                lendDate= DateUtils.sdf_YMD_local.format(loan.getSettledTime());//借款日期
                //查询借款到期日
                Date dueDate=rmbLoanRepaymentService.getDueDateByLoanId(loanId);
                dueDateStr=null==dueDate?"": DateUtils.sdf_YMD_local.format(dueDate);//借款到期日（最后的回款时间）
                countDate= DateUtils.sdf_YMD_local.format(loan.getSettledTime());//起息日【即：标的结算时间】
                signTime = countDate;
                if(loan.getMonths()==0){
                    period= DateUtils.betweenDays(loan.getSettledTime(),dueDate)+"天";//期限
                }else{
                    period= loan.getMonths()+"个月";//期限
                }
                repayMethod=loan.getRepayMethod().getKey();
            }
            investList=rmbInvestService.selectInvestByLoanId(loanId);
            repaymentList=rmbLoanRepaymentService.getRmbLoanRepaymentsByLoanId(loanId);
            for (RmbLoanRepayment repayment : repaymentList) {
                repayment.setLoanAmountService(rmbboxLoanServiceRepaymentService.getLoanServiceAmountByRepaymentId(repayment.getId()));
            }
        }
        Map<String,Object> keyValue = new HashMap();
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
        keyValue.put("lenderName",lenderName);
        keyValue.put("lenderIdNo",lenderIdNo);
        keyValue.put("lenderAmount",lenderAmount);
        keyValue.put("lenderAmountChar",lenderAmountChar);
        keyValue.put("lenderRate",lenderRate);
        keyValue.put("purpose",purpose);
        keyValue.put("lenderInterest",lenderInterest);
        keyValue.put("period",period);
        keyValue.put("repayMethod",repayMethod);

        keyValue.put("loanAmount",loanAmount);
        keyValue.put("loanAmountChar",loanAmountChar);
        keyValue.put("loanRate",loanRate);
        keyValue.put("loanInterest",loanInterest);
        keyValue.put("investList",investList);
        keyValue.put("repaymentList",repaymentList);


        return PDFUtils.convertToPdfMediatorField(keyValue,fileType);
    }
}

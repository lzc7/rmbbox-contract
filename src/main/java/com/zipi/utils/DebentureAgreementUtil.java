package com.zipi.utils;

import com.zipi.entity.*;
import com.zipi.enums.RepaymentStatus;
import com.zipi.enums.SealFileType;
import com.zipi.enums.bbt.RmbRepayMethod;
import com.zipi.enums.contract.ContractType;
import com.zipi.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author linzhicheng
 * 2018年4月17日14:04:32
 * 债权转让协议util
 */
@Component
public class DebentureAgreementUtil extends BasePdfUtil{
    @Autowired
    private ContractTemplateService contractTemplateService;
    @Autowired
    private RmbboxCreditSaleService rmbboxCreditSaleService;
    @Autowired
    private RmbLoanRequestService rmbLoanRequestService;
    @Autowired
    private RmbLoanService rmbLoanService;
    @Autowired
    private RmbLoanRepaymentService rmbLoanRepaymentService;
    @Autowired
    private RmbboxCreditAssignmentService rmbboxCreditAssignmentService;
    @Autowired
    private RmbInvestRepaymentService rmbInvestRepaymentService;
    @Autowired
    private RmbboxLoanApplyService rmbboxLoanApplyService;

    public byte[] createFile(String assignmentId, String creditId, String userId, SealFileType fileType) throws Exception {
        //数据校验
        if(null==fileType){
            logger.error("债权转让协议失败：参数不足");
            throw new RuntimeException("params error");
        }

        //模版类型校验
        if(!SealFileType.AssignorAgreement.equals(fileType) && !SealFileType.AssigneeAgreement.equals(fileType)){
            logger.error("债权转让协议失败：暂不支持{}文件的生成",fileType.name());
            throw new RuntimeException("params error");
        }
        //数据校验
        if(StringUtils.isBlank(creditId) || StringUtils.isBlank(userId)){
            logger.error("债权转让协议失败：参数不足");
            throw new RuntimeException("params error");
        }

        PDFUtils.MediatorFields fields = this.info(assignmentId, creditId, userId, fileType);
        // 获取template模板
        ContractType templetType = ContractType.TEMPLET4ASSIGNOR;
        if (SealFileType.AssigneeAgreement.equals(fileType)){
            templetType = ContractType.TEMPLET4ASSIGNEE;
        }
        RmbContractTemplate template = contractTemplateService.getByType(templetType.name());
        if (null == template){
            logger.info("模板不存在");
            throw new RuntimeException("cannot find templet");
        }
        // 生成pdf
        return PDFUtils.templateToMediatorPdf(fields, template.getContent());
    }

    private PDFUtils.MediatorFields info(String assignmentId, String creditId, String userId, SealFileType fileType) throws Exception {
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
         * 出让方
         */
        String assignorName = "";
        String assignorIdNo = "";
        BigDecimal creditShare = BigDecimal.ZERO;
        String creditShareChar = "";
        BigDecimal creditInterest = BigDecimal.ZERO;//转让结息
        BigDecimal manageAmount = BigDecimal.ZERO;//转让管理费
        BigDecimal creditPrice = BigDecimal.ZERO;//最终转让价格
        BigDecimal creditInvestRate;//认购利率

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
        String openDate = "";//借款日期
        String dueDateStr="";//借款到期日


        List<Map> assignList = null;

        //受让方
        String lenderName = "";
        String lenderIdNo = "";
        BigDecimal lenderAmount = BigDecimal.ZERO;
        String lenderAmountChar = "";
        BigDecimal lenderInterest = BigDecimal.ZERO;
        String lenderInterestChar = "";
        String guarantorName="";//认购期限(借用字段)



        RmbboxCreditSale creditSale = rmbboxCreditSaleService.queryByIdWithUserInfo(Long.valueOf(creditId));
        if (null == creditSale) throw new RuntimeException("债权不存在，creditId="+creditId);

        //借款人信息
        RmbLoanRequest request=rmbLoanRequestService.getRmbLoanRequestByLoanId(creditSale.getLoanId());
        if(null==request){
            logger.error("标的申请信息不存在");
            throw new RuntimeException("标的申请信息不存在");
        }

        RmbLoan loan=rmbLoanService.getLoanByLoanId(creditSale.getLoanId());
        Date dueDate = null;
        if(null!=loan){
            loanAmount=loan.getLoanAmount().setScale(2, RoundingMode.DOWN)+"";//借款金额
            loanAmountChar= MoneyFormateUtil.number2CNMontrayUnit(loan.getLoanAmount().setScale(2, RoundingMode.DOWN));//借款金额【大写】
            loanRate=(Double.valueOf(loan.getRate())/100)+"";//借款利率
            purpose=rmbboxLoanApplyService.getPurpose(loan.getRequestId());//借款用途
            loanInterest=rmbLoanRepaymentService.getAmountInterestByloanId(creditSale.getLoanId()).setScale(2, RoundingMode.DOWN)+"";//借款利息
            openDate= DateUtils.sdf_YMD_local.format(loan.getOpenTime());//借款日期
            //查询借款到期日
            dueDate=rmbLoanRepaymentService.getDueDateByLoanId(creditSale.getLoanId());
            dueDateStr=null==dueDate?"": DateUtils.sdf_YMD_local.format(dueDate);//借款到期日（最后的回款时间）
            countDate= DateUtils.sdf_YMD_local.format(loan.getSettledTime());//起息日【即：标的结算时间】
            if(loan.getMonths()==0){
                period= DateUtils.betweenDays(loan.getSettledTime(),dueDate)+"天";//期限
            }else{
                period= loan.getMonths()+"个月";//期限
            }
            repayMethod=loan.getRepayMethod().getKey();
        }


        if(request.getCoreUser().isEnterprise()){//企业借款用户
            loanerName=request.getCoreUser().getCompanyName();//公司名称
            loanerIdNo=request.getCoreUser().getUnifiedCode();//法人名称
        }else{//个人借款用户
            loanerName=request.getCoreUser().getUserName();//用户名称
            loanerIdNo=request.getCoreUser().getIdNumber();//证件号
        }
        signTime= DateUtils.sdf_YMD_local.format(creditSale.getSettledTime());
        year = DateUtils.dateFormateString(creditSale.getSettledTime(),"yyyy");
        month = DateUtils.dateFormateString(creditSale.getSettledTime(),"M");
        day = DateUtils.dateFormateString(creditSale.getSettledTime(),"dd");
        assignorName = creditSale.getUserName();
        assignorIdNo = creditSale.getIdNumber();
        creditInvestRate = creditSale.getInvestRate().setScale(2,RoundingMode.DOWN);
        String title = "个人借款债权转让协议";
        if (SealFileType.AssigneeAgreement.equals(fileType)){
            title = title+assignmentId;
            RmbboxCreditAssignment assignment = rmbboxCreditAssignmentService.queryByIdWithUserInfo(Integer.valueOf(assignmentId));
            if (null == assignment) throw new RuntimeException("error");
            contractNo = assignment.getOrderId();
            lenderName = assignment.getUserName();
            lenderIdNo = assignment.getIdNumber();
            lenderAmount = assignment.getAmount();
            lenderAmountChar = MoneyFormateUtil.number2CNMontrayUnit(lenderAmount);//借款金额【大写】
            lenderInterest = assignment.getCreditInterest();
            lenderInterestChar = MoneyFormateUtil.number2CNMontrayUnit(lenderInterest);//借款金额【大写】
            Map<String, Integer> map = this.queryRemainPeriod(creditSale.getSettledTime(),loan, dueDate,creditSale.getInvestId());
            if (0<map.get("months")){
                guarantorName= map.get("months")+"个月"+map.get("days")+"天";//认购期限(借用字段)
            }else {
                guarantorName= map.get("days")+"天";//认购期限(借用字段)
            }

        }else if (SealFileType.AssignorAgreement.equals(fileType)){
            title = title+creditId;
            creditInterest = creditSale.getCreditInterest();
            manageAmount = creditSale.getManageAmount();
            contractNo = creditSale.getRequestNo();
            assignList=rmbboxCreditAssignmentService.queryAssignInfo(creditSale.getId());
            //出让方信息

            creditShare = creditSale.getSubscribeAmount();
            creditShareChar = MoneyFormateUtil.number2CNMontrayUnit(creditShare);//【大写】
            creditPrice = creditShare.multiply(creditSale.getRate()).divide(new BigDecimal("100"),2,RoundingMode.HALF_UP);
        }

        Map<String,Object> keyValue = new HashMap();
        keyValue.put("orderId",contractNo);
        keyValue.put("loanerName",loanerName);
        keyValue.put("loanerIdNumber",loanerIdNo);
        keyValue.put("year",year);
        keyValue.put("month",month);
        keyValue.put("day",day);
        keyValue.put("signTime",signTime);

        keyValue.put("lendDate",openDate);
        keyValue.put("dueDateStr",dueDateStr);
        keyValue.put("countDate",countDate);
        keyValue.put("purpose",purpose);
        keyValue.put("period",period);
        keyValue.put("repayMethod",repayMethod);

        keyValue.put("loanAmount",loanAmount);
        keyValue.put("loanAmountChar",loanAmountChar);
        keyValue.put("loanRate",loanRate);
        keyValue.put("loanInterest",loanInterest);

        keyValue.put("creditInterest",creditInterest);
        keyValue.put("assignorName",assignorName);
        keyValue.put("assignorIdNo",assignorIdNo);
        keyValue.put("creditShare",creditShare);
        keyValue.put("creditShareChar",creditShareChar);
        keyValue.put("manageAmount",manageAmount);
        keyValue.put("creditPrice",creditPrice);
        keyValue.put("creditInvestRate",creditInvestRate+"%");
        keyValue.put("assignList",assignList);

        keyValue.put("lenderName",lenderName);
        keyValue.put("lenderIdNo",lenderIdNo);
        keyValue.put("lenderAmount",lenderAmount);
        keyValue.put("lenderAmountChar",lenderAmountChar);
        keyValue.put("guarantorName",guarantorName);
        keyValue.put("lenderInterest",lenderInterest);
        keyValue.put("feeChar",lenderInterestChar);//征用字段

        keyValue.put("title",title);//征用字段


        return PDFUtils.convertToPdfMediatorField(keyValue,fileType);
    }

    /**
     * 查询剩余期限
     * @param rmbLoan
     * @return
     */
    private Map<String,Integer> queryRemainPeriod(Date settleTime,RmbLoan rmbLoan,Date dueDate,String investId){
        Map<String,Integer> resultMap = new HashMap();
        Date nowDate = new Date();
        int days = 0;
        int months = 0;
        int years = rmbLoan.getYears();
        try {
            if(RmbRepayMethod.BulletRepayment.equals(rmbLoan.getRepayMethod())){
                days = DateUtils.betweenDays(settleTime,dueDate);
            }else{
                List<RmbInvestRepayment> repaymentList = rmbInvestRepaymentService.getByInvestId(investId);
                if(!CollectionUtils.isEmpty(repaymentList)){
                    for(int i=0;i<repaymentList.size();i++){
                        RmbInvestRepayment rmbInvestRepayment = repaymentList.get(i);
                        if(RepaymentStatus.UNDUE.equals(rmbInvestRepayment.getRepayStatus())){
                            //第一期
                            if(i==0){
                                months = years*12+rmbLoan.getMonths()-rmbInvestRepayment.getCurrentPeriod();
                                days = DateUtils.betweenDays(settleTime,rmbInvestRepayment.getDueDate());
                            }else{
                                int result = DateUtils.betweenDays(repaymentList.get(i-1).getDueDate(),settleTime);
                                //如果当天刚好是还款日，则直接记录剩下的月数，不记录剩余天数
                                if(0==result){
                                    months = years*12+rmbLoan.getMonths()-repaymentList.get(i-1).getCurrentPeriod();
                                }else{
                                    months = years*12+rmbLoan.getMonths()-rmbInvestRepayment.getCurrentPeriod();
                                    days = DateUtils.betweenDays(settleTime,rmbInvestRepayment.getDueDate());
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }catch (Exception e){
            logger.error(",",e);
        }
        resultMap.put("months",months);
        resultMap.put("days",days);
        return resultMap;
    }

}

package com.zipi.modules.contract.controller;

import com.zipi.core.util.FileUtils;
import com.zipi.modules.contract.entity.*;
import com.zipi.modules.contract.enums.ContractType;
import com.zipi.modules.contract.enums.LoanRequestTypes;
import com.zipi.modules.contract.enums.SealFileType;
import com.zipi.modules.contract.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;

@Slf4j
@RestController
public class ContractController {

    @Autowired
    private SealAutoService sealAutoPdfImpl;

    @Autowired
    private RmbLoanRequestService rmbLoanRequestService;

    @Autowired
    private RmbInvestService investService;

    @Autowired
    private RmbboxLoanAppointmentService rmbboxLoanAppointmentService;

    @Autowired
    private RmbboxCreditSaleService rmbboxCreditSaleService;
    @Autowired
    private RmbboxCreditAssignmentService rmbboxCreditAssignmentService;

    /**
     * 获得自动出借协议
     * @param appointmentId
     * @param response
     */
    @RequestMapping("/appointment/contract/{appointmentId}")
    public void getAppointmentAgreement(@PathVariable("appointmentId") String appointmentId, HttpServletResponse response) {
        response.setContentType("application/pdf");
        OutputStream output=null;
        InputStream in = null;
        try {
            RmbboxLoanAppointment appointment = rmbboxLoanAppointmentService.selectByPrimaryKey(appointmentId);
            byte[] file = sealAutoPdfImpl.getLoanAgreement(appointmentId,null,appointment.getUserId(), SealFileType.AppointmentAgreement);
            if (file == null || file.length == 0) return;
            response.addHeader("Content-Disposition", "inline; filename=" + URLEncoder.encode("自动出借服务协议".concat(".pdf"), "UTF-8"));
            response.setContentLength(file.length);
            output= response.getOutputStream();
            in = new BufferedInputStream(new ByteArrayInputStream(file));
            int len;
            byte[] buf = new byte[file.length];
            while ((len = in.read(buf)) != -1) {
                output.write(buf, 0, len);
            }
            output.flush();
        } catch (Exception e) {
            log.error("获得自动出借服务协议失败:",e);
        } finally{
            try {
                if(null!=output)output.close();

            } catch (IOException e) {
                output = null;
                log.error("获得自动出借服务协议失败:",e);
            }
            if (null != in) try {
                in.close();
            } catch (IOException e) {
                in = null;
                log.error("获得自动出借服务协议失败:",e);
            }
        }
    }

    /**
     * 获取代偿合同
     * @param repaymentId
     * @param response
     */
    @RequestMapping("forCompensator/{repaymentId}")
    public void  getCompensatorAgreement(@PathVariable("repaymentId") String repaymentId,HttpServletResponse response){
        //设置文件类型
        String fileName="借款代偿协议";
        response.setContentType("application/pdf");
        byte []file=null;
        try {
            file=sealAutoPdfImpl.getLoanAgreement(null,repaymentId,null,SealFileType.AgreementForCompensator);
            FileUtils.createFile(response,file,repaymentId,fileName);
        } catch (Exception e) {
            log.error("借款代偿协议生成失败！！！",e);
        }
    }


    /**
     * 获得个人借款债权转让协议-受让人
     * @param assignmentId
     * @param response
     */
    @RequestMapping("/assignSale/contract/{assignmentId}")
    public void  getAssignSaleAgreement(@PathVariable("assignmentId") int assignmentId,HttpServletResponse response){
        RmbboxCreditAssignment assignment = rmbboxCreditAssignmentService.selectByPrimaryKey(assignmentId);
        if(null==assignment)return;
        //设置文件类型
        String fileName="个人借款债权转让协议-受让方";
        response.setContentType("application/pdf");
        try {
            byte[] file=sealAutoPdfImpl.getLoanAgreement(assignmentId+"",assignment.getCreditId()+"",assignment.getUserId(),SealFileType.AssigneeAgreement);
            FileUtils.createFile(response,file,assignmentId+"",fileName);
        } catch (Exception e) {
            log.error("受让方债权转让协议生成失败！！！",e);
        }
    }

    /**
     * 获得个人借款债权转让协议-出让人
     * @param creditId
     * @param response
     */
    @RequestMapping("/creditSale/contract/{creditId}")
    public void  getCreditSaleAgreement(@PathVariable("creditId") long creditId,HttpServletResponse response){
        RmbboxCreditSale creditSale = rmbboxCreditSaleService.selectByPrimaryKey(creditId);
        if(null == creditSale)return;
        //设置文件类型
        String fileName="个人借款债权转让协议-出让方";
        response.setContentType("application/pdf");
        try {
            byte[] file=sealAutoPdfImpl.getLoanAgreement(null,creditId+"",creditSale.getUserId(),SealFileType.AssignorAgreement);
            FileUtils.createFile(response,file,creditId+"",fileName);
        } catch (Exception e) {
            log.error("出让方债权转让协议生成失败！！！",e);
        }
    }


    /**
     * 获得出借人借款协议
     * @param investId
     * @param response
     */
    @RequestMapping("/invest/contract/{investId}")
    public void getInvestAgreement(@PathVariable("investId") String investId,HttpServletResponse response) {
        response.setContentType("application/pdf");
        OutputStream output=null;
        try {
            RmbInvest invest=investService.getInvestInfoByInvetId(investId);
            if(null==invest)return;
            byte[] file=null;
            //文件的权限验证
            if(LoanRequestTypes.C_D_B.equals(invest.getRequestType())){
                //车贷标
                file=sealAutoPdfImpl.getLoanAgreement(investId,invest.getLoanId(),invest.getUserId(),SealFileType.CarLoanAgreementForLend);
            }else if(LoanRequestTypes.X_D_B.equals(invest.getRequestType()) || LoanRequestTypes.P_X_D_B.equals(invest.getRequestType())){
                //信贷标
                file=sealAutoPdfImpl.getLoanAgreement(investId,invest.getLoanId(),invest.getUserId(),SealFileType.CreditLoanAgreementForLend);
            }
            if (file == null || file.length == 0)return ;
            response.addHeader("Content-Disposition", "inline; filename=" + URLEncoder.encode("借款协议".concat(".pdf"), "UTF-8"));
            response.setContentLength(file.length);
            output= response.getOutputStream();
            InputStream in = new BufferedInputStream(new ByteArrayInputStream(file));
            int len;
            byte[] buf = new byte[file.length];
            while ((len = in.read(buf)) != -1) {
                output.write(buf, 0, len);
            }
            output.flush();
        } catch (Exception e) {
            log.error("获得借款协议失败:",e);
        }finally{
            try {
                if(null!=output)output.close();
            } catch (IOException e) {
                log.error("获得借款协议失败:",e);
            }
        }
    }


    /**
     * 获得借款人借款协议
     * @param loanId
     * @param response
     */
    @RequestMapping("/loan/contract/{loanId}")
    public void  getLoanAgreementForMG(@PathVariable("loanId") String loanId,HttpServletResponse response){
        //查询借款类型
        LoanRequestTypes requestTypes=rmbLoanRequestService.getLoanRequestTypesByLoanId(loanId);
        //设置文件类型
        String fileName="借款方借款协议";
        response.setContentType("application/pdf");
        byte []file=null;
        try {
            if(null!=requestTypes){
                if(LoanRequestTypes.C_D_B.equals(requestTypes)){
                    file=sealAutoPdfImpl.getLoanAgreement(null,loanId,null, SealFileType.CarLoanAgreementForLoan);
                }else if(LoanRequestTypes.X_D_B.equals(requestTypes) || LoanRequestTypes.P_X_D_B.equals(requestTypes)){
                    //信贷标
                    file=sealAutoPdfImpl.getLoanAgreement(null,loanId,null,SealFileType.CreditLoanAgreementForLoan);
                }
                FileUtils.createFile(response,file,loanId,fileName);
            }
        } catch (Exception e) {
            log.error("借款方借款协议生成失败！！！",e);
        }
    }

    @Autowired
    private CacheManagerService cacheManagerService;
    @Autowired
    private ContractTemplateService contractTemplateService;
    @Autowired
    private CoreSealFlieService coreSealFlieService;
    @RequestMapping("test")
    public void test(){


        coreSealFlieService.testTransaction();

// 获取template模板
        String contractType = ContractType.TEMPLET4COMPENSATORY.name();
        RmbContractTemplate template = contractTemplateService.getByType(contractType);
        cacheManagerService.set("test1","20180710",600);
        String tes1 = cacheManagerService.get("test1");
        System.out.println(tes1);


    }
}

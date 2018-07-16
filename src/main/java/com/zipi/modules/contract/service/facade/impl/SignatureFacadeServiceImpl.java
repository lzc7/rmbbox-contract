package com.zipi.modules.contract.service.facade.impl;

import com.alibaba.fastjson.JSON;
import com.zipi.core.util.DateUtils;
import com.zipi.modules.base.enums.FundRecordStatus;
import com.zipi.modules.contract.entity.CoreSealFlie;
import com.zipi.modules.contract.entity.CoreUser;
import com.zipi.modules.contract.entity.RmbLoanRepayment;
import com.zipi.modules.contract.entity.Signature;
import com.zipi.modules.contract.enums.SealFileType;
import com.zipi.modules.contract.enums.CertificateType;
import com.zipi.modules.contract.service.*;
import com.zipi.modules.contract.service.facade.SignatureFacadeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.File;
import java.util.Date;
import java.util.Map;

/**
 * author linzhicheng
 * 2018年7月6日13:15:21
 */
@Slf4j
@Service
public class SignatureFacadeServiceImpl implements SignatureFacadeService {
    private static final String DOC_TITLE = "出借咨询与服务协议";
    private static final String DOC_TYPE = ".pdf";
//
    private static final String SIGNATURE_KEY = "signatureKey:";
    private static final String REGISTER_CA = "fdd_register_ca:";
    private String templateFile;
    @Autowired
    private SignatureService signatureService;
//
    @Autowired
    private CoreSealFlieService coreSealFlieService;
//
    @Autowired
    private CacheManagerService cacheManagerService;
//
//    @Autowired
//    private AssetService assetService;
//
//    @Autowired
//    private ClaimUtils claimUtils;
//
    @Autowired
    private UserService userService;
    @Autowired
    private RmbInvestService rmbInvestService;
//    @Autowired
//    private RmbLoanRequestService rmbLoanRequestService;
    @Autowired
    private RmbboxLoanAppointmentService rmbboxLoanAppointmentService;
    @Autowired
    private RmbboxCreditAssignmentService rmbboxCreditAssignmentService;
    @Autowired
    private RmbboxCreditSaleService rmbboxCreditSaleService;
    @Autowired
    private RmbLoanRepaymentService repaymentService;
//
//    @Override
    @Transactional(rollbackFor = Exception.class)
    public Signature uploadDocs(String fildId, String[] signKeywords) throws Exception{
        /**
         * 1.上传文件
         * 2.更新tb_core_seal_flie表flag_seal为ture
         * 3.tb_core_signature插入数据
         */
        CoreSealFlie coreSealFlie = coreSealFlieService.selectByPrimaryKey(fildId);
        if (null == coreSealFlie){
            log.error("协议fildId：{} 对应记录不存在", fildId);
            throw new RuntimeException("协议文件不存在");
        }

        if (coreSealFlie.isFlagSeal()){
            log.error("file_id：{}对应协议已签章", fildId);
            throw new RuntimeException("协议已签章");
        }
        Signature signatureRecord = signatureService.selectSignatureRecoredByFileId(fildId);
        if (null != signatureRecord){//表示已上传成功过，跳过此步
            log.error("协议fild_id：{}已存在，跳过上传步骤", fildId);
            return signatureRecord;
        }

        Signature signature = new Signature();

        Date date = new Date();
        //请求时间
        String timeStamp = DateUtils.dateFormateString(date, "yyyyMMddHHmmss");
        //合同编号（使用文件id，去掉-）
        String contractId = coreSealFlie.getFileId().replace("-", "");
        //文件
        String filePath = templateFile + coreSealFlie.getFilePath() + File.separator + coreSealFlie.getFileName();
        File file = new File(filePath);
        Assert.isTrue(file.exists(), file+"：认购协议文件未生成");

        //下载时使用
        cacheManagerService.set(SIGNATURE_KEY+coreSealFlie.getFileId(),filePath,600);

        /**上传法大大*/
        String response = "";
        log.info("协议上传法大大结果：{}", response);
        Map result = JSON.parseObject(response, Map.class);
        //状态码1000表示本次上传成功，2002表示已经上传成功
        if ("1000".equals(result.get("code")) || "2002".equals(result.get("code"))) {

            //签章数据
            Date signatureDate = new Date();
            String signatureTimeStamp = DateUtils.dateFormateString(signatureDate, "yyyyMMddHHmmss");
            signature.setCreateTime(signatureDate);
            signature.setUpdateTime(signatureDate);
            signature.setTimeStamp(signatureTimeStamp);
            signature.setDescription("签章");
            signature.setTradeStatus(FundRecordStatus.INITIALIZED);
            signature.setInvestId(coreSealFlie.getInvestId());
            signature.setContractId(contractId);
            signature.setFileId(coreSealFlie.getFileId());
            signature.setDocTitle(DOC_TITLE);
            signature.setSignKeyword(signKeywords[0]);
            signature.setSealNo(1);
            signatureService.insert(signature);

        }
        log.info("协议fild_id：{}上传成功", fildId);

        return signature;
    }
//
//    @Override
    @Transactional(rollbackFor = Exception.class)
    public void signatureDocs(Signature signature, String[] costomerNo, String[] signKeywords, String[] clientType) {
        /**
         * 1.查询待签名的合同
         * 2.法大大签名合同
         * 3.更改状态
         */
        //过滤三次已签章成功的记录
        Assert.notNull(signature, "signatureDocs 上送参数为空");
        if (!FundRecordStatus.SUCCESSFUL.name().equals(signature.getTradeStatus().name())){
            for (int i = signature.getSealNo(); i <= costomerNo.length; i++){//每条协议需要签章三次
                String customer_no = costomerNo[i-1];

                Date date = new Date();
                String timeStamp = DateUtils.dateFormateString(date,"yyyyMMddHHmmss");
                String sign_keyword = signKeywords[i-1];
                log.info("协议file_id：{}签章上送参数：客户类型{}，合同编号{}，客户编号{}", signature.getFileId(), clientType[i-1],
                        signature.getContractId(), customer_no);
                /**法大大签章*/
                String response = "";

                Map result = JSON.parseObject(response,Map.class);
                log.info("协议签章返回结果："+response);
                if ("1000".equals(result.get("code"))){
                    int count = 0;
                    if(i < costomerNo.length){
                        count = signatureService.updateSignatureStatus(FundRecordStatus.INITIALIZED,null, date, timeStamp,
                                sign_keyword, i, signature.getTransactionId());
                    }else if (i == costomerNo.length){
                        count = signatureService.updateSignatureStatus(FundRecordStatus.INITIALIZED, FundRecordStatus.SUCCESSFUL, date, timeStamp,
                                sign_keyword, i, signature.getTransactionId());
                    }
                    if (count != 1){
                        log.error("协议file_id：{}签{}号章，更新数据库状态失败", signature.getFileId(), i);
                        throw new RuntimeException("协议文件签章失败");
                    }
                }else {
                    break;
                }
            }
        }else {
            log.info("协议file_id：{} 已签过章", signature.getFileId());
        }

    }
//
//    @Override
    @Transactional(rollbackFor = Exception.class)
    public void downloadDocs(Signature signature) {
        /**
         * 1.查询协议签完3个章的记录
         * 2.下载文件放到指定目录
         */
        Assert.notNull(signature,"downloadDocs 上送参数为空");
        Signature signatureRecord = signatureService.selectSignatureRecoredByFileId(signature.getFileId());
        if (!FundRecordStatus.SUCCESSFUL.name().equals(signatureRecord.getTradeStatus().name())){
            log.error("协议file_id：{}签章未完成,无法下载文件", signatureRecord.getFileId());
            throw new RuntimeException("协议签章未完成,无法下载文件");
        }


        String fileName = cacheManagerService.get(SIGNATURE_KEY + signatureRecord.getFileId());
        if (StringUtils.isBlank(fileName)){
            CoreSealFlie coreSealFlie = coreSealFlieService.selectByPrimaryKey(signatureRecord.getFileId());
            if (null != coreSealFlie){
                fileName = templateFile + coreSealFlie.getFilePath() + File.separator + coreSealFlie.getFileName();
            }
        }

        //更新下载状态
        int count = coreSealFlieService.updateAgreementStatus(signatureRecord.getFileId());
        if (count == 1) {
            // 成功需要覆盖原文件
//            FddClientBase.invokeDownloadPdf(signatureRecord.getContractId(), signatureRecord.getTimeStamp(), fileName);
            log.info("协议file_id：{}签章下载成功，目录{}", signatureRecord.getFileId(), fileName);
        }

    }
//
//    /**
//     * 个人CA证书申请
//     * @param investId
//     * @return
//     */
//    public String registerCA(String investId){
//        AssetInvest assetInvest = assetService.selectInvestByInvestId(investId);
//        CoreUser coreUser = userService.findById(assetInvest.getUserId());
//        log.info("userName：{}，idNumber：{}", coreUser.getUserName(),coreUser.getIdNumber());
//        String response = FddClientBase.invokeSyncPersonAuto(coreUser.getUserName(),null,coreUser.getIdNumber(),"0",coreUser.getUserMobile());
//        Map result = JSON.parseObject(response, Map.class);
//        if (!"1000".equals(result.get("code"))){
//            log.error("法大大申请人个CA异常：{}", response);
//            throw new RuntimeException("个人申请CA异常");
//        }
//        cacheManagerService.set(REGISTER_CA+investId, coreUser.getUserName(),600);
//        String customerId = result.get("customer_id")+"";
//        log.info("investId：{}，customerId：{}", investId, customerId);
//        return customerId;
//    }
//
//
    /**
     * 合同归档
     * @param contractId
     */
    public void archiveContract(String contractId){

        String response = "";
        Map result = JSON.parseObject(response, Map.class);
        if (!"1000".equals(result.get("code"))){
            log.error("法大大合同归档异常：{}", response);
            throw new RuntimeException("法大大合同归档异常");
        }
        log.info("合同归档成功");
    }
//
    @Transactional(rollbackFor = Exception.class)
    public void signatureComposite(CoreSealFlie coreSealFlie) throws Exception{
        String[] signKeywords = null;//默认为认购协议内容
        String[] costomerNo = null;//客户编号
        String[] clientType = null;//客户类型
        String customerId ="";//个人CA证书申请
        String personKey ="";//个人签章位置
        if (SealFileType.CarLoanMediatorContract.name().equals(coreSealFlie.getFileType())
                ||SealFileType.AppointmentAgreement.name().equals(coreSealFlie.getFileType())){
            CoreUser user = null;
            if (SealFileType.CarLoanMediatorContract.name().equals(coreSealFlie.getFileType())){
                user = rmbInvestService.selectEnterpriseInfoByLoanId(coreSealFlie.getInvestId());
            }else {
                user = rmbboxLoanAppointmentService.queryEnterpriseInfoByAppointmentId(coreSealFlie.getInvestId());
            }
            if (null == user ) throw new RuntimeException("no user fund");
            signKeywords = new String[]{"乙方签章处","甲方签章处"};
            if(user.isEnterprise()){//企业用户
                costomerNo = new String[]{};
                clientType = new String[]{"2","2"};
            }else {//个人用户
                //个人借款人的签章
                String loanerId=registerCA(user.getUserName(),user.getIdNumber(),user.getUserMobile(),user.getUserId());
                costomerNo = new String[]{};
                clientType = new String[]{"2","1"};
            }
        }else if (SealFileType.CreditLoanAgreementForLend.name().equals(coreSealFlie.getFileType())||
                SealFileType.AssigneeAgreement.name().equals(coreSealFlie.getFileType())){
//            CoreUser user;
//            if (SealFileType.CreditLoanAgreementForLend.name().equals(coreSealFlie.getFileType())){
//                user=rmbInvestService.selectEnterpriseInfoByInvestId(coreSealFlie.getInvestId());
//            }else {
//                user = rmbboxCreditAssignmentService.queryEnterpriseInfoByAssignmentId(Integer.valueOf(coreSealFlie.getInvestId()));
//            }
//            customerId = registerCA(coreSealFlie.getInvestId(),user.getUserId());
//            signKeywords = new String[]{"棒棒糖签章处","乙方签章处","甲方签章处"};
//            if(user.isEnterprise()){//企业用户
//                costomerNo = new String[]{FddConstantCommon.BBT_CUSTOMER_NO.getValue(),user.getCustomerNo(),customerId};
//                clientType = new String[]{"2","2","1"};
//            }else {//个人用户
//                //个人借款人的签章
//                String loanerId=registerCA(user.getUserName(),user.getIdNumber(),user.getUserMobile(),user.getUserId());
//                costomerNo = new String[]{FddConstantCommon.BBT_CUSTOMER_NO.getValue(),loanerId,customerId};
//                clientType = new String[]{"2","1","1"};
//            }
        }else if (SealFileType.AgreementForGuarantor.name().equals(coreSealFlie.getFileType())){
//            RmbLoanRequest request=rmbLoanRequestService.getRmbLoanRequestByLoanId(coreSealFlie.getInvestId());
//            CoreUser loaner = request.getCoreUser();
//            String loanerId = "",compensatoryId = "";
//            String loanerType = "1",compensatorType = "1";
//            if (loaner.isEnterprise()){
//                loanerId = loaner.getCustomerNo();
//                loanerType = "2";
//            }else {
//                loanerId = registerCA(coreSealFlie.getInvestId(),request.getUserId());
//            }
//            CoreUser compensatory = userService.findById(request.getCompensatoryId());
//            if (compensatory.isEnterprise()){
//                compensatoryId = compensatory.getCustomerNo();
//                compensatorType = "2";
//            }else {
//                compensatoryId = registerCA(coreSealFlie.getInvestId(),compensatory.getUserId());
//            }
//            signKeywords = new String[]{"借款方盖章处","担保方盖章处"};
//            costomerNo = new String[]{loanerId,compensatoryId};
//            clientType = new String[]{loanerType,compensatorType};
        }else if (SealFileType.AgreementForCompensator.name().equals(coreSealFlie.getFileType())){
            RmbLoanRepayment repayment = repaymentService.queryByloanRepaymentId(coreSealFlie.getInvestId());
            CoreUser loaner = userService.findById(repayment.getLoanerId());
            String loanerId = "",compensatoryId = "";
            String loanerType = "1",compensatorType = "1";
            if (loaner.isEnterprise()){
                loanerId = loaner.getCustomerNo();
                loanerType = "2";
            }else {
                loanerId = registerCA(coreSealFlie.getInvestId(),repayment.getLoanerId());
            }
            CoreUser compensatory = userService.findById(repayment.getActCompensatoryId());
            if (compensatory.isEnterprise()){
                compensatoryId = compensatory.getCustomerNo();
                compensatorType = "2";
            }else {
                compensatoryId = registerCA(coreSealFlie.getInvestId(),compensatory.getUserId());
            }
            signKeywords = new String[]{"邦帮堂盖章处","借款方盖章处","代偿方盖章处"};
            costomerNo = new String[]{};
            clientType = new String[]{"2",loanerType,compensatorType};
        }

        /**上传文件*/
        Signature signature = this.uploadDocs(coreSealFlie.getFileId(), signKeywords);

        /**协议签章*/
        this.signatureDocs(signature, costomerNo, signKeywords, clientType);

        /**协议下载*/
        this.downloadDocs(signature);

        /**合同归档*/
        this.archiveContract(signature.getContractId());

    }

    /**
     * 个人CA证书申请
     * @param id
     * @param userId
     * @return
     */
    public String registerCA(String id,String userId){
        CoreUser coreUser = userService.findById(userId);
        log.info("userName：{}，idNumber：{}", coreUser.getUserName(),coreUser.getIdNumber());
        String identType = "0";
        if (coreUser.getCertificateType().equals(CertificateType.PASSPORT)) {
            identType = "1";
        }else if (coreUser.getCertificateType().equals(CertificateType.COMPATRIOTS_CARD)) {
            identType = "B";
        }else if(coreUser.getCertificateType().equals(CertificateType.PERMANENT_RESIDENCE)){

        }
        String response = "";
        Map result = JSON.parseObject(response, Map.class);
        if (!"1000".equals(result.get("code"))){
            log.error("法大大申请人个CA异常：{}", response);
            throw new RuntimeException("个人申请CA异常");
        }
        cacheManagerService.set(REGISTER_CA+id, coreUser.getUserName(),600);
        String customerId = result.get("customer_id")+"";
        log.info("id：{}，customerId：{}",id, customerId);
        return customerId;
    }


    public String registerCA(String userName,String idNumber,String userMobile,String userId){

        log.info("userName：{}，idNumber：{},userMobile：{}，",userName,idNumber,userMobile);
        CoreUser coreUser = userService.findById(userId);
        log.info("userId：{}，userName：{},",coreUser.getUserId(),coreUser.getUserName());
        String identType = "0";
        if (coreUser.getCertificateType().equals(CertificateType.PASSPORT)) {
            identType = "1";
        }else if (coreUser.getCertificateType().equals(CertificateType.COMPATRIOTS_CARD)) {
            identType = "B";
        }else if(coreUser.getCertificateType().equals(CertificateType.PERMANENT_RESIDENCE)){

        }
        log.info("identType：{} ==",identType);
        String response = "";
        Map result = JSON.parseObject(response, Map.class);
        if (!"1000".equals(result.get("code"))){
            log.error("法大大申请人个CA异常：{}", response);
            throw new RuntimeException("个人申请CA异常");
        }
        return result.get("customer_id")+"";
    }
//
//
//
//    @Override
//    public List<CoreSealFlie> selectUnSignatureFile(SealFileType fileType) {
//        return coreSealFlieService.selectUnSignatureFile(fileType);
//    }
//
    /**初始化路径*/
    {
        templateFile = new File("").getAbsolutePath();
        //windows下
        if ("\\".equals(File.separator)) {
            templateFile = templateFile.substring(0, templateFile.indexOf("\\"));
            templateFile = templateFile.replace("/", "\\");
        }
        //linux下
        else if ("/".equals(File.separator)) {
            templateFile = System.getProperty("user.dir");
            templateFile = templateFile.substring(0, templateFile.indexOf("/"));
            templateFile = templateFile.replace("\\", "/");
        }
        templateFile = templateFile+File.separator+"data"+File.separator+"sealfile"+File.separator;
        log.info("templateFile****is*******" + templateFile);
    }
}

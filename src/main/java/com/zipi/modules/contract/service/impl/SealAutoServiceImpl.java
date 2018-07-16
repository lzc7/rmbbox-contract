package com.zipi.modules.contract.service.impl;

import cfca.seal.servlet.SealClient;
import com.zipi.core.util.FileUtil;
import com.zipi.modules.contract.entity.CoreSealFlie;
import com.zipi.modules.contract.entity.CoreSealFlieExample;
import com.zipi.modules.contract.enums.SealFileType;
import com.zipi.modules.contract.service.CoreSealFlieService;
import com.zipi.modules.contract.service.SealAutoService;
import com.zipi.modules.contract.service.facade.SignatureFacadeService;
import com.zipi.modules.contract.utils.AppointmentAgreementUtil;
import com.zipi.modules.contract.utils.CompensatorAgreementUtil;
import com.zipi.modules.contract.utils.CreditLoanAgreementUtil;
import com.zipi.modules.contract.utils.DebentureAgreementUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.Date;
import java.util.List;
@Slf4j
@Service
public class SealAutoServiceImpl implements SealAutoService {

	//请求服务地址
	//测试地址：http://preview.rmbbox.com:8090/Seal
	//本地：http://192.168.40.77:8090/Seal
	//正式环境：http://10.10.156.39:8090/Seal
	private static final String SERVER_URL="http://10.10.156.39:8090/Seal"+ SealClient.SLASH + SealClient.PDF_SEAL_SERVLET;
	
	private static final String type = "3";
	private static final String pdfURL = "";
	private static final String sealCode = "bjzpcf20160325_seal";
//	private static final String sealCode = "ZPCF";
	private static final String sealPassword = "xmrxcf#zipikeji";
	private static final String sealPerson = "admin";
	private static final String sealLocation = "北京";
	private static final String sealResson = "合同签署";
	private static final String businessCode = "";
	private static final String blankFieldName = "Signature11";
	private static final String page = "";// 支持（1）单页，（1,2,3,4）多页,（1-3）区间，（0）所有页
	private static final String lX = "10";
	private static final String lY = "10";
//	private static String keyword = "紫貔财富网络科技有限公司";
	private static String keyword3 = "丙方(平台)";
	private static String locationStyle = "C";
	private static String locationStyle2= "R";
	private static final String offsetX = "0";
	private static final String offsetY = "0";
	
	@Autowired
	private CoreSealFlieService coreSealFlieService;
	
    @Autowired
    private SignatureFacadeService signatureFacadeService;
	@Autowired
	private CreditLoanAgreementUtil creditLoanAgreementUtil;
	@Autowired
	private AppointmentAgreementUtil appointmentAgreementUtil;
	@Autowired
	private DebentureAgreementUtil debentureAgreementUtil;
	@Autowired
	private CompensatorAgreementUtil compensatorAgreementUtil;

	private static  String templateFile=null;
	
	private static String gettemplateFile(){
		 /****path*******/
         //templateFile=new SealAutoServceImpl().getClass().getResource("/").getPath();
		templateFile = new File("").getAbsolutePath();
		//windows下
		if("\\".equals(File.separator)){
			templateFile = templateFile.substring(0,templateFile.indexOf("\\"));
			templateFile = templateFile.replace("/", "\\");
		}
		//linux下
		if("/".equals(File.separator)){
			templateFile = System.getProperty("user.dir");
			templateFile = templateFile.substring(0,templateFile.indexOf("/"));
			templateFile = templateFile.replace("\\", "/");
		} 
		System.out.println("templateFile****is*******"+templateFile);
		return templateFile;
		 /*****path******/
	}
	

	@Transactional(rollbackFor = Exception.class)
	@Override
	public byte[] getLoanAgreement(String investId,String loanId,String userId,SealFileType fileType) throws Exception{
		String id=null!=investId?investId:loanId;
		if(StringUtils.isBlank(id))return null;
		//文件的路径
		File dirFile=null;
		//路径的头信息
		templateFile=gettemplateFile();
		//查询文件是否存在，若存在就查询出文件路径，并返回该文件流
		CoreSealFlieExample example = new CoreSealFlieExample();
		CoreSealFlieExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andInvestIdEqualTo(id);
		createCriteria.andFileTypeEqualTo(fileType.name());
		createCriteria.andFilePeriodEqualTo(Integer.valueOf(0));
		List<CoreSealFlie> fileList = coreSealFlieService.selectByExample(example);
		if(fileList.size()>0&&((fileList.get(0))!=null)){
			CoreSealFlie sealFile = fileList.get(0);
			String path = templateFile+File.separator+"data"+File.separator+"sealfile"+File.separator+sealFile.getFilePath()+File.separator+sealFile.getFileName(); //文件路径
			dirFile=new File(path);
		}
		//如果服务器上存在文件  直接去服务器下载
		if(null!=dirFile&&dirFile.exists()){
			CoreSealFlie csf = fileList.get(0);
			//如果文件没盖章   先去盖章
			if(!csf.isFlagSeal()){
//				signatureFacadeService.signatureComposite(csf);//盖章
			}
		}else{//如果服务器上不存在  则生成
			dirFile=createLoanAgreement(investId,loanId,userId,fileType);
		}
		if (null==dirFile){
			log.error("借款协议生成失败 id={},fileType={}",id,fileType);
			return null;
		}
		return FileUtil.getBytesFromFile(dirFile);
	}

	/**
	 * 生成 : 散标借款协议
	 * @param investId
	 * @param loanId
	 * @param userId
	 * @param fileType
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public File createLoanAgreement(String investId,String loanId,String userId,SealFileType fileType) throws Exception{
		if(null==fileType)return null;
		String id=null!=investId?investId:loanId;
		if(StringUtils.isBlank(id))return null;
		//生成文件
		byte[] pdf=null;
		if(SealFileType.CreditLoanAgreementForLend.equals(fileType)||SealFileType.CreditLoanAgreementForLoan.equals(fileType)){
			//生成信贷标
			pdf=creditLoanAgreementUtil.createFile(investId,loanId,userId,fileType);
		}else if (SealFileType.AgreementForGuarantor.equals(fileType)){
			//生成担保合同
//			pdf = guarantorAgreementUtil.createFile(loanId,fileType);
		}else if (SealFileType.AppointmentAgreement.equals(fileType)){
			//自动出借服务协议
			pdf = appointmentAgreementUtil.createFile(investId,userId,fileType);
		}else if (SealFileType.AssignorAgreement.equals(fileType) || SealFileType.AssigneeAgreement.equals(fileType)){
			//债权转让协议
			pdf = debentureAgreementUtil.createFile(investId,loanId,userId,fileType);
		}else if (SealFileType.AgreementForCompensator.equals(fileType)){
			//借款代偿协议
			pdf = compensatorAgreementUtil.createFile(loanId,fileType);
		}
		String fileName=fileType+"-"+id+".pdf";
		templateFile=gettemplateFile();
		//查询资产标信息
		int year = LocalDate.now().getYear();
		int month = LocalDate.now().getMonthOfYear();
		int day = LocalDate.now().getDayOfMonth();
		CoreSealFlie csf = new CoreSealFlie();
		csf.setInvestId(id);
		csf.setCreateTime(new Date());
		csf.setFilePath("NET_LOAN"+File.separator+fileType.name()+File.separator+0+File.separator+year+File.separator+month+File.separator+day+File.separator+id);
		csf.setFilePeriod(0);
		csf.setFileName(fileName);
		csf.setFileType(fileType.name());
		//创建目录
		new FileUtil().createDirectory(csf.getFilePath());
		//上传文件
		FileUtil.wirteDataToFile(templateFile+File.separator+"data"+File.separator+"sealfile"+File.separator+csf.getFilePath()+File.separator+csf.getFileName(), pdf);
		log.info("SealFile ok and save data to \"" + csf.getFilePath() + "\'");
		//保存或更新文件信息
		List<CoreSealFlie>  fileList=coreSealFlieService.selectByTypeAndInvestIdAndPeriod(fileType.name(), id,0);
		if(CollectionUtils.isEmpty(fileList)){//添加
			coreSealFlieService.insert(csf);
		}else{//修改
			coreSealFlieService.updateByTypeAndInvestIdAndPeriod(csf);
			csf.setFileId(fileList.get(0).getFileId());
		}
		//生成文件的同时  进行签章
//		signatureFacadeService.signatureComposite(csf);
		return new File(templateFile+File.separator+"data"+File.separator+"sealfile"+File.separator+csf.getFilePath()+File.separator+csf.getFileName());
	}



}

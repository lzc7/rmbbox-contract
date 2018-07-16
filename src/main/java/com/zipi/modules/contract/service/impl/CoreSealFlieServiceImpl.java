package com.zipi.modules.contract.service.impl;

import com.zipi.modules.contract.entity.CoreSealFlie;
import com.zipi.modules.contract.entity.CoreSealFlieExample;
import com.zipi.modules.contract.mapper.CoreSealFlieMapper;
import com.zipi.modules.contract.service.CoreSealFlieService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;
import java.util.List;
@Slf4j
@Service
public class CoreSealFlieServiceImpl implements CoreSealFlieService {

    @Autowired
    private CoreSealFlieMapper coreSealFlieMapper;

    public int insert(CoreSealFlie record) {
        return coreSealFlieMapper.insert(record);
    }
    

    public List<CoreSealFlie> selectByExample(CoreSealFlieExample example) {
        return coreSealFlieMapper.selectByExample(example);
    }


	/**
	 * 按照类型和投资ID获取文件信息
	 * @param type
	 * @param investId
	 * @return 
	 * 2016年9月30日  下午4:21:36
	 * zhaoqiang
	 */
	@Override
	public List<CoreSealFlie> selectByTypeAndInvestIdAndPeriod(String type,String investId,int period) {
		return coreSealFlieMapper.selectByTypeAndInvestIdAndPeriod(type,investId,period);
	}

	@Override
	public void updateByTypeAndInvestIdAndPeriod(CoreSealFlie csf) {
		if(null==csf|| StringUtils.isEmpty(csf.getFileType())|| StringUtils.isEmpty(csf.getFileType()))return;
		coreSealFlieMapper.updateByTypeAndInvestIdAndPeriod(csf);
	}

	public CoreSealFlie selectByPrimaryKey(String key) {
		return coreSealFlieMapper.selectByPrimaryKey(key);
	}

	@Override
	public int updateAgreementStatus(String fileId) {
		return coreSealFlieMapper.updateAgreementStatus(fileId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void testTransaction() {
		CoreSealFlie csf = new CoreSealFlie();
		csf.setInvestId("10000");
		csf.setCreateTime(new Date());
		csf.setFilePath("NET_LOAN"+ File.separator);
		csf.setFilePeriod(0);
		csf.setFileName("test");
		csf.setFileType("test");
		coreSealFlieMapper.insert(csf);

		CoreSealFlie coreSealFlie = coreSealFlieMapper.selectByPrimaryKey(csf.getFileId());

		CoreSealFlie csf2 = new CoreSealFlie();
		csf2.setInvestId("100002");
		csf2.setCreateTime(new Date());
		csf2.setFilePath("NET_LOAN2"+ File.separator);
		csf2.setFilePeriod(0);
		csf2.setFileName("test2");
		csf2.setFileType("test2");
		coreSealFlieMapper.insert(csf2);

//		int a = 1/0;
		System.out.println("done");
	}
}
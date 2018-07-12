package com.zipi.service.impl;

import com.zipi.entity.CoreSealFlie;
import com.zipi.entity.CoreSealFlieExample;
import com.zipi.mapper.CoreSealFlieMapper;
import com.zipi.service.CoreSealFlieService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



}
package com.zipi.service;


import com.zipi.entity.CoreSealFlie;
import com.zipi.entity.CoreSealFlieExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoreSealFlieService {


    int insert(CoreSealFlie record);

    List<CoreSealFlie> selectByExample(CoreSealFlieExample example);


	/**
	 * 按照类型和投资ID获取文件信息
	 * @param type
	 * @param investId
	 * @param period   期数
	 * @return 
	 * 2016年9月30日  下午4:21:36
	 * zhaoqiang
	 */
	List<CoreSealFlie> selectByTypeAndInvestIdAndPeriod(String type, String investId, int period);

	/**
	 * 通过类型和投资Id  更新文件信息
	 * @param csf 
	 * 2016年9月30日  下午4:53:14
	 * zhaoqiang
	 */
	void updateByTypeAndInvestIdAndPeriod(CoreSealFlie csf);

	CoreSealFlie selectByPrimaryKey(String key);

	/**
	 * 更新状态
	 * @param fileId
	 * @return
	 */
	int updateAgreementStatus(String fileId);


}
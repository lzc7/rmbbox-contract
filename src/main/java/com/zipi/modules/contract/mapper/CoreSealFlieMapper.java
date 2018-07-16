package com.zipi.modules.contract.mapper;

import com.zipi.modules.contract.entity.CoreSealFlie;
import com.zipi.modules.contract.entity.CoreSealFlieExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface CoreSealFlieMapper {

    int insert(CoreSealFlie record);

    List<CoreSealFlie> selectByExample(CoreSealFlieExample example);
	/**
	 * 按照类型和投资ID获取文件信息
	 * @param type
	 * @param investId
	 * @param period
	 * @return
	 * 2016年9月30日  下午4:21:36
	 * zhaoqiang
	 */
	List<CoreSealFlie> selectByTypeAndInvestIdAndPeriod(@Param("type") String type, @Param("investId") String investId, @Param("period") int period);

	void updateByTypeAndInvestIdAndPeriod(@Param("record") CoreSealFlie record);

	CoreSealFlie selectByPrimaryKey(String key);

	/**
	 * 更新状态
	 * @param fileId
	 * @return
	 */
	int updateAgreementStatus(@Param("fileId") String fileId);


}
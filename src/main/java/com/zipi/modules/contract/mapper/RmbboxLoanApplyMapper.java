package com.zipi.modules.contract.mapper;

import com.zipi.modules.contract.entity.RmbboxLoanApply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface RmbboxLoanApplyMapper {



    RmbboxLoanApply selectByRequestId(@Param("requestId") String requestId);


}

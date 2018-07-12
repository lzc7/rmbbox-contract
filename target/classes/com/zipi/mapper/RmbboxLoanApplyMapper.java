package com.zipi.mapper;

import com.zipi.entity.RmbboxLoanApply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RmbboxLoanApplyMapper {



    RmbboxLoanApply selectByRequestId(@Param("requestId") String requestId);


}

package com.zipi.mapper;

import com.zipi.entity.RmbInvestRepayment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RmbInvestRepaymentMapper {

    List<RmbInvestRepayment> getByInvestId(@Param("investId") String investId);

}


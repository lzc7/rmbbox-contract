package com.zipi.modules.contract.mapper;

import com.zipi.modules.contract.entity.RmbInvestRepayment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RmbInvestRepaymentMapper {

    List<RmbInvestRepayment> getByInvestId(@Param("investId") String investId);

}


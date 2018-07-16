package com.zipi.modules.contract.mapper;

import com.zipi.modules.contract.entity.RmbboxLoanServiceRepayment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface RmbboxLoanServiceRepaymentMapper {


    RmbboxLoanServiceRepayment selectByPrimaryKey(String key);

}
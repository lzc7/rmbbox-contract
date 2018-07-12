package com.zipi.mapper;

import com.zipi.entity.RmbboxLoanServiceRepayment;
import org.springframework.stereotype.Repository;

@Repository
public interface RmbboxLoanServiceRepaymentMapper {


    RmbboxLoanServiceRepayment selectByPrimaryKey(String key);

}
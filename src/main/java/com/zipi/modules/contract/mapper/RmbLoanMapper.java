package com.zipi.modules.contract.mapper;

import com.zipi.modules.contract.entity.RmbLoan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
public interface RmbLoanMapper {


    RmbLoan getLoanByLoanId(@Param("loanId") String loanId);

    RmbLoan selectByPrimaryKey(@Param("loanId") String loanId);
}
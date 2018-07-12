package com.zipi.mapper;

import com.zipi.entity.RmbLoan;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RmbLoanMapper {


    RmbLoan getLoanByLoanId(@Param("loanId") String loanId);

    RmbLoan selectByPrimaryKey(@Param("loanId") String loanId);
}
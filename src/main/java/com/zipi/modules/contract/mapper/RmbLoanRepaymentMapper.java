package com.zipi.modules.contract.mapper;

import com.zipi.modules.contract.entity.RmbLoanRepayment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Mapper
public interface RmbLoanRepaymentMapper {


    int insert(RmbLoanRepayment repayment);

    RmbLoanRepayment queryByloanRepaymentId(@Param("repaymentId") String loanRepaymentId);

     Date getDueDateByLoanId(@Param("loanId") String loanId);

    /**
     * 获得累计借款利息：loanId
     * @param loanId
     * @return
     */
     BigDecimal getAmountInterestByloanId(@Param("loanId") String loanId);

    List<RmbLoanRepayment> selectByLoanId(@Param("loanId") String loanId);

}
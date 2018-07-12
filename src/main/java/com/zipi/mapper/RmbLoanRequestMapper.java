package com.zipi.mapper;

import com.zipi.entity.RmbLoanRequest;
import com.zipi.enums.bbt.LoanRequestTypes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RmbLoanRequestMapper {

  /**
   * 标的申请相关信息
   * @param loanId
   * @return
   */
  RmbLoanRequest getRmbLoanRequestByLoanId(@Param("loanId") String loanId);

  /**
   * 获得借款类型：loanId
   * @param loanId
   * @return
   */
  LoanRequestTypes getLoanRequestTypesByLoanId(@Param("loanId") String loanId);


}
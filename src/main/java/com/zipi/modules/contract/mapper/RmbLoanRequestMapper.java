package com.zipi.modules.contract.mapper;

import com.zipi.modules.contract.entity.RmbLoanRequest;
import com.zipi.modules.contract.enums.LoanRequestTypes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
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
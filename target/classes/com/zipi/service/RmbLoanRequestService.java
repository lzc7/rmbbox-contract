package com.zipi.service;


import com.zipi.entity.RmbLoanRequest;
import com.zipi.enums.bbt.LoanRequestTypes;

public interface RmbLoanRequestService {

	/**
	 * 标的申请相关信息
	 * @param loanId
	 * @return
	 */
	RmbLoanRequest getRmbLoanRequestByLoanId(String loanId);

	/**
	 * 获得借款类型：loanId
	 * @param loanId
	 * @return
	 */
	LoanRequestTypes getLoanRequestTypesByLoanId(String loanId);



}

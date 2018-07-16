package com.zipi.modules.contract.service;


import com.zipi.modules.contract.entity.RmbLoanRepayment;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 贷款还款记录
 * @author guowt
 *
 */
public interface RmbLoanRepaymentService {
	
	
	/**
	 * 根据主键查询
	 * @param loanRepaymentId
	 * @return
	 */
	RmbLoanRepayment queryByloanRepaymentId(String loanRepaymentId);


	/**
	 * 查询标的到期时间：按照loanId
	 * @param loanId
	 * @return
	 */
	Date getDueDateByLoanId(String loanId);

	/**
	 * 获得累计借款利息：loanId
	 * @param loanId
	 * @return
	 */
	BigDecimal getAmountInterestByloanId(String loanId);

	List<RmbLoanRepayment> getRmbLoanRepaymentsByLoanId(String loanId);


}

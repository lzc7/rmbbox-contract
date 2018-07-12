package com.zipi.service.impl;

import com.zipi.entity.RmbLoanRepayment;
import com.zipi.mapper.RmbLoanRepaymentMapper;
import com.zipi.service.RmbLoanRepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by lxl on 15/7/1.
 */
@Service
public class RmbLoanRepaymentServiceImpl implements RmbLoanRepaymentService {

    @Autowired
	RmbLoanRepaymentMapper rmbLoanRepaymentMapper;
    


	@Override
	public RmbLoanRepayment queryByloanRepaymentId(String loanRepaymentId) {
		return rmbLoanRepaymentMapper.queryByloanRepaymentId(loanRepaymentId);
	}


	@Override
	public Date getDueDateByLoanId(String loanId){
    	return rmbLoanRepaymentMapper.getDueDateByLoanId(loanId);
	}
	/**
	 * 获得累计借款利息：loanId
	 * @param loanId
	 * @return
	 */
	@Override
	public BigDecimal getAmountInterestByloanId(String loanId){
		return rmbLoanRepaymentMapper.getAmountInterestByloanId(loanId);
	}

	@Override
	public List<RmbLoanRepayment> getRmbLoanRepaymentsByLoanId(String loanId) {
		return rmbLoanRepaymentMapper.selectByLoanId(loanId);
	}
}

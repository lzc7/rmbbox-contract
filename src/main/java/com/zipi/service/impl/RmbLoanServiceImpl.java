package com.zipi.service.impl;

import com.zipi.entity.RmbLoan;
import com.zipi.mapper.RmbLoanMapper;
import com.zipi.service.RmbLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RmbLoanServiceImpl implements RmbLoanService {
    @Autowired
    private RmbLoanMapper rmbLoanMapper;



    public RmbLoan getLoanByLoanId(String loanId){
        return rmbLoanMapper.getLoanByLoanId(loanId);
    }

    @Override
    public RmbLoan selectByLoanId(String loanId) {

        return rmbLoanMapper.selectByPrimaryKey(loanId);
    }
}

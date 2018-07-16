package com.zipi.modules.contract.service.impl;

import com.zipi.modules.contract.entity.RmbLoan;
import com.zipi.modules.contract.mapper.RmbLoanMapper;
import com.zipi.modules.contract.service.RmbLoanService;
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

package com.zipi.modules.contract.service.impl;

import com.zipi.modules.contract.entity.RmbboxLoanServiceRepayment;
import com.zipi.modules.contract.mapper.RmbboxLoanServiceRepaymentMapper;
import com.zipi.modules.contract.service.RmbboxLoanServiceRepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RmbboxLoanServiceRepaymentServiceImpl implements RmbboxLoanServiceRepaymentService {

    @Autowired
    private RmbboxLoanServiceRepaymentMapper rmbboxLoanServiceRepaymentMapper;

    
    @Override
    public BigDecimal getLoanServiceAmountByRepaymentId(String repaymentId) {
        RmbboxLoanServiceRepayment serviceRepayment = rmbboxLoanServiceRepaymentMapper.selectByPrimaryKey(repaymentId);

        if (serviceRepayment != null) {
            return serviceRepayment.getRepayAmount();
        }else {
            return BigDecimal.ZERO;
        }
    }
}
package com.zipi.modules.contract.service.impl;

import com.zipi.modules.contract.entity.RmbInvestRepayment;
import com.zipi.modules.contract.mapper.RmbInvestRepaymentMapper;
import com.zipi.modules.contract.service.RmbInvestRepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RmbInvestRepaymentServiceImpl implements RmbInvestRepaymentService {

    @Autowired
    private RmbInvestRepaymentMapper repaymentMapper;



    
    public List<RmbInvestRepayment> getByInvestId(String investId) {
    	return repaymentMapper.getByInvestId(investId);
    }


}

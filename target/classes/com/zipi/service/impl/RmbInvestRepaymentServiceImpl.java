package com.zipi.service.impl;

import com.zipi.entity.RmbInvestRepayment;
import com.zipi.mapper.RmbInvestRepaymentMapper;
import com.zipi.service.RmbInvestRepaymentService;
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

package com.zipi.modules.contract.service.impl;

import com.zipi.modules.contract.entity.RmbLoanRequest;
import com.zipi.modules.contract.enums.LoanRequestTypes;
import com.zipi.modules.contract.mapper.RmbLoanRequestMapper;
import com.zipi.modules.contract.service.RmbLoanRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by apple on 15/7/17.
 */
@Service
public class RmbLoanRequestServiceImpl implements RmbLoanRequestService {

    @Autowired
    private RmbLoanRequestMapper rmbLoanRequestMapper;
    /**
     * 标的申请相关信息
     * @param loanId
     * @return
     */
    @Override
    public RmbLoanRequest getRmbLoanRequestByLoanId(String loanId){
        return rmbLoanRequestMapper.getRmbLoanRequestByLoanId(loanId);
    }
    /**
     * 获得借款类型：loanId
     * @param loanId
     * @return
     */
    @Override
    public LoanRequestTypes getLoanRequestTypesByLoanId(String loanId){
        return rmbLoanRequestMapper.getLoanRequestTypesByLoanId(loanId);
    }

}

package com.zipi.modules.contract.service.impl;

import com.zipi.modules.contract.entity.CoreUser;
import com.zipi.modules.contract.entity.RmbInvest;
import com.zipi.modules.contract.mapper.RmbInvestMapper;
import com.zipi.modules.contract.service.RmbInvestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Slf4j
@Service
public class RmbInvestServiceImpl implements RmbInvestService {

    @Autowired
    private RmbInvestMapper rmbInvestMapper;


    /**
     * 查询投资信息：按照investId,userId
     * @param investId
     * @param userId
     * @return
     */
    @Override
    public RmbInvest selectInvestByInvestIdAndUserId(String investId,String userId){
        return rmbInvestMapper.selectInvestByInvestIdAndUserId(investId,userId);
    }

    @Override
    public RmbInvest getInvestInfoByInvetId(String investId) {
        return rmbInvestMapper.getInvestInfoByInvetId(investId);
    }

    /**
     * 查询投资信息： loanId
     * @param loanId
     * @return
     */
    public List<RmbInvest> selectInvestByLoanId(String loanId){
        return rmbInvestMapper.selectInvestByLoanId(loanId);
    }


    /**
     * 查询看借款企业(或个人)的信息：loanId
     * 注：除 userId为借款人信息，其余字段为出借人信息
     * @return
     */
    public CoreUser selectEnterpriseInfoByLoanId(String loanId){
        return rmbInvestMapper.selectEnterpriseInfoByLoanId(loanId);
    }
}

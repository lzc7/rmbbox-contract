package com.zipi.modules.contract.service;


import com.zipi.modules.contract.entity.CoreUser;
import com.zipi.modules.contract.entity.RmbInvest;

import java.util.List;

public interface RmbInvestService {

    /**
     * 查询投资信息：按照investId,userId
     * @param investId
     * @param userId
     * @return
     */
    RmbInvest selectInvestByInvestIdAndUserId(String investId, String userId);



    /**
     * 查询投资信息： loanId
     * @param loanId
     * @return
     */
    List<RmbInvest> selectInvestByLoanId(String loanId);




    RmbInvest getInvestInfoByInvetId(String investId);

    /**
     * 查询看借款企业(或个人)的信息：loanId
     * 注：除 userId为借款人信息，其余字段为出借人信息
     * @return
     */
    CoreUser selectEnterpriseInfoByLoanId(String loanId);

}

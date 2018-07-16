package com.zipi.modules.contract.service;


import com.zipi.modules.contract.entity.RmbLoan;


public interface RmbLoanService {



    RmbLoan getLoanByLoanId(String loanId);

    RmbLoan selectByLoanId(String loanId);



}

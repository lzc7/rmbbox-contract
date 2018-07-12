package com.zipi.service;


import com.zipi.entity.RmbLoan;


public interface RmbLoanService {



    RmbLoan getLoanByLoanId(String loanId);

    RmbLoan selectByLoanId(String loanId);



}

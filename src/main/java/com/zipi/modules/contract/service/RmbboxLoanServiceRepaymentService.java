package com.zipi.modules.contract.service;

import java.math.BigDecimal;

public interface RmbboxLoanServiceRepaymentService {

    BigDecimal getLoanServiceAmountByRepaymentId(String repayment);

}
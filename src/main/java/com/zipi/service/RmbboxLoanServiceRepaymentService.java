package com.zipi.service;

import java.math.BigDecimal;

public interface RmbboxLoanServiceRepaymentService {

    BigDecimal getLoanServiceAmountByRepaymentId(String repayment);

}
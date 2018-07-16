package com.zipi.modules.contract.service;

import com.zipi.modules.contract.entity.RmbInvestRepayment;

import java.util.List;

/**
 * Created by apple on 15/7/7.
 */
public interface RmbInvestRepaymentService {


    List<RmbInvestRepayment> getByInvestId(String investId);

}

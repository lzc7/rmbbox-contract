package com.zipi.service;

import com.zipi.entity.RmbInvestRepayment;

import java.util.List;

/**
 * Created by apple on 15/7/7.
 */
public interface RmbInvestRepaymentService {


    List<RmbInvestRepayment> getByInvestId(String investId);

}

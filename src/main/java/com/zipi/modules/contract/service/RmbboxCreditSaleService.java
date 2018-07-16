package com.zipi.modules.contract.service;

import com.zipi.modules.contract.entity.RmbboxCreditSale;

public interface RmbboxCreditSaleService {

    RmbboxCreditSale queryByIdWithUserInfo(Long aLong);

    RmbboxCreditSale selectByPrimaryKey(Long key);

}



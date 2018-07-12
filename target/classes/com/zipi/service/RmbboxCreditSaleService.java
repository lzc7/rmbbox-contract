package com.zipi.service;

import com.zipi.entity.RmbboxCreditSale;

public interface RmbboxCreditSaleService {

    RmbboxCreditSale queryByIdWithUserInfo(Long aLong);

    RmbboxCreditSale selectByPrimaryKey(Long key);

}



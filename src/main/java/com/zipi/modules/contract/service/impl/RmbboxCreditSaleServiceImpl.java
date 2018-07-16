package com.zipi.modules.contract.service.impl;

import com.zipi.modules.contract.entity.RmbboxCreditSale;
import com.zipi.modules.contract.mapper.RmbboxCreditSaleMapper;
import com.zipi.modules.contract.service.RmbboxCreditSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RmbboxCreditSaleServiceImpl implements RmbboxCreditSaleService {

    @Autowired
    private RmbboxCreditSaleMapper rmbboxCreditSaleMapper;
    @Override
    public RmbboxCreditSale queryByIdWithUserInfo(Long id) {
        return rmbboxCreditSaleMapper.queryByIdWithUserInfo(id);
    }

    public RmbboxCreditSale selectByPrimaryKey(Long key) {
        return rmbboxCreditSaleMapper.selectByPrimaryKey(key);
    }

}

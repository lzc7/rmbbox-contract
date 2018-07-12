package com.zipi.service.impl;

import com.zipi.entity.RmbboxCreditSale;
import com.zipi.mapper.RmbboxCreditSaleMapper;
import com.zipi.service.RmbboxCreditSaleService;
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

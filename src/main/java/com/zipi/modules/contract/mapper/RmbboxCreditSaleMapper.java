package com.zipi.modules.contract.mapper;

import com.zipi.modules.contract.entity.RmbboxCreditSale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RmbboxCreditSaleMapper {

    RmbboxCreditSale queryByIdWithUserInfo(@Param("id") Long id);

    RmbboxCreditSale selectByPrimaryKey(Long key);


}
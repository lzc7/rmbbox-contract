package com.zipi.mapper;

import com.zipi.entity.RmbboxCreditSale;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RmbboxCreditSaleMapper {

    RmbboxCreditSale queryByIdWithUserInfo(@Param("id") Long id);

    RmbboxCreditSale selectByPrimaryKey(Long key);


}
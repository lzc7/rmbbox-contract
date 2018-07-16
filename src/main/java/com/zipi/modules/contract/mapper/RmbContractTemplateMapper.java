package com.zipi.modules.contract.mapper;



import com.zipi.modules.contract.entity.RmbContractTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RmbContractTemplateMapper {


    RmbContractTemplate getByType(@Param("type") String type);
}

package com.zipi.mapper;



import com.zipi.entity.RmbContractTemplate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RmbContractTemplateMapper {


    RmbContractTemplate getByType(@Param("type") String type);
}

package com.zipi.modules.contract.mapper;

import com.zipi.modules.contract.entity.CoreUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreUserMapper {


    CoreUser getById(String userId);

}
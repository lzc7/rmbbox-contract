package com.zipi.mapper;

import com.zipi.entity.CoreUser;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreUserMapper {


    CoreUser getById(String userId);

}
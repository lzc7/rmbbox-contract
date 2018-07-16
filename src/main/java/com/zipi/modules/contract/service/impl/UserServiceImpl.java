package com.zipi.modules.contract.service.impl;

import com.zipi.modules.contract.entity.CoreUser;
import com.zipi.modules.contract.mapper.CoreUserMapper;
import com.zipi.modules.contract.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CoreUserMapper coreUserMapper;


    @Override
    public CoreUser findById(String userId) {
        return coreUserMapper.getById(userId);
    }
}

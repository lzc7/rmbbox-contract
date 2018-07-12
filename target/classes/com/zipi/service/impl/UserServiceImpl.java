package com.zipi.service.impl;

import com.zipi.entity.CoreUser;
import com.zipi.mapper.CoreUserMapper;
import com.zipi.service.UserService;
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

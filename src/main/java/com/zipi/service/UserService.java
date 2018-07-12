package com.zipi.service;

import com.zipi.entity.CoreUser;

public interface UserService {


    /**
     * 根据userId获取用户信息
     *
     * @param userId
     * @return
     */
    public CoreUser findById(String userId);

}

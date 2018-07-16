package com.zipi.modules.contract.service;

import com.zipi.modules.contract.entity.CoreUser;

public interface UserService {


    /**
     * 根据userId获取用户信息
     *
     * @param userId
     * @return
     */
    public CoreUser findById(String userId);

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.enums.common;

import com.zipi.base.BaseEnum;

/**
 * 数据统计时需要的用户类型
 *
 * @author zhaichongchong
 */
public enum UserLevel implements BaseEnum {

    OFFLINE_A("线下A"),
    OFFLINE_B("线下B"),
    OFFLINE_C("线下C"),
    OFFLINE_D("线下D"),
    ONLINE_A("线上A"),
    ONLINE_B("线上B"),
    ONLINE_C("线上C"),
    ONLINE_D("线上D");

    private final String key;

    UserLevel(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}

package com.zipi.enums;


import com.zipi.base.BaseEnum;

/**
 * 还款资金类型
 *
 * Created by apple on 15/7/7.
 */
public enum RepayType implements BaseEnum {

    /**
     * 只还本金
     */
    Principal("本金"),
    /**
     * 本息都还
     */
    PrincipalAndInterest("本息"),
    /**
     * 只还利息
     */
    Interest("利息");

    private final String key;

    private RepayType(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.modules.contract.enums;


import com.zipi.modules.base.enums.BaseEnum;

/**
 * @author rooseek
 */
public enum LoanPurpose implements BaseEnum {

    SHORTTERM("短期周转"),
    PERSONAL("个人信贷"), //原'个人消费'
    INVESTMENT("投资创业"),
    CAR("车辆融资"),
    HOUSE("房产融资"),
    CORPORATION("企业融资"),
    OTHER("其它借款");

    private final String key;


    private LoanPurpose(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

}

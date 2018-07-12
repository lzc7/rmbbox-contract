/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.enums.core;

import com.zipi.base.BaseEnum;


/**
 *
 * @author rooseek
 */
public enum CareerStatus implements BaseEnum {

    EMPLOYEE("普通员工"), 
    MANAGER("管理人员"), 
    SHAREHOLDER("股东"), 
    PRIVATE_ENTREPRENEUR("私营企业主"),
    PERSON("个人"),
    COMPANY("企业"),
    OTHER("其他");

    private final String key;

    private CareerStatus(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}

package com.zipi.modules.contract.enums;


import com.zipi.modules.base.enums.BaseEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2017，Beijing Zipi Wealth Network Technology Co., Ltd.
 * Author: songfangyan
 * Version: 1.0
 * Date: 2018/2/26
 * Time: 下午1:51
 * Description: 借款系统来源枚举
 * Others:
 */
public enum BorrowPartnerSource implements BaseEnum {


    lirenfenqiBBT001("丽人分期"),
    xinXiangCheBBT001("心享车"),
    NOTHING("无");

    private final String key;

    private  static List<String> borrowPartnerSourceList = new ArrayList<>();

    BorrowPartnerSource(String key) {

        this.key = key;
    }

    public static List<String> getAllName(){

        for (BorrowPartnerSource borrowPartnerSource : BorrowPartnerSource.values()) {
            borrowPartnerSourceList.add(borrowPartnerSource.name());
        }
        return borrowPartnerSourceList;
    }
    /**
     * key along with enum
     *
     * @return
     */
    @Override
    public String getKey() {
        return key;
    }
}

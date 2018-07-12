package com.zipi.enums.core;

import com.zipi.base.BaseEnum;

/**
 * Created by Tony on 2015/6/9.
 */
public enum IncomeStatus implements BaseEnum {
    READY("准备中"),
    REPAYING("还款中"),
    SETTLED("已还清"),
    CANCLE("取消");

    private final String key;

     IncomeStatus(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

}

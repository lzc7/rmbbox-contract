package com.zipi.enums.claim;

import com.zipi.base.BaseEnum;

/**
 * 活期、非活期等的投资状态
 */
public enum InvestStatus implements BaseEnum {


    MATCHING("投资中"),
    CANCEL("取消"),
    END("赎回");

    private final String key;

    private InvestStatus(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}


package com.zipi.enums.props;

import com.zipi.base.BaseEnum;

/**
 * 红包的返现类型
 */
public enum CashbackType implements BaseEnum {

    ANNUALIZED("按年化收益率返现"),
    PERCENTAGE("按百分比返现");

    private final String key;

    CashbackType(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}

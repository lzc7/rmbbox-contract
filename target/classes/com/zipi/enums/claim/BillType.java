package com.zipi.enums.claim;

import com.zipi.base.BaseEnum;

public enum BillType implements BaseEnum {
    BILL_TYPE_0(""),
    BILL_TYPE_1("");

    private final String key;

    private BillType(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}

package com.zipi.enums.claim;


import com.zipi.base.BaseEnum;

/**
 * Created by Jeff on 10/19/15.
 */
public enum GuaranteeType implements BaseEnum {
    TYPE_1("本息安全");

    private final String key;

    private GuaranteeType(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}

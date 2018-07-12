package com.zipi.enums.bbt;

import com.zipi.base.BaseEnum;

public enum BranchType implements BaseEnum {

    HEADQUARTER("总部"),
    DEPARTMENT("部门办公室"),
    BRANCH("分公司"),
    BUSINESSUNIT("营业部"),
    FRANCHISEE("加盟商");

    private final String key;

    private BranchType(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
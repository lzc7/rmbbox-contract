package com.zipi.enums.core;


import com.zipi.base.BaseEnum;

/**
 * 用户资金记录表-审核状态check_status
 * creat by zcc
 */
public enum CheckStatus implements BaseEnum {
	
	CHECKED("已审核"),
	UNCHECKED("未审核"),
	UNIMPORT("未导入提现结果"),
	NOTHING("");

    private final String key;

    private CheckStatus(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

}
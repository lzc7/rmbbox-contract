package com.zipi.enums.claim;

import com.zipi.base.BaseEnum;

public enum  RepayApplyStatus implements BaseEnum {

	AUDITING("申请赎回"),
//	EXPIRE("到期赎回"),
	CANCELED("取消"),
	SUCCESSFUL("已赎回");
	
    private final String key;

    private RepayApplyStatus(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}


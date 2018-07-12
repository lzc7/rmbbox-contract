package com.zipi.enums;

import com.zipi.base.BaseEnum;

public enum  ExperienceState implements BaseEnum {

	UN_USE("待使用"),
	NOT_ARRIVAL("使用中"),
	ARRIVAL("已到帐"),
	EXPIRE("已过期");
	
    private final String key;

    private ExperienceState(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}


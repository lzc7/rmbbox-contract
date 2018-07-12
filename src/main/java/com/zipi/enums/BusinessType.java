package com.zipi.enums;


import com.zipi.base.BaseEnum;

public enum BusinessType implements BaseEnum {
	USER_EXPERIENCE("体验金类型"),
	OTHERS("其他类型")
	;
	
	private final String key;
	private BusinessType(String key) {
	        this.key = key;
	    }
	@Override
	public String getKey() {
		return key;
	}

}

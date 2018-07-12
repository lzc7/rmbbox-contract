package com.zipi.enums;

import com.zipi.base.BaseEnum;

public enum LoginPlatform implements BaseEnum {

	/**
     * 登陆平台
     */
	PC("pc端"),
	M("M站"),
    APP("app端");


    private final String key;

    private LoginPlatform(String key) {
        this.key = key;
    }
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return key;
	}

}

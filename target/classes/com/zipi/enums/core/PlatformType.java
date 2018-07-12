package com.zipi.enums.core;


import com.zipi.base.BaseEnum;

/**
 * 资金平台
 * @author wangh_000
 *
 */
public enum PlatformType implements BaseEnum {
	
	PLATFORM_A("平台A-官网"),//market
	PLATFORM_B("平台B-后台"),//manager
	PLATFORM_C("平台C-新产品-手续费"),// market;// market
	PLATFORM_D("平台D-员工常态红包");
	
	private final String key;
	
	private PlatformType(String key){
		this.key = key;
	}

	@Override
	public String getKey() {
		return key;
	}

}

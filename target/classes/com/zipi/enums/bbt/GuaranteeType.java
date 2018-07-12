package com.zipi.enums.bbt;


import com.zipi.base.BaseEnum;

/**
 * 
 * 保障类型
 * @author whs
 *
 */
public enum GuaranteeType implements BaseEnum {
	
	TYPE_1("本息安全");
	
	private final String key;

    private GuaranteeType(String key) {
        this.key = key;
    }

	@Override
	public String getKey() {
		return this.key;
	}

}

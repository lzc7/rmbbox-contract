package com.zipi.modules.contract.enums;


import com.zipi.modules.base.enums.BaseEnum;

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

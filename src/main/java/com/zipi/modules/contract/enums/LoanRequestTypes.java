package com.zipi.modules.contract.enums;

import com.zipi.modules.base.enums.BaseEnum;

/**
 * 
 * 借款类型
 * @author whs
 *
 */
public enum LoanRequestTypes implements BaseEnum {
	/**
	 * 借款类型首字母开头
	 */
	B_X_R("邦鑫融"),
	B_D_R("邦抵融"),
	B_B_R("邦保融"),
	B_XY_R("邦信融"),
	B_Z_R("邦租融"),
	D_B_B("担保标"),
	S_D_B("实地标"),
	C_D_B("车贷标"),
	P_J_B("银票据标"),
	X_D_B("网贷项目"),
	S_P_J_B("商票据标"),
	P_X_D_B("信贷标");//个人信贷标

	private final String key;

    private LoanRequestTypes(String key) {
        this.key = key;
    }

	@Override
	public String getKey() {
		return this.key;
	}

	
}

package com.zipi.modules.base.enums;

/**
 * 用户资金记录表-交易状态Trade_status
 *
 * 1.充值逻辑状态 ：发起充值(INITIALIZED)-->处理中(PROCESSING)-->到账成功（SUCCESSFUL）
 *                                                         |-->到账失败(FAILURE)
 *
 * creat by zcc
 */
public enum FundRecordStatus implements BaseEnum {
	
	AUDITING("审核中"),
	CANCELED("取消"),
	CHECKED("已审核"),
	FAILURE("交易失败"),
	INITIALIZED("初始"),
	PROCESSING("处理中"),
	PROPOSING("提交中"),
	SUCCESSFUL("成功"),
    CONFIRMED("已确认"),
    INTERCEPTED("已拦截"),
    REFUSE("拒绝"),
    BACK("退回"),
    CLOSED("交易关闭"),
    ACCEPT("已受理"),
    FAIL("提现确认后出款失败或被拦截");

    private final String key;

    private FundRecordStatus(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

}
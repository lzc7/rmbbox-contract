package com.zipi.enums.bbt;


import com.zipi.base.BaseEnum;

/**
 * 用户消息类型
 * Created by zhangyang on 3/18/16.
 */
public enum UserMessageType implements BaseEnum {
    MSG_RECHARGE("充值消息"),
    MSG_WITHDRAW("提现消息"),
    MSG_INVESTMENT("投资消息"),
    MSG_REPAYMENT("回款消息"),
    MSG_SYSTEM("系统消息")
    ;

    private final String key;

    private UserMessageType(String key){
        this.key=key;
    }

    @Override
    public String getKey() {
        return null;
    }
}

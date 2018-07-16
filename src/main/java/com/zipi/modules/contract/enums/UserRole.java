package com.zipi.modules.contract.enums;

/**
 * Created by Administrator on 2017/3/5.
 */
public enum UserRole {

    GUARANTEECORP("担保机构"),
    INVESTOR("出借人"),
    BORROWERS("借款人"),
    INTERMEDIATOR("居间人"),
    COLLABORATOR("合作机构"),
    SUPPLIER("供应商"),
    PLATFORM_COMPENSATORY("平台代偿账户"),
    PLATFORM_MARKETING("平台营销款账户"),
    PLATFORM_PROFIT("平台分润账户"),
    PLATFORM_INCOME("平台收入账户"),
    PLATFORM_INTEREST("平台派息账户"),
    PLATFORM_ALTERNATIVE_RECHARGE("平台代充值账户"),
    PLATFORM_FUNDS_TRANSFER("平台总账户");

    private String key;

    public String getKey() {
        return key;
    }

    UserRole(String key) {
        this.key = key;
    }
}

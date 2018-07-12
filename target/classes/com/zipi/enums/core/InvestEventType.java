package com.zipi.enums.core;


import com.zipi.base.BaseEnum;

/**
 * 将在用户账户主页上显示的用户投资借款类事件种类
 *
 * @author veryyoung
 */
public enum InvestEventType implements BaseEnum {

    /**
     * 添加平台福利 事件类型
     */
    REWARD_REGISTER("注册奖励"),
    REWARD_REFERRAL("推荐奖励"),
    REWARD_INVEST("投标奖励"),
    REWARD_DEPOSIT("充值奖励"),
    REWARD_COMMISSION("佣金提成"),
    REWARD_ACTIVITY("活动奖励"),
    RED_PACKAGE_BACK("红包奖励"),

    INVEST("投资"),
    INVEST_REPAY("投资回款"),
    LOAN("融资"),
    LOAN_REPAY("融资还款"),
    DEPOSIT("充值"),
    WITHDRAW("提现"),
    FROZEN("冻结中"),
    DISBURSE("垫付还款"),
    CREDIT_ASSIGN("债权转让"),
    TRANSFER_IN("资金转入"),
    TRANSFER_OUT("转账资金转出");


    private final String key;

    private InvestEventType(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
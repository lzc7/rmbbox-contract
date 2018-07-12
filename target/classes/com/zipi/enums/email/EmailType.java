/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.enums.email;


import com.zipi.base.BaseEnum;

/**
 * @author sobranie
 */
public enum EmailType implements BaseEnum {

    CONFIRM_CREDITMARKET_REGISTRATION("confirm.creditmarket.registration"),

    CONFIRM_CREDITMARKET_ACTIVATION("confirm.creditmarket.activation"),

    CONFIRM_CREDITMARKET_AUTHENTICATION("confirm.creditmarket.authentication"),

    CONFIRM_CREDITMARKET_GIFTCARD("confirm.creditmarket.giftcard"),
    STATISTICS_DAY_CUSTOMER("statistics.day.customer"),
    STATISTICS_WEEKLY_CUSTOMER("statistics.week.customer"),
    STATISTICS_MONTHLY_CUSTOMER("statistics.month.customer"),
    STATISTICS_WEEK_MANAGER("statistics.week.manager"),

    DEPOSIT_NOT_INVEST("deposit.not.invest"),
    REPAY_NOT_INVEST("repay.not.invest"),
    REGISTER_NOT_INVEST_RECOMMEND("register.not.invest.recommend"),
    ASSET_SETTLE_REPORT("asset.settle.report"),
	DEPOSIT_PORT_INVEST("deposit.port.invest"),
    DEPOSIT_FAILURE_MESSAGE("deposit.failure.message");
    private final String key;

    private EmailType(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.enums.common;

import com.zipi.base.BaseEnum;

/**
 * 优惠类型
 *
 * @author zhaichongchong
 */
public enum CouponType implements BaseEnum {

    GIFT_CARD("投资红包"),
    TELEPHONE_DATA("流量"),
    TELEPHONE_VOICE("话费"),
    EXPERIENCE_CASH("体验金"),
    INTEREST_RATES("加息券"),
    CASH("现金"),
    NOTHING("无任何道具"),
    GOLD_JEWELRY("金饰品"),
    REWARD_CASH_PACKET("现金红包");

    private final String key;

    CouponType(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}

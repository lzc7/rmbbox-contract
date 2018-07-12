package com.zipi.enums.bbt;

import com.zipi.base.BaseEnum;

/**
 * Created by Administrator on 2017/2/22.
 */
public enum AdsImageCategory implements BaseEnum {

    PC_HOME_BANNER("PC首页BANNER"),
    MOBILE_HOME_BANNER("移动端首页BANNER"),

    PC_POPUP_ADS("PC弹窗广告"),
    MOBILE_POPUP_ADS("移动端弹窗广告"),

    APP_RUN_ADS("APP开机广告"),
    LOAN_APP_RUN_ADS("借款端APP开机广告"),

    PC_FLOAT_ADS("PC浮动广告"),
    MOBILE_FLOAT_ADS("移动端浮动广告"),

    PC_INVITE_ADS("PC邀请好友广告"),
    MOBILE_INVITE_ADS("客户端邀请好友广告"),

    PC_HOME_CENTER_ADS("PC首页中部广告"),

    PC_REGIIST_ADS("PC注册广告"),

    PC_LOGIN_ADS("PC登录广告"),

    LABEL_FOR_LOAN("标签更换"),

    PC_LOANDETAILPAGE_AD("pc详情页广告图更换"),

    MOBILE_LOANDETAILPAGE_AD("移动端详情页广告图更换"),

    LOAN_APP_HOME_BANNER("借款端APP首页banner图"),

    MOBILE_SHAREREDPACKET_AD("分享红包图片"),

    FINDER_BANNER("标签更换");//移动端发现页banner

    private final String key;

    private AdsImageCategory(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

}

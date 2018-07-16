/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.modules.contract.enums;


import com.zipi.modules.base.enums.BaseEnum;

import java.util.Arrays;
import java.util.List;

/**
 * 信息来源
 *
 * @author sobranie
 */
public enum Source implements BaseEnum {

    WEB("公共网络"),
    BACK("系统后台"),
    MSTATION("M站"),
    WECHAT("微信"),
    MOBILE("移动端"),
    ANDROID("安卓"),
    XXC("心享车"),
    IOS("苹果"),
    android_borrower("安卓借款端"),
    ios_borrower("苹果借款端"),
    BBG_Sms_Login("邦帮团短信授权登录");

    private final String key;

    private Source(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    /**
     * 获取数据统计使用的终端来源
     * @return
     */
    public static List<Source> getUsedSource() {
        return Arrays.asList(Source.WEB, Source.MSTATION, Source.IOS, Source.ANDROID);
    }

    /**
     * 获取web所有终端来源
     * @return
     */
    public static List<Source> getWebALLSource() {
        return Arrays.asList(Source.WEB, Source.MSTATION, Source.WECHAT);
    }

    public static List<String> getWebALLSourceStr() {
        return Arrays.asList(Source.WEB.name(), Source.MSTATION.name(), Source.WECHAT.name());
    }

    public static List<String> getAppALLSourceStr() {
        return Arrays.asList(Source.ANDROID.name(), Source.IOS.name(), Source.MOBILE.name(),android_borrower.name(),ios_borrower.name());
    }

    /**
     * 手机端
     * @return
     */
    public static List<String> getMobileSourceStr() {
        return Arrays.asList(Source.ANDROID.name(), Source.IOS.name(), Source.MOBILE.name(), Source.MSTATION.name(), Source.WECHAT.name());
    }


    public static Source getSourceByClient(String client) {
        if(client == null)
            return Source.WEB;

        client = client.toUpperCase();

        if (client.equals("HTML5")) {
            return Source.MSTATION;
        }
        //借款端
        if (Source.ios_borrower.name().equalsIgnoreCase(client)) {
            return Source.ios_borrower;
        }

        if (Source.android_borrower.name().equalsIgnoreCase(client)) {
            return Source.android_borrower;
        }

        if (Source.getWebALLSourceStr().contains(client) || Source.getAppALLSourceStr().contains(client)) {
            return Source.valueOf(client);
        }
        return Source.WEB;
    }
}

package com.zipi.enums;

import com.zipi.base.BaseEnum;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xhp on 2016/3/16.
 */
public enum DictType implements BaseEnum {

    /**
     * 体验金类型
     */
    EXPERIENCETYPE_REGISTER("experienceType","register","注册体验金"),
    EXPERIENCETYPE_AUTHENTICATION("experienceType","authentication","实名体验金"),
    EXPERIENCETYPE_BINDCARD("experienceType","bindCard","绑卡体检金"),
    EXPERIENCETYPE_FIRSTINVEST("experienceType","firstInvest","首投体验金"),
    EXPERIENCETYPE_INVITEINVEST("experienceType","inviteInvest","邀请投资体验金"),
    
    
    /**
     * pc背景图片
     */
    PCBACKGROUND_LOGINRESOURCE("PCBACKGROUND","LOGINRESOURCE","登录注册背景图片"),
    PCBACKGROUND_HOMEPAGE("PCBACKGROUND","HOMEPAGE","PC端首页背景图片"),
    PCBACKGROUND_TOPBANNER("PCBACKGROUND","TOPBANNER","顶部背景图片"),
    PCBACKGROUND_BOTTOMBANNER("PCBACKGROUND","BOTTOMBANNER","底部背景图片"),
    PCBACKGROUND_PRODUCTADS("PCBACKGROUND","PRODUCTADS","产品广告位"),

    /**
     * mobile背景图片
     */
    MOBILEBACKGROUND_LOGINRESOURCE("MOBILEBACKGROUND","LOGINRESOURCE","登陆注册背景图"),
    MOBILEBACKGROUND_HOMEPAGE("MOBILEBACKGROUND","HOMEPAGE","首页背景图片"),
    MOBILEBACKGROUND_TOPBANNER("MOBILEBACKGROUND","TOPBANNER","顶部背景图片"),
    MOBILEBACKGROUND_BOTTOMBANNER("MOBILEBACKGROUND","BOTTOMBANNER","底部背景图片"),
    MOBILEBACKGROUND_PRODUCTADS("MOBILEBACKGROUND","PRODUCTADS","产品广告位");


    private final String key;
    private final String value;
    private final String label;

    DictType(String key,String value,String label){
        this.key = key;
        this.value = value;
        this.label = label;
    }

    @Override
    public String getKey(){return key;}

    public String getValue(){return value;}

    public String getLabel(){return label;}
    
    public final static List<DictType> getExperienceTypesForOnce() {
        return Arrays.asList(EXPERIENCETYPE_REGISTER,EXPERIENCETYPE_AUTHENTICATION,EXPERIENCETYPE_BINDCARD);
    }
    
    public final static List<String> getExperienceTypesForMarket(){

		return Arrays.asList(EXPERIENCETYPE_REGISTER.getValue(),EXPERIENCETYPE_AUTHENTICATION.getValue(),EXPERIENCETYPE_BINDCARD.getValue(),EXPERIENCETYPE_FIRSTINVEST.getValue(),EXPERIENCETYPE_INVITEINVEST.getValue());

    }
}

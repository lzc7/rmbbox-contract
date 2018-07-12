package com.zipi.enums;

import com.zipi.base.BaseEnum;

public enum LotteryType implements BaseEnum {

    /**
     * 抽奖类型
     */
    ALL_IN("普通抽奖"),
    RICH_IN("土豪抽奖"),
    XNY("双旦活动抽奖"),//XmasAndNewYear
    RIDDLES2016("猜灯谜活动抽奖"),//2016猜灯谜活动
    SUPER_TURN("超级转转赚"),//
    FESTIVAL2016("春节活动"),
    TAQING2016("踏青活动"),
    TAQING2016_BAI("踏青活动白银"),
    TAQING2016_HUANG("踏青活动黄金"),
    GOLDRUSH2016("五一淘金热"),
    CHILDRED2016("六一红包"),
    CHILDRED2016_61("六一当天红包"),
    CHILD2016("六一翻牌活动"),
    CHILD2016_5("六一翻牌活动期间投资小于5万"),
    TAQING2016_QING("踏青活动青铜"),
    FATHER_CAT_2016("父亲节活动-猫爸"),
    FATHER_TIGER_2016("父亲节活动-虎爸"),
    CHINAGT("获取竞标赛门票"),
    DAJIN1("代金券1"),
    DAJIN2("代金券2"),
    DAJIN3("代金券3"),

    rio_olympic("里约奥运会"),

    mid_autumn2016_hundred_am("2016年中秋节-百宝箱-上午"),
    mid_autumn2016_hundred_pm("2016年中秋节-百宝箱-下午"),
    mid_autumn2016_million_am("2016年中秋节-万宝箱-上午"),
    mid_autumn2016_million_pm("2016年中秋节-万宝箱-下午"),

	THANKS_GIVING_DAY_2016("2016感恩节抽奖"),
	THANKS_GIVING_DAY_2016_SPECIAL("2016感恩节抽奖特别奖"),
	DAILY_RAFFLE("每日抽奖"),
	CHRISTMAS_2016_A("2016圣诞鸡生蛋"),
	CHRISTMAS_2016_B_COMMON("2016圣诞蛋生鸡, 银蛋"),
	CHRISTMAS_2016_B_GOLDEN("2016圣诞蛋生鸡, 金蛋"),
    SPRING_FESTIVAL_2017("2017春节红包活动-母红包"),
    VALENTINE_2017("2017情人节活动"),
    VALENTINE_2017_GIFT("2017情人节活动-投资红包"),
    VALENTINE_2017_CASH("2017情人节活动-现金红包"),
    LANTERN_2017("2017元宵节活动"),
    LANTERN_2017_GIFT("2017元宵活动-投资红包"),
    LANTERN_2017_CASH("2017元宵活动-现金红包"),
    DRAGON_2017("2017龙抬头活动"),
    DRAGON_2017_GIFT("2017龙抬头活动-投资红包"),
    DRAGON_2017_CASH("2017龙抬头活动-现金红包"),

    SPRING_FESTIVAL_GIFT_2017("2017春节红包活动-投资红包"),
    SPRING_FESTIVAL_CASH_2017("2017春节红包活动-现金红包"),
	CHRISTMAS_2016_B_DIAMOND("2016圣诞蛋生鸡, 钻石蛋"),
    //---------------龙抬头活动相关奖品    start---------------
    DRAGON_HEAD_PRIZE("二月二龙抬头活动，抽奖"),
    DRAGON_HEAD_GOLD_PRIZE("二月二龙抬头活动金奖"),
    //具体的某个产品
    DRAGON_HEAD_GOLD_JEWELRY_1("周大福金鸡黄金吊坠"),
    DRAGON_HEAD_GOLD_JEWELRY_2("周大福Q版黄金吊坠"),
    DRAGON_HEAD_GOLD_JEWELRY_3("周大福运珠金吊坠"),
    DRAGON_HEAD_GOLD_JEWELRY_4("周大福精致黄金金钞"),
    DRAGON_HEAD_GOLD_JEWELRY_5("周大福足金黄金耳环"),

    DRAGON_HEAD_GIFT_CARD_100("投资红包"),
    DRAGON_HEAD_GIFT_CARD_50("投资红包"),
    DRAGON_HEAD_GIFT_CARD_30("投资红包"),

    DRAGON_HEAD_TELEPHONE_VOICE_50("话费"),
    DRAGON_HEAD_TELEPHONE_VOICE_30("话费"),
    
    DRAGONHEAD_2017("2017,龙抬头"),
    //---------------龙抬头活动相关奖品    end---------------


    SPE_RED_PACKET("财源滚滚红包"),
    SPE_RED_PACKET_CASH("现金红包"),
    SPE_RED_PACKET_GIFT("投资红包"),
    //-------老虎机档--------
    ONE_ARMED_BANDIT_1("欢乐老虎机第一档"),
    ONE_ARMED_BANDIT_2("欢乐老虎机第二档"),
    ONE_ARMED_BANDIT_3("欢乐老虎机第三档"),
    ONE_ARMED_BANDIT_4("欢乐老虎机第四档"),

    //-------双节提前庆--------
    PRENATIONALDAY_PRIZE_1("双节提前庆第一档"),//仅在初始化参数时
    PRENATIONALDAY_PRIZE_2("双节提前庆第二档"),//仅在初始化参数时

    PRENATIONALDAY_PRIZETYPE_2017("双节提前庆奖品类型"),

    /** 出借分享红包 */
    INVEST_SHARE_REDPACKET("出借分享红包"),

    DOUBLE11_2017_PRIZE_TYPE("2017双十一活动抢加息券奖品类型"),

    DOUBLE11_2017_RACELAMP_TYPE1("2017双十一活动跑马灯奖品类型1"),
    DOUBLE11_2017_RACELAMP_TYPE2("2017双十一活动跑马灯奖品类型2'1111+实物'");

    private final String key;

    private LotteryType(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
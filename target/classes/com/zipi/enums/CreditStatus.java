package com.zipi.enums;


import com.zipi.base.BaseEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * author linzhicheng
 * 2018年3月1日15:09:23
 * 债权状态枚举
 */
public enum CreditStatus implements BaseEnum {

    INITIATED("初始"),//暂时保留
    /**
     * 募集中
     */
    OPENED("募集中"),
    /*
       出让失败
     */
    FAILED("出让失败"),//终态

    /**
     * 资金募集完成，等待结算
     */
    FINISHED("募集完成"),//包括部分和全部
    /**
     * 被后台取消
     */
    CANCELED("已取消"),//全部取消，终态

    /**
     * 结算过程中临时状态
     */
    SETTLING("结算中"),
    /**
     * 资金进入出让人账户，进入回购周期
     */
    SETTLED("已结算"),
    /**
     * 完成结算后或结算后取消剩余部分
     */
    UNCLEARED("待结清"),


    /**
     * 出让人主动回购完成（回购）
     */
    CLEARED("结清"),//终态
    /**
     * 出让人主动回购完成，逾期（回购）
     */
    OVERDUE_CLEARED("逾期结清"),//终态
    /**
     * 出让人还清垫资款（回购）
     */
    CLEARED_COMPENSATORY("结清垫资"),


    /**
     * 第三方垫资回购完成（垫资）
     */
    COMPENSATORY_CLEARED("垫资结清"),

    /**
     * 第三方垫资回购完成，逾期（垫资）
     */
    OVERDUE_COMPENSATORY_CLEARED("逾期垫资结清"),


    /**
     * 第三方垫资回购完成
     */
    COMPENSATORY_CLEARING("垫资回购中"),

    /**
     * 还款结清债转（还款）
     */
    CLEARED_REPAYED("还款结清"),
    /**
     * 还款结清逾期债转（还款）
     */
    OVERDUE_CLEARED_REPAYED("还款逾期结清"),
    /**
     * 出让人还清垫资款（还款）
     */
    COMPENSATORY_CLEARED_REPAYED("还款结清垫资"),
    /**
     * 结清逾期垫资款（还款）
     */
    OVERDUE_COMPENSATORY_CLEARED_REPAYED("还款结清逾期垫资");

    private final String key;

    CreditStatus(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    /**
     * 前台债权列表展示状态集合
     * @return
     */
    public static List<CreditStatus> getStatusForMarketList() {
        List<CreditStatus> list = new ArrayList<>();
        list.add(CreditStatus.OPENED);
        list.add(CreditStatus.FINISHED);
        list.add(CreditStatus.SETTLING);
        list.add(CreditStatus.SETTLED);
        list.add(CreditStatus.UNCLEARED);
        list.add(CreditStatus.CLEARED);
        return list;
    }

    /**
     * 个人发起债转时判断是否有债转标
     */
    public static List<CreditStatus> getStatusForUserCredit() {
        List<CreditStatus> list = new ArrayList<>();
        list.add(CreditStatus.INITIATED);
        list.add(CreditStatus.OPENED);
        list.add(CreditStatus.FINISHED);
        list.add(CreditStatus.SETTLING);
        list.add(CreditStatus.SETTLED);
        return list;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.modules.contract.enums;


import com.zipi.modules.base.enums.BaseEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 借款状态
 *
 * @author sobranie
 */
public enum LoanStatus implements BaseEnum {

    /**
     * 由LoanRequest转化后的初始状态
     */
    INITIATED("初始"),
    /**
     * 已经确定了发布时间
     */
    SCHEDULED("预告"),
    /**
     * 募集中
     */
    OPENED("募集中"),
    /**
     * 到期未能完成资金募集，流标
     */
    FAILED("流标"),
    /**
     * 资金募集完成，等待结算/审核
     */
    FINISHED("已满标"),
    /**
     * 被后台取消
     */
    CANCELED("已取消"),
    /**
     * 资金进入借款人账户，进入还款周期
     */
    SETTLED("已结算"),
    /**
     * 所有还款成功结束
     */
    CLEARED("已还清"),
    /**
     * 逾期未归还，任何一期还款超过dueDate都自动转为此状态
     */
    OVERDUE("逾期"),
    /**
     * 贷款违约,剩余贷款无法偿还
     */
    BREACH("违约"),
    /**
     * 已存档
     */
    ARCHIVED("已存档"),

    /**
     * 保存未发布
     * */
    UNPUBLISH("保存未发布");

    private final String key;

    private LoanStatus(final String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    /**
     * check whether a loan can be canceled
     *
     * @param status
     * @return
     */
    public static boolean tryCancel(LoanStatus status) {
        switch (status) {
            case INITIATED:
            case SCHEDULED:
            case FAILED:
            case CANCELED:
                return true;
        }

        return false;
    }

    /**
     * 获取 OPENED、FINISHED、 SETTLED、CLEARED、FAILED状态
     *
     * @return
     */
    public static List<LoanStatus> getExcetedStatus() {
        List<LoanStatus> list = new ArrayList<>();
        list.add(LoanStatus.OPENED);
        list.add(LoanStatus.FINISHED);
        list.add(LoanStatus.SETTLED);
        list.add(LoanStatus.CLEARED);
        list.add(LoanStatus.FAILED);
//        list.add(LoanStatus.SCHEDULED);
        return list;
    }

    public static List<LoanStatus> getStatus() {
        List<LoanStatus> list = new ArrayList<>();
        list.add(LoanStatus.OPENED);
        list.add(UNPUBLISH);//对应页面上的保存未发布
        list.add(LoanStatus.INITIATED);
        list.add(LoanStatus.SCHEDULED);
        list.add(LoanStatus.FINISHED);
        list.add(LoanStatus.SETTLED);
        list.add(LoanStatus.CLEARED);
        list.add(LoanStatus.FAILED);
        list.add(LoanStatus.CANCELED);
        list.add(LoanStatus.OVERDUE);
        list.add(LoanStatus.BREACH);
        list.add(LoanStatus.ARCHIVED);
        return list;
    }
    public static List<LoanStatus> getNormolStatus() {
        List<LoanStatus> list = new ArrayList<>();
        list.add(LoanStatus.FINISHED);
        list.add(LoanStatus.SETTLED);
        list.add(LoanStatus.CLEARED);
        list.add(LoanStatus.OPENED);

        return list;
    }

    public static List<LoanStatus> getStatusForMarketLoanList() {
        List<LoanStatus> list = new ArrayList<>();
        list.add(LoanStatus.SCHEDULED);
        list.add(LoanStatus.OPENED);
        list.add(LoanStatus.FINISHED);
        list.add(LoanStatus.SETTLED);
        list.add(LoanStatus.CLEARED);

        return list;
    }
    public static List<LoanStatus> getStatusForLoanList() {
        List<LoanStatus> list = new ArrayList<>();
        list.add(LoanStatus.OPENED);
        list.add(LoanStatus.FINISHED);
        list.add(LoanStatus.SETTLED);
        list.add(LoanStatus.CLEARED);

        return list;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.modules.contract.enums;


import com.zipi.modules.base.enums.BaseEnum;

/**
 *
 * @author rooseek
 */
public enum LoanRequestStatus implements BaseEnum {

    UNASSIGNED("未处理"),
    ASSIGNED("已处理"),
    CANCELED("已取消"),//只有在UNASSIGNED和ASSIGNED状态的可以取消
    PENDING_VISIT("实地征信"),
    PENDING_RISK("风控审核"),
    PENDING_APPORVE("待批准"),
    APPROVED("已批准"),
    REJECTED("已驳回"),
    ARCHIVED("已存档"),
    DELETED("已刪除"),
    PUBLISHED("已发布"),
    UNPUBLISHED("未发布");

    private final String key;
    
    private LoanRequestStatus(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

//    /**
//     * check whether a loan request can be canceled
//     *
//     * @param status
//     * @return true if UNASSIGNED or ASSIGNED, false else
//     */
//    public static boolean tryCancel(LoanRequestStatus status) {
//        switch (status) {
//            case UNASSIGNED:
//            case CANCELED:
//                return true;
//        }
//
//        return false;
//    }
}

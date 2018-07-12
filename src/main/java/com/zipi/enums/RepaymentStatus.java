/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.enums;


import com.zipi.base.BaseEnum;

/**
 *
 * @author rooseek
 */
public enum RepaymentStatus implements BaseEnum {

    //每期还款的状态
    UNDUE("未到期"),
    OVERDUE("逾期"),
    BREACH("违约"),
    REPAYED("已还清"),
    PRE_COMPENSATORY_REPAYED("代偿预处理"),
    COMPENSATORY_REPAYED("代偿还清"),
    PRE_REPAY_COMPENSATORY("还代偿预处理"),
    SETTLE_COMPENSATORY_REPAYED("还清代偿"),
    /**
     * TODO 暂时未用上,一律用REPAYED表示已还状态</p>
     * 出现逾期或违约后，回收或垫付的状态
     */
    COLLECTED("已回收"),
    PRE_REPAID("已授权预处理");

    private final String key;

    private RepaymentStatus(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}

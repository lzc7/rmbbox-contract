package com.zipi.modules.contract.enums;

import com.zipi.modules.base.enums.BaseEnum;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Tony on 2015/6/9.
 */
public enum RmbRepayMethod implements BaseEnum {

    MonthlyInterest("按月付息到期还本（以天计息）", "还款压力小"),
    MonthlyInterestByMonthly("按月付息到期还本", "还款压力小"),
    EqualInstallment("按月等额本息", "还款便捷"),
    EqualPrincipal("按月等额本金", "总利息最低"),
    BulletRepayment("一次性还本付息", "短期首选"),
    InterestFirst("上付息", "上付息"),
    EqualInterest("月平息", "实际利率最高");

    private final String key;

    private final String desc;

    private RmbRepayMethod(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    @Override
    public String getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }

    public static List<RmbRepayMethod> getPulbicRmbLoanMethod(){
        return Arrays.asList(
                RmbRepayMethod.MonthlyInterestByMonthly,
                RmbRepayMethod.BulletRepayment,
                RmbRepayMethod.EqualInstallment);
    }

}

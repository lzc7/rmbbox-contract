package com.zipi.modules.contract.entity;

import com.zipi.modules.base.entity.BaseObject;
import com.zipi.modules.contract.enums.CreditStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class RmbboxCreditSale extends BaseObject {

    /** id(转让id/回购id) */
    private Long id;

    /** 标的主键id */
    private String loanId;

    /** 债权总额 */
    private BigDecimal amount;

    /** 已认购金额 */
    private BigDecimal subscribeAmount;

    /** 已认购人数 */
    private Integer subscribeNumber;

    /** 年利率 */
    private BigDecimal rate;

    /** 债权状态（初始，募集中，取消，募集完成，已结算，已回购） */
    private CreditStatus status;

    /** 债权满标时间 */
    private Date finishedTime;

    /** 债权开始时间 */
    private Date createTime;

    /** 债权结算时间 */
    private Date settledTime;

    /** 债权取消时间 */
    private Date cancleTime;

    /** 修改时间 */
    private Date updateTime;

    /** 债权名称 */
    private String title;

    /** 债权天数 */
    private Integer days;

    /** 债权月数 */
    private Integer months;

    /** 债权年数 */
    private Integer years;

    /** 债权申请编号 */
    private String requestNo;

    /** 用户编号 */
    private String userId;

    /** 原始投资id */
    private String investId;

    /** 债权类型(0:债权转让,1:债权回购) */
    private int type;

    /** 原始债权出让id */
    private long originCreditId;

    /** 冻结金额 */
    private BigDecimal frozenAmount;

    /** 垫资人id */
    private String compensatorId;

    /** 认购人利率 */
    private BigDecimal investRate;

    /** 结转利息 */
    private BigDecimal creditInterest;

    /** 管理费 */
    private BigDecimal manageAmount;

    /** 管理费率 */
    private BigDecimal manageRate;

    /** 调价费 */
    private BigDecimal modifyPrice;

    //进度
    public  String getPercent() {
        if (getRatio() == 100.0) {
            return "100";
        }
        return String.valueOf(getRatio());
    }

    private double getRatio(){

        BigDecimal ratio = new BigDecimal(String.valueOf(subscribeAmount.doubleValue()/amount.doubleValue()*100));
//		return ratio.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        if (ratio.doubleValue()> 0.9d){
            return ratio.setScale(1, BigDecimal.ROUND_FLOOR).doubleValue();
        }
        else if (ratio.doubleValue()< 0.1d){
            return ratio.setScale(1, BigDecimal.ROUND_CEILING).doubleValue();
        }
        else{
            return ratio.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
    }

    /**
     * 扩展字段
     */
    private String userName;
    private String idNumber;
}

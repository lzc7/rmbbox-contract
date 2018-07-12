package com.zipi.entity;

import com.zipi.base.BaseObject;
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
public class RmbboxLoanServiceRepayment extends BaseObject {

    /** 主键id */
    private String id;

    /** 当前期数 */
    private Integer currentPeriod;

    /** 当前期数应还服务费金额 */
    private BigDecimal repayAmount;

    /** 担保费金额 */
    private BigDecimal loanGuaranteeFeeAmount;

    /** 利息管理费金额 */
    private BigDecimal loanInterestFeeAmount;

    /** 风险管理费金额 */
    private BigDecimal loanFiskFeeAmount;

    /** 借款管理费金额 */
    private BigDecimal loanManageFeeAmount;

    /** 服务费金额 */
    private BigDecimal loanServiceFeeAmount;

    /** 分润服务费 */
    private BigDecimal loanShareFeeAmount;

    /**
     * 服务费是否到账
     * 0初始、1已预处理，2已到账
     */
    private String flagServiceCharge;

    /** 处理日期 */
    private Date dueDate;

    /** 标的id */
    private String loanId;

    /** 修改时间 */
    private Date modifyTime;


    public RmbboxLoanServiceRepayment(String id, Integer currentPeriod,
                                      BigDecimal loanGuaranteeFeeAmount,
                                      BigDecimal loanInterestFeeAmount,
                                      BigDecimal loanFiskFeeAmount,
                                      BigDecimal loanManageFeeAmount,
                                      BigDecimal loanServiceFeeAmount,
                                      BigDecimal loanShareFeeAmount,
                                      String loanId,
                                      Date dueDate) {
        this.id = id;
        this.currentPeriod = currentPeriod;
        this.loanGuaranteeFeeAmount = loanGuaranteeFeeAmount;
        this.loanInterestFeeAmount = loanInterestFeeAmount;
        this.loanFiskFeeAmount = loanFiskFeeAmount;
        this.loanManageFeeAmount = loanManageFeeAmount;
        this.loanServiceFeeAmount = loanServiceFeeAmount;
        this.loanShareFeeAmount = loanShareFeeAmount;
        this.loanId = loanId;
        this.repayAmount = loanGuaranteeFeeAmount.add(loanInterestFeeAmount)
                .add(loanFiskFeeAmount)
                .add(loanManageFeeAmount)
                .add(loanServiceFeeAmount).add(loanShareFeeAmount);
        this.dueDate = dueDate;
    }
}
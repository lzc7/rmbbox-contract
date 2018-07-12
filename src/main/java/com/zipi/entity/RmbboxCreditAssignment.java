package com.zipi.entity;

import com.zipi.base.BaseObject;
import com.zipi.enums.CreditStatus;
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
public class RmbboxCreditAssignment extends BaseObject {

    /** 债权认购id */
    private Integer id;

    /** 债权出让id */
    private long creditId;

    /** 债权认购金额 */
    private BigDecimal amount;

    /** 创建时间 */
    private Date createTime;

    /** 用户id */
    private String userId;

    /** 订单号 */
    private String orderId;

    /** 类型（0：认购；1：回购） */
    private Boolean type;

    /** 操作客户端 WEB-pc端 MSTATION-m站 WECHAT-微信 MOBILE-移动端（原） ANDROID-安卓 IOS-苹果 */
    private String client;

    /** 道具加息金额 */
    private BigDecimal interestAmount;

    /** 道具id */
    private String propId;

    /** 道具类型 */
    private String propType;

    /** 扩展字段 */
    private CreditStatus status;

    /** 份额 */
    private BigDecimal share;

    /** 结转利息 */
    private BigDecimal creditInterest;

    /** 是否最后一个购买出让人最后一笔债权 */
    private Boolean isLast;

    /** 认购加息金额 */
    private BigDecimal raiseAmount;

    /**
     * 扩展字段
     */
    private String userName;

    private String idNumber;
    /** 出借分享红包标志 */
    private boolean shareFlag;
}
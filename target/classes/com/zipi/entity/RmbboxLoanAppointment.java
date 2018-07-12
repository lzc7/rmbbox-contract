package com.zipi.entity;

import com.zipi.base.BaseObject;
import com.zipi.enums.AppointmentStatus;
import com.zipi.enums.common.Source;
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
public class RmbboxLoanAppointment extends BaseObject {

    /** 预约主键id */
    private String appointmentId;

    /** 用户id */
    private String userId;

    /** 授权金额 */
    private BigDecimal appointmentAmount;

    /** 冻结金额 */
    private BigDecimal frozenAmount;

    /** 解冻金额 */
    private BigDecimal releaseAmount;

    /** 匹配金额 */
    private BigDecimal matchAmount;

    /** 对接项目 */
    private String productAllow;

    /** 最小年利率 */
    private BigDecimal rateMin;

    /** 最大年利率 */
    private BigDecimal rateMax;

    /** 预约状态 */
    private AppointmentStatus status;

    /** 取消授权时间 */
    private Date cancelTime;

    /** 匹配成功时间 */
    private Date matchTime;

    /** 预约申请时间 */
    private Date createTime;

    /** 最小期限 */
    private Integer daysMin;

    /** 最大期限 */
    private Integer daysMax;

    /** 标的id */
    private String loanId;

    /** 项目类型  short-短期，midShort-中短期 middle-中期 long-长期*/
    private String projectType;

    /** 匹配标识 */
    private Boolean matchFlag;

    /** 项目名称 */
    private String title;

    /** 预约来源
     *
     WEB("公共网络"),
     BACK("系统后台"),
     MSTATION("M站"),
     WECHAT("微信"),
     MOBILE("移动端"),
     ANDROID("安卓"),
     IOS("苹果"),
     android_borrower("安卓借款端"),
     ios_borrower("苹果借款端")
     */
    private Source source;
    /** ip地址*/
    private String ip;
    //渠道
    private String channel;
    //道具id
    private String propId;
    //道具类型
    private String propType;

    /*
    扩展字段
     */
    private String idNumber;
    private String userName;


}
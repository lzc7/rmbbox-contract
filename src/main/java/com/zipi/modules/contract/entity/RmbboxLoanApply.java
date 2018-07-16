package com.zipi.modules.contract.entity;

import com.zipi.modules.base.entity.BaseObject;
import com.zipi.modules.base.entity.Source;
import com.zipi.modules.contract.enums.BorrowPartnerSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class RmbboxLoanApply extends BaseObject {
    /** id */
    private int id;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
    /** 更新人 */
    private String updateId;
    /** 用户编号 */
    private String userId;
    /** 金额 */
    private BigDecimal amount;
    /** 天 */
    private Integer days;
    /** 月 */
    private Integer months;
    /** 年 */
    private Integer years;
    /** 综合利率 */
    private BigDecimal rate;

    private BigDecimal loanRate;//借款人利率

    private BigDecimal managementRate;//平台管理费率

    /** 还款方式 */
    private String requestMethod;
    /** 借款类型 */
    private String requestType;
    /** 状态 */
    private Integer status;
    /** request id */
    private String requestId;
    /** 渠道标识 */
    private Source client;

    private String requestMethodName;
    /** 借款类型 */
    private String requestTypeName;

    private BorrowPartnerSource borrowPartnerSource;

    /** 初审员工 */
    private String auditEmpIdFir;

    /** 二审员工 */
    private String auditEmpIdSen;

    /** 初审意见 */
    private String auditOpinionFir;

    /** 二审意见 */
    private String auditOpinionSen;

    /** 借款来源说明 */
    private String borrowPartnerSourceDesc;

    private String baseInfo;

}

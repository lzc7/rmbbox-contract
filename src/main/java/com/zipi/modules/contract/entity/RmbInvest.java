package com.zipi.modules.contract.entity;

import com.zipi.modules.base.entity.BaseObject;
import com.zipi.modules.base.entity.Source;
import com.zipi.modules.contract.enums.InvestStatus;
import com.zipi.modules.contract.enums.LoanPurpose;
import com.zipi.modules.contract.enums.LoanRequestTypes;
import com.zipi.modules.contract.enums.RmbRepayMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 邦帮堂投标信息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RmbInvest extends BaseObject {

    private String investId;


    private BigDecimal investAmount;

    private String loanId;


    private int loanRate;

    private RmbRepayMethod repaymentType; //还款方式

    private InvestStatus status; // 投资状态


    private Date submitTime;

    private String userId;

    private String orderId;


    private int days;

    private int months;

    private int years;


    private LoanPurpose purpose;

    private CoreUser coreUser;


    private RmbLoan loan;

    private List<RmbInvestRepayment> investRepaymentList;
    
    // 官网页面使用
    private String userLoginName;
    
    private CoreUser user;

    private Date nextRepayDate;// 下一个还款日
    
   private Date repayDate;//回款日期
   
   private BigDecimal raisingRates;//加息率
   
   private Integer  outTimes;//募集时长（单位：小时）
   
   private long remOutTimes;//剩余募集时间
   
   private BigDecimal  process;//该产品的进度值

   private BigDecimal  repayAmount;//预期回款金额
   
   private Source client; // 投资的客户端类型

   private  String  loanPeriod;//投资期限

   private Date settledTime;//标的结算时间

   private String requestId;//标的申请ID

    private LoanRequestTypes requestType;//借款类型

   private BigDecimal amountInterest;//应得利息

    private String userName;//用户名

    private String idNumber;//身份证号
    //道具加息金额
    private BigDecimal interestAmount;
    //道具id
    private String propId;
    //道具类型
    private String propType;

    private RmbRepayMethod repayMethod;

    private int investWay; //投资方式（0：手动投标，1：预约投标，2：自动出借）

    private String ruleId; // 预约标id 或 方案规则id

    public String getRepayMethodTypeKey() {
        return repaymentType.getKey();
    }

    /** 出借分享红包标志 */
    private boolean shareFlag;

    /** 是否已转让 */
    private boolean creditFlag = false;
}
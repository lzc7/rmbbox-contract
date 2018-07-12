package com.zipi.entity;

import com.zipi.base.BaseObject;
import com.zipi.enums.bbt.GuaranteeType;
import com.zipi.enums.bbt.LoanRequestTypes;
import com.zipi.enums.bbt.RmbRepayMethod;
import com.zipi.enums.contract.ContractType;
import com.zipi.enums.loan.LoanPurpose;
import com.zipi.enums.loan.LoanRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 标的申请相关信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RmbLoanRequest extends BaseObject {

    private String requestId;

    private BigDecimal amount;

    private String requestDes;//标的描述

    private String empId;//员工id

    private String guaranteeInfo;//担保信息

    private RmbRepayMethod requestMethod;//还款方式

    private String mortgagedInfo;//抵押信息

    private Boolean mortgaged;//是否有抵押

    private LoanPurpose purpose;//借款目的
    private String purposeStr;//借款目的String

    public String getPurposeStr() {
        if(null != this.purpose){
            this.purposeStr = purpose.getKey();
        }
        return purposeStr;
    }

    public void setPurposeStr(String purposeStr) {
        this.purposeStr = purposeStr;
    }

    private int rate;//年化利率


    private String riskInfo;//风险信息

    private LoanRequestStatus status;//标的状态


    private Date submitTime;//提交申请时间

    private String requestTitle;//标的名称


    private String userId;//借款人id

    private int days;//标的天数


    private int months;

    private int years;


    private int maxAmount;

    private int minAmount;

    private int stepAmount;

    private String loanName;

    private String idNumber;

    private LoanRequestTypes requestType;//借款类型

    private int rateAdd;//候补年利率


    private GuaranteeType guaranteeType;//保障类型
    
    private  String modifyEmpId;
    private  String templateId;//模板id


    private  Date modifyTime;


    private CoreUser coreUser;
    
    /**
     * 合同模板类型
     */
    private ContractType type;
    
    
    
    private RmbLoanRequestFee rmbLoanRequestFee;//关联费率
    
    private  RmbContractTemplate rmbContractTemplate;

    private String compensatoryId;//担保公司id

    private String compensatoryName;//担保公司

    private String welcomeName;

    private int loanProperty; //标的属性(0:普通标,1:新手标,2:推荐标,3:智能标)

    private int loanRepay; //到账日T+(0,1,2,3)

    private Date settledTime;//结算时间

    private int shareRate;//分润费率

    private String supplier; //第三方供应商


    /** 是否隐藏不显示
     * 1：隐藏，不在前端显示
     * 0：不隐藏，在前端显示
     * */
    private Boolean flagHidden;

    private Date topTime;//置顶时间

    private String supplierName;

    private String loanApplyId;

    //标的渠道
    private String loanChannel;
    //是否渠道标的
    private Boolean flagChannel;
    //标的状态
    private int loanStatus;
    //标的编号
    private String loanId;

    private BigDecimal loanServiceFee;
}
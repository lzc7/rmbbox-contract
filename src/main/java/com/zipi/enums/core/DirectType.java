package com.zipi.enums.core;


import com.zipi.base.BaseEnum;

/**
 * Created by veryyoung on 2015/7/3.
 */
public enum DirectType implements BaseEnum {

    FundInvest("投标"),
    FundWithdraw("取现"),
    FundDeposit("充值"),
    FundLoan("放款"),
    FundBBTSettle("投资解冻"),
    FundLoanRepay("贷款还款"),
    FundInvestRepay("投资还款"),
    CompensatoryRepay("代偿还款"),
    CurrentRedemption("零存宝转出"),
    FundTransfer("转账扣款"),
    DISBURSE("垫付还款"),
    CREDIT_ASSIGN("债权转让"),
    FundFee("服务费，手续费，管理费"),
    TransferToUser("商户给用户转账"),
    InvestIn("投资入账"),
    FundRewards("平台奖励"),
    AccountCheck("对账"),
    Settlement("账户结算"),
    UserAmountFreeze("冻结用户金额"),
    UserAmountRelease("解冻用户金额"),
    CashPacketDeduction("现金红包扣减"),
    RaiseInterestRepay("加息券收益还款"),
    GuaranteeFeeRepay("担保费还款"),
    ShareFeeRepay("分润费还款"),
    ServiceFeeRepay("服务费还款"),
    InvestCompensatoryRepayment("代偿还款"),
    OverdueRepayment("逾期还款"),
    Investforward("出借账户转账平台账户"),
    DeductionFee("扣费"),
    CreditSettle("债权结算"),
    CreditAssignment("债权认购"),
    CreditRepayment("债权回款"),
    CreditOverdueAmount("债权回款逾期费"),
    CreditClear("债权结清");


    private final String key;

    DirectType(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}

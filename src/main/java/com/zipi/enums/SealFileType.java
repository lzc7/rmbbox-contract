package com.zipi.enums;


import com.zipi.base.BaseEnum;

public enum SealFileType implements BaseEnum {
	
	
	NOTICEBILL("通知单"),
	NEXTMONTHNOTICEBILL("次月报告"),
	SELLBILL("卖单文件"),
	ZJCJBG("资金出借报告"),
	REGULAFILE("定期协议"),
	COMPOUNDFILE("复利协议"),
	MONTHWINFILE("月赢协议"),
	BBTFILE("直投协议"),
	
	NEW_NOTICEBILL("通知单"),
	NEW_SELLBILL("卖单文件"),
	NEW_ZJCJBG("资金出借报告"),
	NEW_REGULAFILE("定期协议"),
	NEW_MONTHWINFILE("月赢协议"),
	
	/**版本3 ：专用协议 */
	VRESION_THREE_FILE("定期协议"),
	LOAN_CONTRACT("借款合同"),
	
   /**新资产文件*/
   SubscriptionAgreement("认购协议"),
   ProductIntroduction("产品说明书"),
   ExchangeSubscriptionAgreement("交易所认购协议"),

	BillLoanAgreementForLoan("借款方票据质押委托借款协议"),
	BillLoanAgreementForLend("出借方票据质押委托借款协议"),

	CarLoanAgreementForLoan("借款方车贷标借款协议"),
	CarLoanAgreementForLend("出借方车贷标借款协议"),

	CarLoanMediatorContract("居间服务合同"),

	CreditLoanAgreementForLend("出借方信贷标借款协议"),
	CreditLoanAgreementForLoan("借款方信贷标借款协议"),

	AgreementForGuarantor("保证担保合同"),

	AppointmentAgreement("自动出借服务协议"),

	AssignorAgreement("出让方债权转让协议"),
	AssigneeAgreement("受让方债权转让协议"),

	AgreementForCompensator("借款代偿协议");
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return key;
	}


    private final String key;

    private SealFileType(String key) {
        this.key = key;
    }

}

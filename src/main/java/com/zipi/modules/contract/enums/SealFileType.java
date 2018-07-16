package com.zipi.modules.contract.enums;


import com.zipi.modules.base.enums.BaseEnum;

public enum SealFileType implements BaseEnum {
	
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

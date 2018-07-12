package com.zipi.enums.bbt;


public enum UpperRealm {

	SYSTEM_MANAGEMENT(Realm.USER.name(),Realm.EMPLOYEE.name(),Realm.CHANNEL.name(),
			Realm.KEFUCALLED.name(),Realm.SYSTEM_SETTING.name(),Realm.DICT_MANAGER.name(),Realm.REGISTERSOURCE.name(),Realm.ANTIFRAUD.name()),//系统管理
    
    PRODUCT_MANAGEMENT(Realm.LOANREQUEST.name(),Realm.UPLAN.name()),
    
    PROJECT_MANAGEMENT(Realm.LOAN.name(),Realm.CONTRACT.name(),Realm.SETTLEMENT.name()),
    
    MONEY_MANAGEMENT(Realm.FUND.name(),Realm.WITHDRAW.name()),
    
    MARKETING_MANAGEMENT(Realm.REWARD.name()),
    
    CLAIM_PROJECT(Realm.CLAIM_MANAGER.name(),Realm.CLAIM_PRODUCT_PUBLICSH.name(),Realm.CLAIM_DAY_END_TASKS.name(),Realm.CURRENT_PRODUCT.name(),
    		Realm.MONTH_WIN_PRODUCT.name(),Realm.RECYCLE_INTEREST_PRODUCT.name(),Realm.FIXED_PRODUCT_A.name(),
    		Realm.FIXED_PRODUCT_B.name(),Realm.FIXED_PRODUCT_C.name(),Realm.FIXED_PRODUCT_D.name(),Realm.NEW_HAND_PRODUCT.name(),Realm.PRODUCT_CONFIG_LIST.name()),
    NMD_MANAGER_UPPER(Realm.NMD_MANAGER.name()),
    ACTIVITY_STATISTICS(Realm.STATISTICS.name(),Realm.PROMOTE.name());
	
	 private final String[] key;

    private UpperRealm(String... key) {
        this.key = key;
    }
    public static String[] getUpperRealm(String realm){
    	for (int i = 0; i < UpperRealm.values().length; i++) {
			if(UpperRealm.values()[i].name().equalsIgnoreCase(realm)){
				return UpperRealm.values()[i].key;
			}
		}
		return null;
    }
}

package com.zipi.enums.pay;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 支付通支持的银行列表
 * @author guowt
 *
 */
public enum ZFTSupportBank implements Serializable{
	 ICBC("中国工商银行", "01020000"),

	 BOC("中国银行", "01040000"),
	
	 CCB("中国建设银行", "01050000"),
	
     ABC("中国农业银行", "01030000"),
     
     BCM("交通银行", "03010000"),

     PSBC("中国邮政储蓄银行", "01000000"),

     CMB("招商银行", "03080000"),

     CEB("光大银行", "03030000"),
  
     SPDB("浦发银行", "03100000"),//招商银行和浦发银行只能用扣款鉴权
     
     CNCB("中信银行", "03020000"),
     
     PAD("平安银行", "03070000"),//平安银行与深圳发展银行编码一致，但是不支持快捷支付
     
     CMSB("民生银行", "03050000"),
    
     CIB("兴业银行", "03090000");
	
	private String bankName;
	
	private String bankCode;
	
	private ZFTSupportBank(String bankName,
						 String bankCode){
		this.bankName = bankName;
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public String getBankCode() {
		return bankCode;
	}
	
	public static String getName(String bankCode){
		for(ZFTSupportBank bank : ZFTSupportBank.values()){
			if(bank.getBankCode().equals(bankCode))
				return bank.getBankName();
		}
		return null;
	}
	
	public static List<String> getAllBankNames(){
		List<String> bankNames = new ArrayList<>();
		List<ZFTSupportBank> bankList = Arrays.asList(ZFTSupportBank.values());
		for (int i = 0; i < bankList.size(); i++) {
			bankNames.add(bankList.get(i).name());
		}
		return bankNames;
	}
	
	/**
	 * 为app提供
	 * @return
	 */
	/*public static List<Map<String, Object>> getAllBankInfos(){
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		for (ZFTSupportBank bank : ZFTSupportBank.values()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("bankCode", bank);
			map.put("bankname", bank.getBankName());
			
			mapList.add(map);
		}
		
		return mapList;
	}
	public static ZFTSupportBank getValue(String key){
		for(ZFTSupportBank type : ZFTSupportBank.values()){
			if(key.equals(type.getBankName()))
				return type;
		}
		return null;
	}
	public static void main(String[] args) {
		System.out.println(getAllBankInfos());
	}*/
}

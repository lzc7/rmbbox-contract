package com.zipi.enums.pay;

import java.io.Serializable;
import java.util.*;

/**
 * 连连支持的银行列表
 * @author wangh_000
 *
 */
public enum LLSupportBank implements Serializable{

	ICBC("中国工商银行", "01020000", "#d74b45"),

	ABC("中国农业银行", "01030000", "#129051"),

	BOC("中国银行", "01040000", "#d74b45"),

	CCB("中国建设银行", "01050000", "#0098df"),

	COMM("交通银行", "03010000", "#0098df"),

	CMB("招商银行", "03080000", "#d74b45"),

	CEB("光大银行", "03030000", "#ba53b2"),

	CMSB("民生银行", "03050000", "#129051"),

	SPDB("浦发银行", "03100000", "#0098df"),

	CGB("广东发展银行", "03060000", "#d74b45"),

	CNCB("中信银行", "03020000", "#d74b45"),

	CIB("兴业银行", "03090000", "#0098df"),

	PSBC("中国邮政储蓄银行", "01000000", "#129051"),

	HXB("华夏银行", "03040000", "#d74b45"),

	PAB("平安银行", "03070000", "#ea9323"),

	//fhj 添加银行 start   可以进行绑卡，但是不支持快捷支付
	//NOTE: add default color for the following card @Jeff Xiao 2016-05-19
	BCCB("北京银行", "04031000", "#d74b45"),
	BOS("上海银行", "04012900", "#ea9323"),
	NBCB("宁波银行", "04083320", "#ea9323"),
	GCB("广州银行", "", "#ea9323"),
	CZB("浙商银行", "03160000", "#ea9323"),
	HZCB("杭州银行", "04233310", "#ea9323"),
	//fhj end

	//xhp 添加银行
	JSCB("江苏银行","05083000","#ea9323"),
	GRCB("广州农商","14055810","#ea9323"),
	SNCB("上海农商","14055810","#ea9323"),
	BJRCB("北京农商","14055810","#ea9323"),
	SRCB("深农商行","14045840","#ea9323");
	//xhp end

	private String bankName;

	private String bankCode;

	private String bankColor;

	private LLSupportBank(String bankName,
						  String bankCode,
						  String bankColor){
		this.bankName = bankName;
		this.bankCode = bankCode;
		this.bankColor = bankColor;
	}

	/**
	 * 企业银行支持的银行
	 * @return
     */
	public static List<LLSupportBank> getEnterpriseBank() {
		return Arrays.asList(LLSupportBank.ICBC,// 工商
				LLSupportBank.ABC,// 农业
				LLSupportBank.CCB,// 建设
				LLSupportBank.SPDB,// 浦发
				LLSupportBank.CMB// 招商
				);
	}

	public String getBankName() {
		return bankName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public String getBankColor() {
		return bankColor;
	}

	public static String getName(String bankCode){
		for(LLSupportBank bank : LLSupportBank.values()){
			if(bank.getBankCode().equals(bankCode))
				return bank.getBankName();
		}
		return null;
	}

	public static List<String> getAllBankNames(){
		List<String> bankNames = new ArrayList<>();
		List<LLSupportBank> bankList = Arrays.asList(LLSupportBank.values());
		for (int i = 0; i < bankList.size(); i++) {
			bankNames.add(bankList.get(i).name());
		}
		return bankNames;
	}

	/**
	 * 为app提供
	 * @return
	 */
	public static List<Map<String, Object>> getAllBankInfos(){
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		for (LLSupportBank bank : LLSupportBank.values()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("bankCode", bank);
			map.put("bankname", bank.getBankName());

			mapList.add(map);
		}

		return mapList;
	}
	public static LLSupportBank getValue(String key){
		for(LLSupportBank type : LLSupportBank.values()){
			if(key.equals(type.name()))
				return type;
		}
		return null;
	}

	public static String getNameByBankCode(String bankCode){
		for(LLSupportBank bank : LLSupportBank.values()){
			if(bank.bankCode.equals(bankCode)){
				return bank.name();
			}
		}
		return "";
	}
	public static void main(String[] args) {
		System.out.println(getAllBankInfos());
	}
}

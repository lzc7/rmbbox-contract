package com.zipi.enums.pay;

import java.io.Serializable;

/**
 * @see 系统回调参数封装
 * @author haojunfu
 *
 */
public enum SystemTransportParamEnum implements Serializable{

	
	RESPONSE_CODE("response_code", "响应码","0000或者null表示响应成功"),//
	TRADE_CLASS("trade_class", "交易类别","请求交易的类别"),//
	AUTH_TOKEN("auth_token", "授权码","请求时要保存的授权码"),//
	RESPONSE_MESSAGE("response_message", "响应消息","异步通知响应消息"),//
	TRADE_SUBJECT("trade_subject", "信息摘要","异步通知响应消息摘要"),//
	OUT_TRADE_NO("out_trade_no", "商户流水号","每次请求产生唯一的流水号"),//
	//FINI 交易成功// WPAR 等待支付结果//ACSU 已受理// CLOS 交易关闭，失败//BUID 交易建立
	TRADE_STATUS("trade_status", "业务状态","表示通知的状态，可参考CodeConst常量");

	private String paramKey;
	private String paramName;
	private String paramDesc;
	private SystemTransportParamEnum(String paramKey, String paramName,
			String paramDesc) {
		this.paramKey = paramKey;
		this.paramName = paramName;
		this.paramDesc = paramDesc;
	}

	
	public String getParamKey() {
		return paramKey;
	}

	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamDesc() {
		return paramDesc;
	}

	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	}


	public static String getParamKey(String paramKey){
		for(SystemTransportParamEnum systp : SystemTransportParamEnum.values()){
			if(systp.getParamKey().equals(paramKey))
				return systp.getParamKey();
		}
		return null;
	}
	
	
	public static void main(String[] args) {
	}
}

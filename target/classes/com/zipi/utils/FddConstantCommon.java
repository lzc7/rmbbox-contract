package com.zipi.utils;

import com.zipi.config.DefinedProperties;

public enum FddConstantCommon {
	/**
	 * apiId
	 * TODO 请替换成贵平台的专属app_id
	 */
	API_ID("000219"),

	/**
	 * 密钥
	 * TODO 请替换成贵平台的专属secret
	 */
	APP_SECRET("9CVOEmCV7ZnAfM6HEuKkBEpR"),

	/**
	 * 版本
	 */
	V("1.0"),

	/**
	 * 地址
	 */
	API_URL("https://extapi.fadada.com/api2/"),
	/**
	 * 邦绑堂客户编号
	 */
	BBT_CUSTOMER_NO("EAFF715D9DECDB33"),
	NOTIFY_URL(""),

	// ========================基础接口 start======================
	/** 个人CA注册 */
	URL_SYNCPERSON_AUTO("syncPerson_auto.api"),

	/** 个人CA注册 身份证号*/
	URL_SYNCPERSON_MIN("syncPerson_min.api"),

	/** 上传文档 */
	URL_UPLOADDOCS("uploaddocs.api"),

	/** 上传模板 */
	URL_UPLOADTEMP("uploadtemplate.api"),

	/** 生成合同 */
	URL_GENERATE_CONTRACT("generate_contract.api"),

	/** 手动签署 */
	URL_EXTSIGN("extsign.api"),

	/** 自动签署 */
	URL_EXTSIGN_AUTO("extsign_auto.api"),

	/** 合同归档 */
	URL_CONTRACTFILING("contractFiling.api"),

	/** 下载合同 */
	URL_DOWNLOADCONTRACT("downLoadContract.api"),

	/** 查看合同 */
	URL_VIEWCONTRACT("viewContract.api"),

	/** 修改用户信息 */
	URL_INFOCHANGE("infochange.api"),

	// ========================基础接口 end========================


	// ========================扩展接口 start======================

	/** 手动签模式，带有效期 */
	URL_EXTSIGN_VALIDATION("extsign_validation.api"),

	/** 批量签署接口 */
	URL_BATCHSIGN("extBatchSign.api"),

	/** 文档批量签署接口(手工全自动) */
	URL_BATCH_SEMIAUTOSIGN("gotoBatchSemiautoSignPage.api"),

	/** 文档批量签署接口(全自动) */
	URL_BATCHSIGN_AUTO("extBatchSignAuto.api"),

	/** 查询签章状态 */
	URL_QUERY_SIGNSTATUS("query_signstatus.api"),

	/** 文档临时查看下载地址接口（带有效期和次数） */
	URL_GETURL("geturl.api"),

	/** 查询签章状态 */
	URL_QUERY_USERINFO("query_userinfo.action"),

	/** 文档批量签署接口 */
	URL_EXTBATCHSIGN("extBatchSign.api"),

	/** 文档批量签署接口(手工全自动) */
	URL_GOTO_BATCH_SEMIAUTO_SIGNPAGE("gotoBatchSemiautoSignPage.api"),

	/** 文档批量签署接口(全自动) */
	URL_EXTBATCHSIGN_AUTO("extBatchSignAuto.api"),
	// ========================扩展接口 end========================



	;
	/**
	 * 值
	 */
	private String value;

	/**
	 * 概要：FddConstantCommon类的构造函数
	 */
	FddConstantCommon(){};
	/**
	 * 概要：FddConstantCommon类的构造函数
	 * @param val
	 */
	FddConstantCommon(String val){
		this.value = val;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	static {
		API_ID.setValue(DefinedProperties.FDD_API_ID);
		APP_SECRET.setValue(DefinedProperties.FDD_APP_SECRET);
		V.setValue(DefinedProperties.FDD_V);
		API_URL.setValue(DefinedProperties.FDD_API_URL);
		BBT_CUSTOMER_NO.setValue(DefinedProperties.FDD_BBT_CUSTOMER_NO);
	}


}

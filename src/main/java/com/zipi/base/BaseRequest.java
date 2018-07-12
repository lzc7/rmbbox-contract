package com.zipi.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 连连支付请求基类
 * @author wangh_000
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class BaseRequest extends BaseObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7222215897786732093L;

	// #########   基本参数
	
	/**
	 * 商户编号
	 */
	private String oid_partner;
	
	/**
	 * 签名方式
	 */
	private String sign_type;
	
	/**
	 * 签名
	 */
	private String sign;
	
}

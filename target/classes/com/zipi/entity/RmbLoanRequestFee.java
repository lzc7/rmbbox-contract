package com.zipi.entity;

import com.zipi.base.BaseObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 贷款申请相关费率
 * @author guowt
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RmbLoanRequestFee extends BaseObject {
	private static final long serialVersionUID = -6981495798881918625L;
	private String id;
	/**
	 *回款(出借)利息管理费率
	 * */
	private BigDecimal investInterestFee = BigDecimal.ZERO;
	/**
	 * 担保费率（借款人）
	 * */
	private BigDecimal loanGuaranteeFee;
	/**
	 * 还款(借款)利息管理费率
	 * */
	private BigDecimal loanInterestFee = BigDecimal.ZERO;
	/**
	 * 风险管理费率（借款人）
	 * */
	private BigDecimal loanRiskFee = BigDecimal.ZERO;
	/**
	 *借款管理费率（借款人）
	 */
	private BigDecimal loanManageFee = BigDecimal.ZERO;
	/**
	 * 服务费率（借款人）
	 * */
	private BigDecimal loanServiceFee;

	/**
	 * 分润费率增加，对应表增加该字段
	 */
	private BigDecimal loanShareRate;

	/**
	 * 出借利息管理费率处理标识；0不处理，1：先扣除，2：后扣除
	 */
	private int investInterestDealFlag;

	/**
	 * 担保费率处理标识；0不处理，1：先扣除，2：后扣除
	 */
	private int loanGuaranteeDealFlag;

	/**
	 * 贷款利息管理费；0不处理，1：先扣除，2：后扣除
	 */
	private int loanInterestDealFlag;

	/**
	 * 管理费率处理标识；0不处理，1：先扣除，2：后扣除
	 */
	private int loanManageDealFlag;

	/**
	 * 风险管理费处理标识；0不处理，1：先扣除，2：后扣除
	 */
	private int loanRiskDealFlag;

	/**
	 * 服务费率处理标识；0不处理，1：先扣除，2：后扣除
	 */
	private int loanServiceDealFlag;

	/**
	 * 分润费率处理标识；0不处理，1：先扣除，2：后扣除
	 */
	private int loanShareDealFlag;


}
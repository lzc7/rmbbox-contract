package com.zipi.modules.contract.entity;

import com.zipi.modules.base.entity.BaseObject;
import com.zipi.modules.contract.enums.RepaymentStatus;
import com.zipi.core.util.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户投资还款相关信息
 */

/**
 * 用户投资还款相关信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RmbInvestRepayment extends BaseObject {
	@NotNull
	private String id;

	/**
	 * 期数
	 */
	@NotNull
	private int currentPeriod;
	/**
	 * 本期用户得到的还款金额
	 * */
	private BigDecimal repayAmount;
	/**
	 * 本期还款时间
	 */
	private Date repayTime;
	/**
	 * 本期还款状态
	 */
	private RepaymentStatus repayStatus;
	/**
	 * 回款状态名称
	 */
	private String repayStatusName;
	/**
	 * 本期用户应得利息
	 * */
	@NotNull
	private BigDecimal amountInterest;
	/**
	 * 本期用户应得本金
	 * */
	@NotNull
	private BigDecimal amountPrincipal;
	/**
	 * 剩余本金
	 * */
	@NotNull
	private BigDecimal amountOutStanding;
	/**
	 * 处理日期（如 2015:07:07）
	 */
	@NotNull
	private Date dueDate;
	/**
	 * 投资id
	 */
	@NotNull
	private String investId;

    private RmbInvest invest;

    private String userId;

    private String userName;

    private  BigDecimal  raiseInterest;  //加息券收益
	public RmbInvestRepayment(int currentPeriod,
                              BigDecimal repayAmount,
                              Date repayTime,
                              RepaymentStatus repayStatus,
                              Repayment repayment,
                              String investId) {
		this.currentPeriod = currentPeriod;
		this.repayAmount = repayAmount;
		this.repayTime = repayTime;
		this.repayStatus = repayStatus;
		this.amountInterest = repayment.getAmountInterest();
		this.amountPrincipal = repayment.getAmountPrincipal();
		this.amountOutStanding = repayment.getAmountOutstanding();
		this.dueDate = repayment.getDueDate();
		this.investId = investId;
	}

	public RmbInvestRepayment(BigDecimal amountPrincipal,
                              BigDecimal amountInterest,
                              BigDecimal amountOutStanding,
                              LocalDate dueDate) {
	this.amountPrincipal = amountPrincipal;
	this.amountInterest = amountInterest;
	this.amountOutStanding = amountOutStanding;
	this.dueDate = dueDate.toDate();
	}

	/**
	 * 逾期天数
	 */
	private int overdueDays;
	public int getOverdueDays() {
		if(null != dueDate){
			try {
				this.overdueDays = DateUtils.betweenDaysCeil(dueDate,new Date());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return overdueDays;
	}

	public void setOverdueDays(int overdueDays) {
		this.overdueDays = overdueDays;
	}

	private  Date submitTime;
	//还款标识（true 提前还款）
	private boolean repayFlag = false;
}
package com.zipi.modules.contract.enums;

import com.zipi.core.util.DateUtils;
import com.zipi.modules.base.entity.BaseObject;
import com.zipi.modules.contract.entity.CoreUserFund;
import com.zipi.modules.contract.entity.Repayment;
import com.zipi.modules.contract.entity.RmbLoan;
import com.zipi.modules.contract.entity.RmbLoanRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 标的对应还款明细
 * @author guowt
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RmbLoanRepayment extends BaseObject {
	private int totalRows;//总期数

	private static final long serialVersionUID = -6981495798881918625L;

	@NotNull
	private String id;
	@NotNull
	private int currentPeriod;
	
	private BigDecimal repayAmount;

	private Date repayTime;

	private RepaymentStatus repayStatus;

	private Repayment repayment;
	/**
	 * 应还利息
	 * */
	@NotNull
	private BigDecimal amountInterest;
	/**
	 * 应还利息（最后一期）
	 * */
	@NotNull
	private BigDecimal amountPrincipal;
	/**
	 * 剩余本金（未到期未还本金）
	 * */
	@NotNull
	private BigDecimal amountOutStanding;

	@NotNull
	private Date dueDate;

	@NotNull
	private String loanId;

	//发标代偿人id
	private String compensatoryId;

	//实际代偿人id
	private String actCompensatoryId;

	//实际代偿人名称
	private String actCompensatoryName;

	//还款服务费
	private BigDecimal amountService;

	/**
	 * 服务费是否到账
	 * (0初始、1已预处理，2已到账)
	 */
	private String flagServiceCharge;

	/** 下期还款时间 */
	private Date nextRepayTime;

	public RmbLoanRepayment(BigDecimal amountPrincipal,
                            BigDecimal amountInterest,
                            BigDecimal amountOutstanding,
                            LocalDate dueDate) {
		this.amountPrincipal = amountPrincipal;
		this.amountInterest = amountInterest;
		this.amountOutStanding = amountOutstanding;
		this.dueDate = dueDate.toDate();
	}

	public RmbLoanRepayment(String loanerId, String loanId,
                            int currentPeriod,
                            RepaymentStatus repayStatus,
                            BigDecimal repayAmount,
                            Repayment repayment) {
		this.loanerId = loanerId;
		this.loanId = loanId;
		this.currentPeriod = currentPeriod;
		this.repayStatus = repayStatus;
		this.repayAmount = repayAmount;
		this.amountInterest = repayment.getAmountInterest();
		this.amountOutStanding = repayment.getAmountOutstanding();
		this.amountPrincipal = repayment.getAmountPrincipal();
		this.dueDate = repayment.getDueDate();
	}

	private String requestId;

	private String loaner;
	private String loanerId;
	private BigDecimal loanerAvailableAmount;
	private String loanTitle;
	private String loanerMobile;

	private RmbLoanRequest rmbLoanRequest;
	private CoreUserFund userfund;
	private RmbLoan rmbLoan;
	
	public String getRepayStatusKey() {
    	return repayStatus == null ? "" : repayStatus.getKey();
    }

	/**
	 * 逾期天数
	 */
	private int overdueDays;
	public int getOverdueDays() {
		if(null != dueDate && new Date().after(dueDate) && (null == repayTime || RepaymentStatus.PRE_REPAID.equals(repayStatus))){
			try {
				this.overdueDays = DateUtils.betweenDaysCeil(dueDate, new Date());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return overdueDays;
	}

	public void setOverdueDays(int overdueDays) {
		this.overdueDays = overdueDays;
	}

	private boolean lastPeriodFlag;

	private int loanRepay; //到账日T+(0,1,2,3)
    //加息券利息还款标识
	private boolean raiseRepayFlag;

	//后扣服务费
	private BigDecimal loanAmountService;

	//投资角色代偿还款借款角色借款时间
	private Date forwardDate;

	//投资角色代偿还款借款角色借款金额
	private BigDecimal forwardAmount;

	//投资角色代偿还款借款角色借款备注
	private String remarks;

	//还清平台代偿时间
	private Date repayCompensatoryDate;

	//还清平台代偿时金额
	private BigDecimal repayCompensatoryAmount;

	// 银行流水号
	private String transferFlow;

	//是否逾期 true逾期
	private boolean overdue;

	//还款标识（true 提前还款）
	private boolean repayFlag;

	private String borrowUserName;

	private String borrowUserMobile;

	//预约提前还款标识（0,未预约，1 已预约，2可提前还款）
	private int appointmentRepayFlag = 0;
}
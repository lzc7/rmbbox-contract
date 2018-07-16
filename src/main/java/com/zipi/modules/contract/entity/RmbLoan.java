package com.zipi.modules.contract.entity;
/**
 * 具体的标的信息
 */
import com.zipi.modules.contract.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RmbLoan {

    private String loanId;

    private BigDecimal loanAmount;

    private BigDecimal investedAmount;

    private int investedNumber;

    private RmbRepayMethod repayMethod;

    private Boolean mortgaged;

    private int rate;

    private BigDecimal decimalRate;

    private LoanStatus status;

    /**
     * 标的结算时间
     */
    private Date clearedTime;

    /**
     * 标的结束时间
     */
    private Date finishedTime;

    /**
     * 标的开标时间
     */
    private Date openTime;

    /**
     * 募集时长（小时数）
     */
    private int outTimes;

    /**
     * 结标时间
     */
    private Date settledTime;


    private String loanTitle;


    private int days;


    private int months;

    private int years;

    private int loanDays;

    private String requestId;

    private LoanRequestTypes requestType;
    private String requestTypeStr;
    /**
     * 贷款的投标数
     */
    @Min(0)
    private int bidNumber;

    /**
     * 实际投标金额，主要用于流标时记录实际投资额
     */
    @Min(0)
    private int bidAmount;


    private LoanPurpose purpose;//借款目的
    //扩展
    private int totalPeriods;
    private int remainPeriods;//剩余期数
    private int overDuePeriods;//预期期数
    private Date modifyTime;
    private Date submitTime;//申请时间
    private BigDecimal totalTopay;//应还总额
    private BigDecimal sumRepay;
    List<RmbLoanRepayment> rmbLoanRepayment;
    RmbLoanRequest rmbLoanRequest;
    private BigDecimal process;
    

    private String repayMethodTypeKey;

    private BigDecimal frozenAmount;//冻结金额
    /**
     * 产品运营标签
     */
    /**
     * 操作终端类型
     */
    private Source client;
    /**
     * 当状态为开放投标时，根据timeOpen和timeOut计算剩余时间.
     *
     * 其他状态统一返回 -1
     *
     * @return 以millionsecond计算的剩余时间
     */
    public long getLongTimeLeft() {
        if (this.status == LoanStatus.OPENED) {
            long result =this.openTime.getTime() + this.outTimes * DateUtils.MILLIS_PER_HOUR - System.currentTimeMillis();
            if (result<0)
                return -2;
            return  result;
        }
        return -1;
    }

    /**
     * 预告标剩余时间
     * @return 以millionsecond计算的剩余时间
     */
    public long getScheduleTimeLeft(){
        if(this.status == LoanStatus.SCHEDULED){
            long result = this.openTime.getTime() - System.currentTimeMillis();
            if (result<0)
                return -2;
            
            return result;
        }
        return -1;
    }
    
    /**
     * add by fenghuabing for recommend loan
     * @return
     */

	public String getLeftTime() {
		long leftMils = getLongTimeLeft();
		if (leftMils == -1 || leftMils == -2) {
			return "0";
		} else {
			StringBuffer stringBuffer = new StringBuffer();
			int d = ( int) (leftMils / (1000 * 60 * 60 * 24));
			int h = (int) (leftMils / (1000 * 60 * 60) % 24);
			int m = (int) (leftMils / (1000 * 60) % 60);
			if (d > 0)
				stringBuffer.append(d + "天");
			if (h > 0)
				stringBuffer.append(h + "小时");
			if (m > 0)
				stringBuffer.append(m + "分钟");
			return stringBuffer.toString();
		}
	}

    public  String getPercent() {
        if (getRatio() == 100.0) {
            return "100";
        }
        return String.valueOf(getRatio());
    }

    private double getRatio(){

    	BigDecimal ratio = new BigDecimal(String.valueOf(investedAmount.doubleValue()/loanAmount.doubleValue()*100));
//		return ratio.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        if (ratio.doubleValue()> 0.9d){
            return ratio.setScale(1, BigDecimal.ROUND_FLOOR).doubleValue();
        }
        else if (ratio.doubleValue()< 0.1d){
            return ratio.setScale(1, BigDecimal.ROUND_CEILING).doubleValue();
        }
        else{
            return ratio.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
    }

    //扩展字段
    /**
     *年龄
     */
    private int age;
    /** 匹配时间*/
    private Date investTime;
    /** 匹配金额*/
    private BigDecimal investAmount;
    /** 首尾出借标签 */
    private String labelValue;
    /** 道具加息金额 */
    private BigDecimal interestAmount;

    private RmbLoanRequestFee fee;

}
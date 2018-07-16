package com.zipi.modules.contract.entity;

import com.zipi.modules.base.entity.BaseObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class CoreUserFund extends BaseObject {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1543832536368362225L;

	/**
     * 用户主键id
     */
    private String userId;

    /**
     * 可用金额
     */
    private BigDecimal availableAmount = BigDecimal.ZERO;

    /**
     * 充值金额
     */
    private BigDecimal depositAmount = BigDecimal.ZERO;

    /**
     * 待收金额
     */
    private BigDecimal dueInAmount = BigDecimal.ZERO;

    /**
     * 待还金额
     */
    private BigDecimal dueOutAmount = BigDecimal.ZERO;

    /**
     * 冻结金额
     */
    private BigDecimal frozenAmount = BigDecimal.ZERO;
    
    /**
     * 平台向用户转账金额（红包、直接转账使用）
     */
    private BigDecimal transferredAmount = BigDecimal.ZERO;

    /**
     * 记录创建时间
     */
    private Date createTime;

    /**
     * 记录修改时间
     */
    private Date modifyTime;

    /**
     * 提现金额
     */
    private BigDecimal withdrawAmount = BigDecimal.ZERO;

    /**
     * 邦帮堂待收金额
     */
    private BigDecimal rmbDueInAmount = BigDecimal.ZERO;

    /**
     * 邦帮堂待还金额
     */
    private BigDecimal rmbDueOutAmount = BigDecimal.ZERO;

    /**
     * 邦帮堂冻结金额
     */
    private BigDecimal rmbFrozenAmount = BigDecimal.ZERO;

    /**
     * 优选计划待收金额
     */
    private BigDecimal uplanDueInAmount = BigDecimal.ZERO;

    /**
     * 优选计划待还金额
     */
    private BigDecimal uplanDueOutAmount = BigDecimal.ZERO;

    /**
     * 优选冻结金额
     */
    private BigDecimal uplanFrozenAmount = BigDecimal.ZERO;
    
    /** 活期待出账 */
    private BigDecimal currentDueOutAmount = BigDecimal.ZERO;

    /** 活期冻结金额 */
    private BigDecimal currentFrozenAmount = BigDecimal.ZERO;

    /** 月息通待入账 */
    private BigDecimal monthDueInAmount = BigDecimal.ZERO;

    /** 月息通待出账 */
    private BigDecimal monthDueOutAmount = BigDecimal.ZERO;

    /** 月息通冻结金额 */
    private BigDecimal monthFrozenAmount = BigDecimal.ZERO;

    /** 鑫茂通待入账 */
    private BigDecimal yearDueInAmount = BigDecimal.ZERO;

    /** 鑫茂通待出账 */
    private BigDecimal yearDueOutAmount = BigDecimal.ZERO;

    /** 鑫茂通冻结金额 */
    private BigDecimal yearFrozenAmount = BigDecimal.ZERO;

    /** 定期宝待入账 */
    private BigDecimal depositDueInAmount = BigDecimal.ZERO;

    /** 定期宝待出账 */
    private BigDecimal depositDueOutAmount = BigDecimal.ZERO;

    /** 定期宝冻结金额 */
    private BigDecimal depositFrozenAmount = BigDecimal.ZERO;


    private String loginName;
    private String userName;

    /** 激活状态 */
    private Boolean activate;

    /**
     *
     * @param userId
     * @param createTime
     * @param availableAmount
     * @param depositAmount
     * @param dueInAmount
     * @param dueOutAmount
     * @param frozenAmount
     */
    public CoreUserFund(String userId, Date createTime, BigDecimal availableAmount, BigDecimal depositAmount, BigDecimal dueInAmount, BigDecimal dueOutAmount, BigDecimal frozenAmount) {
        this.userId = userId;
        this.createTime = createTime;
        this.availableAmount = availableAmount;
        this.depositAmount = depositAmount;
        this.dueInAmount = dueInAmount;
        this.dueOutAmount = dueOutAmount;
        this.frozenAmount = frozenAmount;

    }

    public CoreUserFund(String userId) {
        this.userId = userId;
    }

}
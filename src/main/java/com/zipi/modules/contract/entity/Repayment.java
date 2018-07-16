package com.zipi.modules.contract.entity;

import com.zipi.modules.base.entity.BaseObject;
import org.joda.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by apple on 15/7/7.
 */
public class Repayment extends BaseObject {

    private static final long serialVersionUID = 20130918L;

    @NotNull
    @XmlElement(name = "amountPrincipal")
    private BigDecimal amountPrincipal = BigDecimal.ZERO;

    @NotNull
    @XmlElement(name = "amountInterest")
    private BigDecimal amountInterest = BigDecimal.ZERO;

    @NotNull
    @XmlElement(name = "amountOutstanding")
    private BigDecimal amountOutstanding = BigDecimal.ZERO;

    @NotNull
    @XmlElement(name = "dueDate")
    private Date dueDate;

    private String dueDateStr;

    public Repayment() {
    }

    public Repayment(BigDecimal amountPrincipal,
                     BigDecimal amountInterest,
                     BigDecimal amountOutstanding,
                     LocalDate dueDate) {
        this.amountPrincipal = amountPrincipal;
        this.amountInterest = amountInterest;
        this.amountOutstanding = amountOutstanding;
        this.dueDate = dueDate.toDate();
    }

    public Repayment(BigDecimal amountPrincipal,
                     BigDecimal amountInterest,
                     BigDecimal amountOutstanding,
                     Date dueDate) {
        this.amountPrincipal = amountPrincipal;
        this.amountInterest = amountInterest;
        this.amountOutstanding = amountOutstanding;
        this.dueDate = dueDate;
    }

    public BigDecimal getAmountPrincipal() {
        return amountPrincipal;
    }

    public BigDecimal getAmountInterest() {
        return amountInterest;
    }

    public BigDecimal getAmountOutstanding() {
        return amountOutstanding;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setAmountPrincipal(BigDecimal amountPrincipal) {
        this.amountPrincipal = amountPrincipal;
    }

    public void setAmountInterest(BigDecimal amountInterest) {
        this.amountInterest = amountInterest;
    }

    public void setAmountOutstanding(BigDecimal amountOutstanding) {
        this.amountOutstanding = amountOutstanding;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueDateStr() {
        return dueDateStr;
    }

    public void setDueDateStr(String dueDateStr) {
        this.dueDateStr = dueDateStr;
    }

    /**
     * 当期的应还款总额.
     *
     * amountPrincipal + amountInterest
     *
     * @return
     */
    public BigDecimal getAmount() {
        return amountInterest.add(amountPrincipal);
    }

}

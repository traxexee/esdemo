package com.emt.model.p;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "org_fee")
public class OrgFee {
    @Id
    @Column(name=" id")
    private Integer id;

    @Column(name=" org_id")
    private Integer orgId;

    @Column(name=" bill_date")
    private String billDate;

    @Column(name=" fee")
    private BigDecimal fee;

    @Column(name=" fee_out")
    private BigDecimal feeOut;

    @Column(name=" fee_in")
    private BigDecimal feeIn;

    @Column(name=" basic")
    private BigDecimal basic;

    @Column(name=" income_num")
    private Integer incomeNum;

    @Column(name=" income_money")
    private BigDecimal incomeMoney;

    @Column(name=" pay_out_num")
    private Integer payOutNum;

    @Column(name=" pay_out_money")
    private BigDecimal payOutMoney;

    @Column(name=" operation")
    private BigDecimal operation;

    @Column(name=" operation_out")
    private BigDecimal operationOut;

    @Column(name=" operation_in")
    private BigDecimal operationIn;

    @Column(name=" remark")
    private String remark;

    @Column(name=" state")
    private Integer state;
    @Transient
    @Column(name=" org")
    private Org org;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate == null ? null : billDate.trim();
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getFeeOut() {
        return feeOut;
    }

    public void setFeeOut(BigDecimal feeOut) {
        this.feeOut = feeOut;
    }

    public BigDecimal getFeeIn() {
        return feeIn;
    }

    public void setFeeIn(BigDecimal feeIn) {
        this.feeIn = feeIn;
    }

    public BigDecimal getBasic() {
        return basic;
    }

    public void setBasic(BigDecimal basic) {
        this.basic = basic;
    }

    public Integer getIncomeNum() {
        return incomeNum;
    }

    public void setIncomeNum(Integer incomeNum) {
        this.incomeNum = incomeNum;
    }

    public BigDecimal getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(BigDecimal incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    public Integer getPayOutNum() {
        return payOutNum;
    }

    public void setPayOutNum(Integer payOutNum) {
        this.payOutNum = payOutNum;
    }

    public BigDecimal getPayOutMoney() {
        return payOutMoney;
    }

    public void setPayOutMoney(BigDecimal payOutMoney) {
        this.payOutMoney = payOutMoney;
    }

    public BigDecimal getOperation() {
        return operation;
    }

    public void setOperation(BigDecimal operation) {
        this.operation = operation;
    }

    public BigDecimal getOperationOut() {
        return operationOut;
    }

    public void setOperationOut(BigDecimal operationOut) {
        this.operationOut = operationOut;
    }

    public BigDecimal getOperationIn() {
        return operationIn;
    }

    public void setOperationIn(BigDecimal operationIn) {
        this.operationIn = operationIn;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }
}


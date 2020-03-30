package com.emt.model.p;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "org")
public class Org {
    @Id
    @Column(name = " id")
    private Integer id;
    @Column(name = " name")
    private String name;
    @Column(name = " org_no")
    private String orgNo;
    @Column(name = " mch_id")
    private String mchId;
    @Column(name = " fee")
    private BigDecimal fee;
    @Column(name = " basic")
    private BigDecimal basic;
    @Column(name = " operation")
    private BigDecimal operation;
    @Column(name = " remark")
    private String remark;
    @Column(name = " state")
    private Integer state;
    @Column(name = " warning")
    private Integer warning;
    @Column(name = " last_update_time")
    private Date lastUpdateTime;
    @OneToOne
    @JoinColumn(name="org_cost_org_no")
    private OrgCost orgCost;
    @Column(name = " max_fee")
    private BigDecimal maxFee;
    @Transient
    @Column(name = " suggest")
    private Integer suggest;
    @Column(name = " par_province_id")
    private Integer parProvinceId;

    public Integer getParProvinceId() {
        return parProvinceId;
    }

    public Org setParProvinceId(Integer parProvinceId) {
        this.parProvinceId = parProvinceId;
        return this;
    }

    public OrgCost getOrgCost() {
        return orgCost;
    }

    public void setOrgCost(OrgCost orgCost) {
        this.orgCost = orgCost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo == null ? null : orgNo.trim();
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getBasic() {
        return basic;
    }

    public void setBasic(BigDecimal basic) {
        this.basic = basic;
    }

    public BigDecimal getOperation() {
        return operation;
    }

    public void setOperation(BigDecimal operation) {
        this.operation = operation;
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

    public Integer getWarning() {
        return warning;
    }

    public void setWarning(Integer warning) {
        this.warning = warning;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }


    public BigDecimal getMaxFee() {
        return maxFee;
    }

    public void setMaxFee(BigDecimal maxFee) {
        maxFee = maxFee;

    }

    public Integer getSuggest() {

        BigDecimal sug = maxFee.divide(new BigDecimal(50), 0);
        this.suggest = (sug.intValue() + 1) * 50;
        return suggest;
    }

    public void setSuggest(Integer suggest) {
        this.suggest = suggest;
    }

}
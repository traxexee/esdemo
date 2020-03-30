package com.emt.model.p;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@Component
@Table(name = "org_cost")
public class OrgCost {
    @Id
    @Column(name="org_no")
    @GeneratedValue(generator="system_uuid")
    @GenericGenerator(name="system_uuid",strategy="uuid")
    private String orgNo;
    @Column(name="cost",nullable = false)
    private BigDecimal cost;
    @Column(name="last_update_time",nullable = false)
    private Date lastUpdateTime;
    /**
     * 预计今天手续费话费
     */
    @Transient
    private BigDecimal forecast;

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo == null ? null : orgNo.trim();
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;

    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;

    }

    public BigDecimal getForecast() {
        int hours = lastUpdateTime.getHours();
        if (hours < 9) {
            this.forecast = new BigDecimal("0.00");
        } else if (hours < 14) {
            // 9点5倍 10点 4倍 11点3.3倍 12点 2.5倍 13点 2倍
            this.forecast = this.cost.multiply(new BigDecimal(10)).divide(new BigDecimal(hours - 7),3);
        } else {
            this.forecast = this.cost.multiply(new BigDecimal(24)).divide(new BigDecimal(hours),3);
        }
        return forecast;
    }

    public void setForecast(BigDecimal forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "OrgCost{" +
                "orgNo='" + orgNo + '\'' +
                ", cost=" + cost +
                ", lastUpdateTime=" + lastUpdateTime +
                ", forecast=" + forecast +
                '}';
    }
}
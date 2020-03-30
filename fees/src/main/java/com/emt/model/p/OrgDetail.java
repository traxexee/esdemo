package com.emt.model.p;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "org_detail")
public class OrgDetail {

    @Id
    @Column(name = " id")
    private Integer id;
    @Column(name = " mch_id")
    private String mchId;
    @Column(name = " account_type")
    private String accountType;
    @Column(name = " bill_date")
    private String billDate;
    @Column(name = " charge_time")
    private String chargeTime;
    @Column(name = " wx_bill_no")
    private String wxBillNo;
    @Column(name = " capital_no")
    private String capitalNo;
    @Column(name = " business_name")
    private String businessName;
    @Column(name = " business_type")
    private String businessType;
    @Column(name = " payment_type")
    private String paymentType;
    @Column(name = " payment_amount")
    private String paymentAmount;
    @Column(name = " account_balance")
    private String accountBalance;
    @Column(name = " applicant")
    private String applicant;
    @Column(name = " remark")
    private String remark;
    @Column(name = " voucher_no")
    private String voucherNo;
    @Column(name = " state")
    private Integer state;
    @Column(name = " comment")
    private String comment;


}
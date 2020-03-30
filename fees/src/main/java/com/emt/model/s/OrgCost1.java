package com.emt.model.s;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in15:09 2020/3/16.
 * @Modified By:
 */
@Data
@Entity
@Component
@Table(name="org_cost")
public class OrgCost1 {
    @Id
    @Column(name="sub_mch_id",nullable = false)
    private String subMchId;
    private BigDecimal cost;
   @Column(name="last_update_time",nullable = false)
    private Date lastUpdateTime;
    @Column(name="org_no",nullable = false)
    private String orgNo;

}

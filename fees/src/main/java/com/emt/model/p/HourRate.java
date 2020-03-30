package com.emt.model.p;

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
 * @Date: Created in14:48 2019/4/11.
 * @Modified By:
 */
@Data
@Entity
@Component
@Table(name = "hour_rate")
public class HourRate {
    @Id
    @Column(name=" id")
    private Integer id;

    @Column(name=" mch_id")
    private String mchId;

    @Column(name=" num")
    private Integer num;

    @Column(name=" money")
    private BigDecimal money;

    @Column(name=" start_time")
    private Date startTime;

    @Column(name=" end_time")
    private Date endTime;
}

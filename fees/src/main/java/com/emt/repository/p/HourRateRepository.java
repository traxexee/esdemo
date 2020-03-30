package com.emt.repository.p;

import com.emt.model.p.HourRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in14:50 2019/4/11.
 * @Modified By:
 */
public interface HourRateRepository extends JpaRepository<HourRate, Integer> {
    @Query(value = "select sum(num) num, sum(money) ,start_time from hour_rate where mch_id in (select o.mch_id from org o where o.par_province_id = ?1)  GROUP BY start_time ORDER BY start_time", nativeQuery = true)
    List<Object[]>findAllByProvinceId(Integer id);
    @Query(value = "select sum(num) num from hour_rate where mch_id in (select o.mch_id from org o where o.par_province_id = ?1)  GROUP BY start_time ORDER BY start_time", nativeQuery = true)
    List<Integer> findAllNumByProvinceId(Integer id);
    //获得日期天
    @Query(value = "select left(start_time,10) FROM hour_rate GROUP BY left(start_time,10)", nativeQuery = true)
    List<String> day();
}

package com.emt.repository.p;

import com.emt.model.p.Org;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in13:55 2019/4/9.
 * @Modified By:
 */
public interface OrgRepository extends JpaRepository<Org, Integer> {
    @Query(value = "select id, name, o.org_no, mch_id, fee, basic, operation, remark, state,\n" +
            "\t\twarning,\n" +
            "\t\to.last_update_time ,max_fee,\n" +
            "\t\tc.org_no org_cost_org_no,cost,c.last_update_time\n" +
            "\t\tlast_update_time1\n" +
            "\t\tfrom org o LEFT JOIN org_cost c on o.org_no= c.org_no", nativeQuery = true)
    List<Org> findAll();

    @Query(value = "select id, name, o.org_no, mch_id, fee, basic, operation, remark,par_province_id, state,\n" +
            "\t\twarning,\n" +
            "\t\to.last_update_time ,max_fee,\n" +
            "\t\tc.org_no org_cost_org_no,cost,c.last_update_time\n" +
            "\t\tlast_update_time1\n" +
            "\t\tfrom org o LEFT JOIN org_cost c on o.org_no= c.org_no where id =?1", nativeQuery = true)
    Optional<Org> findById(Integer aId);


    //TODO 查找最小的时间
    @Query(value = "select min(last_update_time) from org", nativeQuery = true)
    Date searchMinTime();

    @Query(value = "select id, name, o.org_no, mch_id, fee, basic,operation, remark,par_province_id, state,\n" +
            "\t\twarning,\n" +
            "\t\to.last_update_time ,max_fee,\n" +
            "\t\tc.org_no org_cost_org_no,cost,c.last_update_time\n" +
            "\t\tlast_update_time1\n" +
            "\t\tfrom org o LEFT JOIN org_cost c on o.org_no= c.org_no where par_province_id =?1", nativeQuery = true)
    List<Org> findAllByParProvinceId(Integer provinceId);
    @Query(value = "select id, name, o.org_no, mch_id, fee, basic,operation, remark,par_province_id, state,\n" +
            "\t\twarning,\n" +
            "\t\to.last_update_time ,max_fee,\n" +
            "\t\tc.org_no org_cost_org_no,cost,c.last_update_time\n" +
            "\t\tlast_update_time1\n" +
            "\t\tfrom org o LEFT JOIN org_cost c on o.org_no= c.org_no where id =?1", nativeQuery = true)
    Org findOneById(Integer id);
}

package com.emt.repository.p;

import com.emt.model.p.OrgCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in13:56 2019/4/9.
 * @Modified By:
 */
@Component
public interface OrgCostRepository extends JpaRepository<OrgCost, String> {
    //TODO 更新当天的手续费数据
    @Query(value ="replace INTO org_cost (org_no, cost)\n" +
            "\t\t(\n" +
            "\t\tselect left(LH_CHANNEL,7) org_no,sum(LH_MONEY)/50000 money from M_LOGHANDLE\n" +
            "\t\twhere LH_PROJECT=\"wxnotify\" GROUP BY org_no HAVING money >0\n" +
            "\t\t)", nativeQuery = true)
    void replaceAllByNow();

}

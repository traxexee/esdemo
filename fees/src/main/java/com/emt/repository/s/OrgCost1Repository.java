package com.emt.repository.s;


import com.emt.model.s.OrgCost1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in15:11 2020/3/16.
 * @Modified By:
 */
@Component
public interface OrgCost1Repository extends JpaRepository<OrgCost1, String> {
    //查询黑龙江全省交易金额 分
    @Query(value = "select sum(total_fee) FROM wxopen.order_list WHERE time_end LIKE ?1", nativeQuery = true)
    String sumAllFeeByBillDate(String billDate);
    //查询黑龙江全省交易笔数
    @Query(value = "select count(0) FROM wxopen.order_list WHERE time_end LIKE ?1", nativeQuery = true)
    Integer countAllFeeByBillDate(String billDate);
    //查询黑龙江某地市交易金额 分
    @Query(value = "select sum(total_fee) FROM wxopen.order_list WHERE time_end LIKE ?1 and sub_mch_id =?2", nativeQuery = true)
    String sumAllFeeByBillDateAndSubMchId(String billDate,String subMchId);
    //查询黑龙江某地市交易笔数
    @Query(value = "select count(0)FROM wxopen.order_list WHERE time_end LIKE ?1 and sub_mch_id =?2", nativeQuery = true)
    Integer countAllFeeByBillDateAndSubMchId(String billDate,String subMchId);
}

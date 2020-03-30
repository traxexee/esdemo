package com.emt.repository.p;

import com.emt.model.p.OrgFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in13:58 2019/4/9.
 * @Modified By:
 */
public interface OrgFeeRepository extends JpaRepository<OrgFee, Integer> {

    Optional<OrgFee> findById(Integer aId);


    List<OrgFee> findAllByOrgIdOrderByBillDate(Integer id);


    @Query(value = "select bill_date ,fee_out from org_fee where org_id =?1 ORDER BY bill_date", nativeQuery = true)
    List<Object[]>findBillDateAndFeeOutByOrgId(Integer id);
/*    List<OrgFee> findAllByState(Integer id);*/

    //查询异常状态的orgfee

 /*   @Query(value = "select f.id ,f.org_id,f.bill_date,f.fee,fee_out,f.basic,f.fee_in,f.operation, f.operation_in,f.operation_out,income_num,income_money,pay_out_num,pay_out_money,  f.remark,  f.state ,\n" +
            "    o.id org1_id, o.name org_name, o.org_no org_org_no, o.mch_id org_mch_id,o.remark org_remark," +
            "    o.state org_state from org_fee f LEFT JOIN org o on o.id = f.org_id where f.state =?1 or f.state=?2", nativeQuery = true)
    List<OrgFee> findAllByStateOrState(Integer basicState, Integer state);*/
   /* @Query(value = "select *  from OrgFee  where o.state=?1 or o.state =?2")*/
    List<OrgFee> findAllByStateOrState(Integer basicState, Integer state);


    OrgFee saveAndFlush(OrgFee orgFee);

    @Query(value = "select MIN(fee_out) from org_fee where org_id =?1", nativeQuery = true)
    BigDecimal findMinFeeOutByOrgId(Integer id);
    @Query(value = "select MAX(fee_out) from org_fee where org_id =?1", nativeQuery = true)
    BigDecimal findMaxFeeOutByOrgId(Integer id);
    @Query(value = "select AVG(fee_out) from org_fee where org_id =?1", nativeQuery = true)
    BigDecimal findAvgFeeOutByOrgId(Integer id);
}

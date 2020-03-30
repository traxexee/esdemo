package com.emt.repository.p;

import com.emt.model.p.OrgDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in13:56 2019/4/9.
 * @Modified By:
 */
public interface OrgDetailRepository extends JpaRepository<OrgDetail, Integer> {
    List<OrgDetail> findAllByMchId(String mchId);

    /*    List<OrgDetail> findAllByMchIdAndBillDate(String mchId, String billDate);*/
    @Query(value = "select wx_bill_no from org_detail where mch_id = ?1 and bill_date = ?2 and applicant = 'system'and remark = 'system' LIMIT 1", nativeQuery = true)
    String searchWxBillNoByMchIdAndBillDate(String mchId, String billDate);

    List<OrgDetail> findAllByWxBillNo(String wxBillNo);

    List<OrgDetail> findAllByPaymentAmountAndMchIdAndWxBillNo(String paymentAmount, String mchId, String wxBillNo);

    List<OrgDetail> findAllByAccountType(String accountType);

    /*
        List<OrgDetail> findAllByFeeParam(FeeParam feeparam);

        Integer countByFeeParam(FeeParam feeParam);*/
    Page<OrgDetail> findByAccountType(String pay, Pageable pageable);


}

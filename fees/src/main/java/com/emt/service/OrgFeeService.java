package com.emt.service;

import com.emt.model.p.OrgFee;
import com.emt.vo.DataList;
import com.emt.vo.OrgFeeList;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author 刘震
 * @date 2018年12月6日 下午12:56:47
 */
public interface OrgFeeService {
    List<OrgFee> searchByOrgId(Integer orgId);

    OrgFee updateRemarkById(Integer id, String remark);

/*	List<OrgFee> searchByState(Integer state);*/

    OrgFee updateStateById(Integer id, Integer state);

    List<OrgFee> searchErrorState();

    OrgFeeList findByOrgId(Integer id);


    BigDecimal findMinFeeOutByOrgId(Integer id);

    BigDecimal findMaxFeeOutByOrgId(Integer id);

    BigDecimal findAvgFeeOutByOrgId(Integer id);

    DataList findDataByPrivinceId(Integer id);


}

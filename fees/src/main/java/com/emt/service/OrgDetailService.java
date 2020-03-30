package com.emt.service;

import com.emt.model.p.OrgDetail;
import com.emt.param.FeeParam;

import java.util.List;


/**
 * @author 刘震
 * @date 2018年12月26日 下午12:59:45
 */
public interface OrgDetailService {

	List<OrgDetail> findAllByMchId(String mchId);

/*	List<OrgDetail> findAllByMchIdAndBillDate(String mchid, String billDate);*/

	List<OrgDetail> findOneByMchIdAndBillDate(String mchid, String billDate);

	List<OrgDetail> findAllByAccountType(String accountType);

	List<OrgDetail> findAllByFeeParam(FeeParam feeParam);
	
	Integer countByFeeParam(FeeParam feeParam);
}

package com.emt.service;

import com.emt.vo.LongJiangMsg;

/**
 * @author  刘震
 * @date 2018年12月6日 下午12:58:00 
 */
public interface OrgCostService {
	void refreshOrgCost();

	LongJiangMsg  totalByBillDate(String billDate);



}

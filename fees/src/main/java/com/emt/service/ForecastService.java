package com.emt.service;

import com.emt.vo.OrgFeeList;

/**
 * @Author:刘震
 * @Description: 预测接下来要使用的手续费
 * @Date: Created in13:53 2019/4/14.
 * @Modified By:
 */
public interface ForecastService {
    //TODO 预测接下来七天的手续费使用情况
    OrgFeeList intraweek(OrgFeeList orgFeeList);

}

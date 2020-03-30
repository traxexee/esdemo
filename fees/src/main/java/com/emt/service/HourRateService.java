package com.emt.service;

import com.emt.vo.DataList;
import com.emt.vo.DayList;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in15:23 2019/4/11.
 * @Modified By:
 */
public interface HourRateService {
   DataList getProvinceById(Integer id);

   DataList getDayById(Integer id);
}

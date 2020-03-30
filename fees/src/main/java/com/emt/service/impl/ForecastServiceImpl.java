package com.emt.service.impl;

import com.emt.service.ForecastService;
import com.emt.vo.OrgFeeList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in13:58 2019/4/14.
 * @Modified By:
 */
@Service
@Slf4j
public class ForecastServiceImpl implements ForecastService{
    @Override
    public OrgFeeList intraweek(OrgFeeList orgFeeList) {
        //获得最近7天的笔数
        //获得

        //添加事件
        //月度账单 * 3
        //每周推文 * 1.5
        //平均
        //每天的笔数 =2* 历史每天平均值-当前月平均值
        return null;
    }
}

package com.emt.service.impl;

import com.emt.repository.p.HourRateRepository;
import com.emt.service.HourRateService;
import com.emt.utils.MyDateUtil;
import com.emt.vo.DataList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in15:30 2019/4/11.
 * @Modified By:
 */
@Slf4j
@Service
public class HourRateServiceImpl implements HourRateService {
    @Autowired
    private HourRateRepository hourRateRepository;

    @Override
    public DataList getProvinceById(Integer id) {
        DataList dataList = new DataList();
        List<Object[]> all = hourRateRepository.findAllByProvinceId(id);
        List<BigDecimal> moneys = new ArrayList<>();
        List<BigDecimal> nums = new ArrayList<>();
        List<Date> times = new ArrayList<>();
        Date tmpTime = new Date();
        if (all != null) {
            nums.add((BigDecimal) all.get(0)[0]);
            moneys.add((BigDecimal) all.get(0)[1]);
            times.add((Date) all.get(0)[2]);
            tmpTime = (Date) all.get(0)[2];
        }
        for (int i = 1; i < all.size(); i++) {
            // 判断时间
            tmpTime = MyDateUtil.addHour(tmpTime);
            while (tmpTime.compareTo((Date) all.get(i)[2]) < 0) {
                nums.add(new BigDecimal(0));
                moneys.add(new BigDecimal(0));
                times.add(tmpTime);

                tmpTime = MyDateUtil.addHour(tmpTime);
            }
            nums.add((BigDecimal) all.get(i)[0]);
            moneys.add((BigDecimal) all.get(i)[1]);
            times.add(tmpTime);
        }

        dataList.setMoneys(moneys);
        dataList.setNums(nums);
        dataList.setTimes(times);

        return dataList;
    }

    @Override
    public DataList getDayById(Integer id) {
        DataList dataList  = getProvinceById(id);
        dataList.setStrings(hourRateRepository.day());
        return dataList;
    }
}

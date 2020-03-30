package com.emt.service.impl;

import com.emt.service.HourRateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in15:55 2019/4/11.
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HourRateServiceImplTest {
    @Autowired
    private HourRateService hourRateService;
    @Test
    public void getProvinceById() throws Exception {
        hourRateService.getProvinceById(1);
    }

}
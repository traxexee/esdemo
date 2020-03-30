package com.emt.repository;

import com.emt.repository.p.HourRateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in15:02 2019/4/11.
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HourRateRepositoryTest {
    @Autowired
    HourRateRepository hourRateRepository;
    @Test
    public void findAllByProvinceId() throws Exception {
        List<Object[]> sd=hourRateRepository.findAllByProvinceId(1);
        for (int i = 0; i <sd.size(); i++) {
            System.out.println(sd.get(i).toString());
        }
    }
    @Test
    public void find(){
        List<Integer>   s= hourRateRepository.findAllNumByProvinceId(1);
        System.out.println(s);

        List<Integer>   s2= hourRateRepository.findAllNumByProvinceId(2);
        System.out.println(s2);
    }


}
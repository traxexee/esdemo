package com.emt.repository;

import com.emt.constant.StateConstant;
import com.emt.model.p.OrgFee;
import com.emt.repository.p.OrgFeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in21:10 2019/4/14.
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrgFeeRepositoryTest {
    @Autowired
    private OrgFeeRepository orgFeeRepository;
    @Test
    public void findAllByStateOrState() throws Exception {
        List<OrgFee> o= orgFeeRepository.findAllByStateOrState(StateConstant.basicState, StateConstant.dealState);


    }

}
package com.emt.service.impl;

import com.emt.service.OrgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in14:42 2019/4/14.
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrgServiceImplTest {
    @Autowired
    private OrgService orgService;
    @Test
    public void getMaxCreatetime() throws Exception {
    }

    @Test
    public void getAllOrg() throws Exception {
    }

    @Test
    public void findOneById() throws Exception {
        orgService.findOneById(19);
    }

    @Test
    public void searchMinTime() throws Exception {
    }

    @Test
    public void refresh() throws Exception {
    }

}
package com.emt.repository;

import com.emt.model.s.OrgCost1;
import com.emt.repository.s.OrgCost1Repository;
import com.emt.service.impl.LjOrgCostServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in10:53 2019/4/14.
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrgRepositoryTest {
@Autowired
private OrgCost1Repository orgCostRepository;

@Autowired
private LjOrgCostServiceImpl ljOrgCostService;

@Autowired
private com.emt.repository.p.OrgCostRepository orgCostRepository1;
    @Test
    public void findAll() throws Exception {
        List<com.emt.model.p.OrgCost> list= orgCostRepository1.findAll();
        list.forEach(orgCost -> {
            System.out.println(orgCost.getOrgNo());
        });
    }
    
    @Test
    public void findAllAndOrgCost() throws Exception {
        ljOrgCostService.refreshOrgCost();
    }

    @Test
    public void searchMinTime() throws Exception {
      List<OrgCost1> list= orgCostRepository.findAll();
      list.forEach(orgCost -> {
          System.out.println(orgCost.getSubMchId());
      });
    }

}
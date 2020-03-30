package com.emt.service.impl;

import com.emt.repository.p.OrgCostRepository;
import com.emt.service.OrgCostService;
import com.emt.vo.LongJiangMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author 刘震
 * @date 2018年12月6日 下午12:58:33
 */
@Service
@Slf4j
public class OrgCostServiceImpl implements OrgCostService {
    @Autowired
    OrgCostRepository orgCostRepository;

    @Override
    public void refreshOrgCost() {
        // TODO Auto-generated method stub
        orgCostRepository.replaceAllByNow();
        //orgCostMapper.replaceAllByNow();
    }

    @Override
    public LongJiangMsg totalByBillDate(String billDate) {
        return null;
    }

   /* @Override
    public void updateByOrgId() {

    }*/

}

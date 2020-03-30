package com.emt.service.impl;

import com.emt.constant.SmsConstant;
import com.emt.model.p.OrgCost;
import com.emt.model.s.OrgCost1;
import com.emt.repository.p.OrgCostRepository;
import com.emt.repository.s.OrgCost1Repository;
import com.emt.service.OrgCostService;
import com.emt.service.SendMsgService;
import com.emt.vo.LongJiangMsg;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.loader.plan.build.internal.LoadGraphLoadPlanBuildingStrategy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in10:31 2020/3/17.
 * @Modified By:
 */
@Service
@Slf4j
public class LjOrgCostServiceImpl implements OrgCostService {
    @Autowired
    private OrgCost1Repository orgCost1Repository;
    @Autowired
    private OrgCostRepository orgCostRepository;



    @Override
    public void refreshOrgCost() {
        List<OrgCost1> list = orgCost1Repository.findAll();

        List<OrgCost> orgCosts = new ArrayList<>();
        list.forEach(orgCost1 -> {
            OrgCost orgCost = new OrgCost();
            BeanUtils.copyProperties(orgCost1 ,orgCost);
            orgCosts.add(orgCost);
        });

        log.info(orgCosts.toString());
       orgCostRepository.saveAll(orgCosts);

    }

    @Override
    public LongJiangMsg totalByBillDate(String billDate) {

        LongJiangMsg longJiangMsg = new LongJiangMsg();
//总的
        String sumFee=orgCost1Repository.sumAllFeeByBillDate(billDate);
        Integer countNum=orgCost1Repository.countAllFeeByBillDate(billDate);
      //国网
        String sumFeeG=orgCost1Repository.sumAllFeeByBillDateAndSubMchId(billDate,SmsConstant.LONG_JIANG_GUO_WANG_SUB_MCH_ID);
        Integer countNumG=orgCost1Repository.countAllFeeByBillDateAndSubMchId(billDate,SmsConstant.LONG_JIANG_GUO_WANG_SUB_MCH_ID);
        longJiangMsg.setAllFee(new BigDecimal(sumFee).divide(new BigDecimal("100")).toString());
        longJiangMsg.setAllNum(countNum);
        longJiangMsg.setGuoNum(countNumG);
        longJiangMsg.setNongNum(countNum-countNumG);
        longJiangMsg.setGuoFee(new BigDecimal(sumFeeG).divide(new BigDecimal("100")).toString());
        longJiangMsg.setNongFee(new BigDecimal(sumFee).subtract(new BigDecimal(sumFeeG)).divide(new BigDecimal("100")).toString());



        return longJiangMsg;
    }
}

package com.emt.controller;

import com.emt.model.p.Org;
import com.emt.service.OrgFeeService;
import com.emt.service.OrgService;
import com.emt.vo.OrgFeeList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

/**
 * @Author:刘震
 * @Description: 预估当天手续费使用的金额
 * @Date: Created in9:50 2019/4/10.
 * @Modified By:
 */
@RestController
@Slf4j
@RequestMapping("/forecast")
public class ForecastController {
    @Autowired
    private OrgService orgService;
    @Autowired
    private OrgFeeService orgFeeService;
    //1.获得当前日期，月份，星期几
    //2.根据客单来预测高峰月
    //3.根据当前缴费笔数来预测当天交费笔数
    //4.加入事件来调整整体预测（笔数百分比，金额百分比）
    //对整月的手续费进行预测
    public  void month(){
        //获得近30天客单，预计本月客单


        //预计月交易笔数
        //预计月交易总金额
    }


    @GetMapping("/orgFee/{orgId}")
    public ModelAndView page(ModelAndView modelAndView, @PathVariable("orgId") Integer orgId) {

        modelAndView.setViewName("/page/org/forecast");
        //TODO该机构的历史交易情况
        Org org = orgService.findOneById(orgId);
        OrgFeeList orgFeeList = orgFeeService.findByOrgId(orgId);
        BigDecimal avg = orgFeeService.findAvgFeeOutByOrgId(orgId);
        BigDecimal min = orgFeeService.findMinFeeOutByOrgId(orgId);
        BigDecimal max = orgFeeService.findMaxFeeOutByOrgId(orgId);

        modelAndView.addObject("orgFeeList", orgFeeList);
        modelAndView.addObject("org", org);
        modelAndView.addObject("avg", avg);
        modelAndView.addObject("min", min);
        modelAndView.addObject("max", max);
        return modelAndView;
    }

}

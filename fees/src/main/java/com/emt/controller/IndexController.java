package com.emt.controller;

import com.emt.model.p.Org;
import com.emt.service.HourRateService;
import com.emt.service.MchProvinceService;
import com.emt.service.OrgService;
import com.emt.vo.DataList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in15:03 2019/4/10.
 * @Modified By:
 */
@Slf4j
@RestController
public class IndexController {
    @Autowired
    private HourRateService hourRateService;
    @Autowired
    private MchProvinceService mchProvinceService;
    @Autowired
    private OrgService orgService;

    @GetMapping("/index")
    public ModelAndView page1(ModelAndView modelAndView) {
        log.info("2");
        modelAndView.setViewName("/page/index");
        modelAndView.addObject("provinces", mchProvinceService.findAll());
        return modelAndView;
    }

    /*    @GetMapping
        public ModelAndView page(ModelAndView modelAndView) {
            log.info("1");
            modelAndView.setViewName("/page/index");
            return modelAndView;
        }*/
    @GetMapping("/main1")
    public ModelAndView main(ModelAndView modelAndView) {
        //TODO 获得省份列表
        //TODO 获得所有省的手续费余额
        //TODO datatable表格展示
        DataList dataList = hourRateService.getProvinceById(1);
        modelAndView.addObject("data", dataList);
        modelAndView.setViewName("/page/main");
        return modelAndView;
    }
    @GetMapping("/main")
    public ModelAndView main1(ModelAndView modelAndView) {
        log.info("获得省份列表");
        List<Org> provinceOrgs= orgService.getProvinceOrg(); //获得省份的手续费剩余情况
        log.info("provinceOrgs {}",provinceOrgs);
        log.info(provinceOrgs.get(0).getOrgCost().toString());
/*      DataList dataList = hourRateService.getProvinceById(1);*/
        modelAndView.addObject("data", provinceOrgs);
        modelAndView.setViewName("/page/main");
        return modelAndView;
    }
}

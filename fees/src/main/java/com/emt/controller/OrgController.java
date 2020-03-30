package com.emt.controller;

import com.emt.model.p.Org;
import com.emt.service.OrgCostService;
import com.emt.service.OrgService;
import com.emt.service.impl.OrgCostServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in13:25 2019/4/9.
 * @Modified By:
 */
@RequestMapping("/org")
@RestController
@Slf4j
public class OrgController {

    @Autowired
    OrgService orgService;
    @Autowired
    OrgCostServiceImpl orgcostService;

  /*  @GetMapping("/refresh")
    public Result<?> reflash() {

        // 刷新手续费使用情况
        HttpRequest.sendGet(UrlConfig.url.replace("billDate", MyDateUtil.getBeforeDate()));
        return ResultUtil.sucess();

    }
*/
   /* @GetMapping
    public ModelAndView page1(ModelAndView modelAndView) {
        // 刷新手续费使用情况
       // orgcostService.refreshOrgCost();
        Date date = orgService.searchMinTime();
        modelAndView.setViewName("/page/org/orgList");
        List<Org> orgs = orgService.getAllOrg();
        modelAndView.addObject("orgs", orgs);
        modelAndView.addObject("time", date);
log.info("sd");
        return modelAndView;
    }*/
    @GetMapping
    public ModelAndView orgList(ModelAndView modelAndView) {
        log.info("获得省份列表");
        List<Org> provinceOrgs= orgService.getProvinceOrg(); //获得省份的手续费剩余情况
        log.info("provinceOrgs {}",provinceOrgs);
        log.info(provinceOrgs.get(0).getOrgCost().toString());
/*      DataList dataList = hourRateService.getProvinceById(1);*/
        modelAndView.addObject("data", provinceOrgs);
        modelAndView.setViewName("/page/org/orgList");
        return modelAndView;
    }


    @GetMapping("/province/{id}")
    public ModelAndView main1(ModelAndView modelAndView,@PathVariable("id") Integer id) {
        log.info("获得{}省的县市列表",id);
        List<Org> provinceOrgs= orgService.getOrgByProvinceId(id); //获得省份的手续费剩余情况
        log.info("provinceOrgs {}",provinceOrgs);
        log.info(provinceOrgs.get(0).getOrgCost().toString());
/*      DataList dataList = hourRateService.getProvinceById(1);*/
        modelAndView.addObject("data", provinceOrgs);
        modelAndView.setViewName("/page/org/orgList");
        return modelAndView;
    }


}

package com.emt.controller;

import com.emt.service.HourRateService;
import com.emt.service.OrgFeeService;
import com.emt.vo.DataList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in13:37 2019/4/12.
 * @Modified By:
 */
@Slf4j
@RestController
@RequestMapping("/province")
public class MchProvinceMapperController {
    @Autowired
    private HourRateService hourRateService;
    @Autowired
    private OrgFeeService orgFeeService;

    @GetMapping("/hour/{id}")
    public ModelAndView hour(@PathVariable("id") Integer id, ModelAndView modelAndView) {
        DataList dataList = hourRateService.getProvinceById(id);
        modelAndView.addObject("data", dataList);
        modelAndView.setViewName("/page/province/hour");
        return modelAndView;
    }

    //TODO 获得以天为单位的手续费数据
    @GetMapping("/day/{id}")
    public ModelAndView day(@PathVariable("id") Integer id, ModelAndView modelAndView) {


        DataList dataList = orgFeeService.findDataByPrivinceId(id);
        modelAndView.addObject("data", dataList);
        modelAndView.setViewName("/page/province/newDay");
        return modelAndView;
    }

    //TODO 获得按天分组的数据
    @GetMapping("/day/hour/{id}")
    public ModelAndView dayHour(@PathVariable("id") Integer id, ModelAndView modelAndView) {
        DataList dataList = hourRateService.getDayById(id);
        modelAndView.addObject("data", dataList);
        modelAndView.setViewName("/page/province/day");
        return modelAndView;
    }

    //TODO 获取所有省份当天余额
    public ModelAndView funds(ModelAndView modelAndView) {
        //获得余额

        modelAndView.addObject("data", "d");
        modelAndView.setViewName("/page/province/funds");
        return modelAndView;
    }

}

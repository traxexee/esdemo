package com.emt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.emt.constant.StateConstant;
import com.emt.model.p.Org;
import com.emt.model.p.OrgFee;
import com.emt.model.Result;
import com.emt.service.OrgFeeService;
import com.emt.service.OrgService;
import com.emt.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import lombok.extern.slf4j.Slf4j;

/**
 * @author 刘震
 * @date 2018年12月6日 下午3:45:37
 */
@Slf4j
@RequestMapping("/orgFee")
@RestController
public class OrgFeeController {

    @Autowired
    OrgService orgService;
    @Autowired
    OrgFeeService orgFeeService;

    @GetMapping("{orgId}")
    public ModelAndView page(ModelAndView modelAndView, @PathVariable("orgId") Integer orgId) {

        modelAndView.setViewName("/page/org/orgFeeList");
        Org org = orgService.findOneById(orgId);
        List<OrgFee> orgFees = orgFeeService.searchByOrgId(orgId);
        modelAndView.addObject("orgFees", orgFees);
        modelAndView.addObject("org", org);
        return modelAndView;
    }

    @GetMapping("/basic")
    public ModelAndView operation(ModelAndView modelAndView) {
        //List<OrgFee> orgFees = orgFeeService.searchByState(StateConstant.basicState);
        List<OrgFee> orgFees = orgFeeService.searchErrorState();
        modelAndView.addObject("orgFees", orgFees);
        modelAndView.setViewName("/page/org/orgBasicList");
        return modelAndView;
    }

    @PutMapping("/id/{id}/remark/{remark}")
    public Result<?> updateRemark(@PathVariable("id") Integer id, @PathVariable("remark") String remark,
                                  HttpServletRequest request) {
        orgFeeService.updateRemarkById(id, remark);
        return ResultUtil.sucess();

    }

    @PutMapping("/id/{id}/state")
    public Result<?> updateDealState(@PathVariable("id") Integer id, HttpServletRequest request) {
        orgFeeService.updateStateById(id, StateConstant.dealState);
        return ResultUtil.sucess();

    }

    @PutMapping("/id/{id}/successState")
    public Result<?> updateState(@PathVariable("id") Integer id, HttpServletRequest request) {
        orgFeeService.updateStateById(id, StateConstant.successState);
        return ResultUtil.sucess();

    }

    //TODO 获得某省过去24小时手续费走势图
    @PutMapping("/province/{id}/24")
    public Result<?> province(@PathVariable("id") Integer id) {
        return ResultUtil.sucess();
    }
    //TODO 获得某省过去所有小时手续费走势图
    @PutMapping("/province/{id}/all")
    public Result<?> provinceAll(@PathVariable("id") Integer id) {
        return ResultUtil.sucess();
    }

    //获得某市过去24小时手续费走势图
    //TODO
    @PutMapping("/city/{id}")
    public Result<?> city(@PathVariable("id") Integer id) {
        return ResultUtil.sucess();
    }

    @GetMapping("history/{orgId}")
    public ModelAndView history(ModelAndView modelAndView, @PathVariable("orgId") Integer orgId) {
  orgId  =88;
        modelAndView.setViewName("/page/org/orgFeeList");

        Org org = orgService.findOneById(orgId);
        List<OrgFee> orgFees = orgFeeService.searchByOrgId(orgId);
        modelAndView.addObject("orgFees", orgFees);
        modelAndView.addObject("org", org);
        return modelAndView;
    }
}

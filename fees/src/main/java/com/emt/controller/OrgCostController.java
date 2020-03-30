package com.emt.controller;

import com.emt.model.Result;
import com.emt.service.impl.OrgCostServiceImpl;
import com.emt.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emt.service.OrgCostService;


/**
 * @author 刘震
 * @date 2018年12月6日 上午9:27:57
 */
@RequestMapping("/orgCost")
@RestController
public class OrgCostController {

    @Autowired
    OrgCostServiceImpl orgcostService;


/*    @GetMapping("/refresh")
    public Result<?> refresh() {

        orgcostService.refreshOrgCost();

        return ResultUtil.sucess();
    }*/


}

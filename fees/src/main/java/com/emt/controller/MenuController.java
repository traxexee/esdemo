package com.emt.controller;

import com.emt.model.p.Menu;
import com.emt.model.Result;
import com.emt.service.MenuService;
import com.emt.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in20:53 2018/9/1.
 * @Modified By:
 */

@Slf4j
@RequestMapping("/menu")
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping
    public Map<String, List<Menu>> getMenu() {
        return menuService.findAllByAdminIdMap(1);
    }

    //菜单权限控制
    @GetMapping("/getAll")
    public ModelAndView page(ModelAndView modelAndView) {
        modelAndView.addObject("list", menuService.findAll());
        modelAndView.setViewName("/menu/list");
        return modelAndView;
    }

    @GetMapping("/getList/adminId/{adminId}")
    public ModelAndView admin(@PathVariable("adminId") Integer adminId, ModelAndView modelAndView) {
        modelAndView.addObject("list", menuService.findAllByAdminId(adminId));
        modelAndView.addObject("noList", menuService.findAllNoByAdminId(adminId));
        modelAndView.setViewName("/admin/menuList");
        return modelAndView;
    }

    @PostMapping
    public Result save(@RequestBody Menu menu) {
        menuService.save(menu);
        return ResultUtil.sucess();
    }

}

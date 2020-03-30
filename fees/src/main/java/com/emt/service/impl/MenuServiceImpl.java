package com.emt.service.impl;

import com.emt.constant.MenuConstant;
import com.emt.model.p.Menu;
import com.emt.repository.p.MenuRepository;
import com.emt.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in20:59 2018/9/1.
 * @Modified By:
 */
@Slf4j
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> findAllByAdminId(Integer adminId) {
        return menuRepository.findAllByAdminId(adminId);
    }

    @Override
    public Map<String, List<Menu>> findAllByAdminIdMap(Integer adminId) {
        Map<String, List<Menu>> map = new HashMap<>();
        for (String menu : MenuConstant.menuList) {
            List<Menu> menus = menuRepository.findAllByGroupName(menu);
            if (menus != null && menus.size() != 0) {
                map.put(menu, menuRepository.findAllByGroupName(menu));
            }
        }
        return map;
    }

    @Override
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public List<Menu> findAllNoByAdminId(Integer adminId) {


        return menuRepository.findAllNoByAdminId(adminId);
    }

    @Override
    public void save(Menu menu) {
        List<Menu> menus = menuRepository.findAllByTitle(menu.getTitle());
   /*     if (menus != null && menus.size() > 0) {
            throw new BillException(ResultEnum.ADD_EXIST);
        }*/
        menuRepository.save(menu);
    }
}

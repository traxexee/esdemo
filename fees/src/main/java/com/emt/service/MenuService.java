package com.emt.service;


import com.emt.model.p.Menu;

import java.util.List;
import java.util.Map;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in20:54 2018/9/1.
 * @Modified By:
 */
public interface MenuService {
    List<Menu> findAllByAdminId(Integer adminId);

    Map<String,List<Menu>> findAllByAdminIdMap(Integer adminId);

    List<Menu> findAll();
    List<Menu> findAllNoByAdminId(Integer adminId);
    void save(Menu menu);

}

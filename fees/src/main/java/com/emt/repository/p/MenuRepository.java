package com.emt.repository.p;

import com.emt.model.p.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in20:53 2018/9/1.
 * @Modified By:
 */
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Query(value = "select m.id id,title,icon,href,spread,group_name from menu m RIGHT JOIN admin_menu a on m.id =a.menu_id where a.admin_id =?1  ", nativeQuery = true)
    List<Menu> findAllByAdminId(Integer adminId);

    @Query(value = "select m.id id,title,icon,href, spread,group_name from menu m RIGHT JOIN admin_menu a on m.id =a.menu_id where a.admin_id =?1 and m.group_name=?2", nativeQuery = true)
    List<Menu> findAllByAdminIdAndGroupName(Integer adminId, String groupName);

    @Query(value = "select m.id id,title,icon,href, spread,group_name from menu_fee m where m.group_name=?1", nativeQuery = true)
    List<Menu> findAllByGroupName( String groupName);

    @Query(value = "select m.id id,title,icon,href, spread,group_name from menu m RIGHT JOIN admin_menu a on m.id =a.menu_id where a.admin_id =?1 and m.group_name=?2", nativeQuery = true)
    List<Menu> findAllByAdminIdAndGroupName1(Integer adminId, String groupName);

    @Query(value = "select * from menu where id NOT IN (SELECT m.id from menu m RIGHT JOIN admin_menu a on m.id =a.menu_id where a.admin_id =?1) ", nativeQuery = true)
    List<Menu> findAllNoByAdminId(Integer adminId);

    List<Menu> findAllByTitle(String name);

}

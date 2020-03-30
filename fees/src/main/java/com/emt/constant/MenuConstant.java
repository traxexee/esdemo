package com.emt.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author
 * @Description* @Datein212018/9/1.
 * @Modified By
 */
public interface MenuConstant {
    //菜单父类
    List<String> menuList = new ArrayList<String>() {
        private static final long serialVersionUID = 1L;

        {
            add("contentManagement");
            add("memberCenter");
            add("systemSettings");
            add("seraphApi");
            add("dicApi");
            add("quartzApi");
        }
    };
}

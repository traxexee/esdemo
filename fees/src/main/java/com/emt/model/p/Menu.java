package com.emt.model.p;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in20:55 2018/9/1.
 * @Modified By:
 */
@Data
@Entity
@Table(name="menu_fee")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = " id")
    private Integer id;
    @Column(name = " title")
    private String title;
    @Column(name = " icon")
    private String icon;
    @Column(name = " href")
    private String href;
    @Column(name = " spread")
    private boolean spread;
    @Column(name = " group_name")
    private String groupName;

}

package com.emt.service;

import com.emt.model.p.Org;

import java.util.Date;
import java.util.List;


/**
 * @author 刘震
 * @date 2018年12月6日 上午9:40:57
 */
public interface OrgService {
    List<Org> getAllOrg();

    Org findOneById(Integer id);

    List<Org> getProvinceOrg();
    List<Org> getOrgByProvinceId(Integer id);

    Date searchMinTime();

    void refresh();
}

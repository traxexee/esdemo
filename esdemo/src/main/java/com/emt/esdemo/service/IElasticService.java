package com.emt.esdemo.service;

import com.emt.esdemo.model.DocBean;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * @Author:刘震
 * @Description:
 * @Date: Created in15:55 2020/12/14.
 * @Modified By:
 */
public interface IElasticService {
    void createIndex();

    void deleteIndex(String index);

    void save(DocBean docBean);

    void saveAll(List<DocBean> list);

    Iterator<DocBean> findAll();

    Page<DocBean> findByContent(String content);

    Page<DocBean> findByFirstCode(String firstCode);

    Page<DocBean> findBySecordCode(String secordCode);

    Page<DocBean> query(String key);

}

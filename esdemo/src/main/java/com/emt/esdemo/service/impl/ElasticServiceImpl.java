package com.emt.esdemo.service.impl;

import com.emt.esdemo.dao.ElasticRepository;
import com.emt.esdemo.model.DocBean;
import com.emt.esdemo.service.IElasticService;
import org.assertj.core.util.Lists;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import javax.xml.soap.Text;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in15:57 2020/12/14.
 * @Modified By:
 */
@Service("elasticService")
public class ElasticServiceImpl implements IElasticService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Autowired
    private ElasticRepository elasticRepository;

    private Pageable pageable = PageRequest.of(0,10);

    @Override
    public void createIndex() {
        elasticsearchTemplate.indexOps(DocBean.class);
    }

    @Override
    public void deleteIndex(String index) {
        elasticsearchTemplate.delete(index);
    }

    @Override
    public void save(DocBean docBean) {
        elasticRepository.save(docBean);
    }

    @Override
    public void saveAll(List<DocBean> list) {
        elasticRepository.saveAll(list);
    }

    @Override
    public Iterator<DocBean> findAll() {
        return elasticRepository.findAll().iterator();
    }

    @Override
    public Page<DocBean> findByContent(String content) {
        return elasticRepository.findByContent(content,pageable);
    }

    @Override
    public Page<DocBean> findByFirstCode(String firstCode) {
        return elasticRepository.findByFirstCode(firstCode,pageable);
    }

    @Override
    public Page<DocBean> findBySecordCode(String secordCode) {
        return elasticRepository.findBySecordCode(secordCode,pageable);
    }

    @Override
    public Page<DocBean> query(String key) {
        return elasticRepository.findByContent(key,pageable);
    }
}

package com.emt.esdemo.controller;

import com.emt.esdemo.model.DocBean;
import com.emt.esdemo.service.IElasticService;
import com.emt.esdemo.service.impl.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * @Author:刘震
 * @Description:
 * @Date: Created in15:59 2020/12/14.
 * @Modified By:
 */
@Slf4j
@RestController
@RequestMapping("/elastic")
public class ElasticController {

    @Autowired
    private IElasticService elasticService;
    @Autowired
    private ContentService contentService;

    @GetMapping("/init")
    public void init() {
        elasticService.createIndex();
        List<DocBean> list = new ArrayList<>();
        list.add(new DocBean(1L, "XX0193", "XX8064", "xxxxxx", 1));
        list.add(new DocBean(2L, "XX0210", "XX7475", "xxxxxxxxxx", 1));
        list.add(new DocBean(3L, "XX0257", "XX8097", "xxxxxxxxxxxxxxxxxx", 1));
        list.add(new DocBean(3L, "电力法", "中华人民共和国电力法", "中华人民共和国电力法\n", 1));
        elasticService.saveAll(list);

    }

    @GetMapping("/all")
    public Iterator<DocBean> all() {
        return elasticService.findAll();
    }

    @GetMapping("/find/{key}")
    public Page<DocBean> findByKey(@PathVariable String key) {

        return elasticService.findByContent(key);
    }

    @PostMapping("/up")
    public void up(DocBean docBean) {
        log.info(docBean.toString());
        elasticService.save(docBean);
    }
    @GetMapping("/doc/{key}")
    public ModelAndView findByKey1(@PathVariable String key) {
        Page<DocBean> list=elasticService.findByContent(key);

        ModelAndView mvn = new ModelAndView("doc/index");
        mvn.addObject("doc",list.getContent().get(0).getContent());
        return  mvn;
    }
    @GetMapping("/doc1/{key}")
    public ModelAndView doc1(@PathVariable String key) {
        Page<DocBean> list=elasticService.findByContent(key);

        ModelAndView mvn = new ModelAndView("doc/index");
        mvn.addObject("doc",list.getContent().get(1).getContent());
        return  mvn;
    }
    @GetMapping("/doc2/{key}")
    public ModelAndView doc2(@PathVariable String key) throws IOException {
        List<Map<String, Object>>list=contentService.searchHighlightPage(key,0,10);

        ModelAndView mvn = new ModelAndView("doc/index");
        log.info(list.get(1).toString());
       /* DocBean docBean = (DocBean) list.get(0);*/
        mvn.addObject("doc",list.get(1));
        return  mvn;
    }
}

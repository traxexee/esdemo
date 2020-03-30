package com.emt.service.impl;

import com.emt.model.p.MchProvinceMapper;
import com.emt.repository.p.MchProvinceRepository;
import com.emt.service.MchProvinceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in13:40 2019/4/12.
 * @Modified By:
 */
@Slf4j
@Service
public class MchProvinceServiceImpl implements MchProvinceService {
    @Autowired
    private MchProvinceRepository mchProvinceRepository;

    @Override
    public List<MchProvinceMapper> findAll() {
        log.info("获取所有省份");
        return mchProvinceRepository.findAll();
    }
}

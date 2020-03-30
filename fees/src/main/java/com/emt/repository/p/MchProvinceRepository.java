package com.emt.repository.p;

import com.emt.model.p.MchProvinceMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in13:53 2019/4/9.
 * @Modified By:
 */
public interface MchProvinceRepository extends JpaRepository<MchProvinceMapper, Integer> {
    List<MchProvinceMapper> findAll();
}

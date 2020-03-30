package com.emt.model.p;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "mch_province_mapper")
public class MchProvinceMapper {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "province")
    private String province;


}
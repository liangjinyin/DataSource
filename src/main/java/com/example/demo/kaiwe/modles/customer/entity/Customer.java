package com.example.demo.kaiwe.modles.customer.entity;

import com.example.demo.kaiwe.common.modle.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: liangjinyin
 * @Date: 2018-08-30
 * @Description:
 */
@Data
public class Customer extends BaseEntity implements Serializable {


    private Integer id;
    private String name;
    private String address;
    private String phone;
}

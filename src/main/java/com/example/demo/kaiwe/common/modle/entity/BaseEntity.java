package com.example.demo.kaiwe.common.modle.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: liangjinyin
 * @Date: 2018-08-30
 * @Description:
 */
@Data
public abstract class BaseEntity implements Serializable{
    protected Integer flag;
    protected Integer id;
}

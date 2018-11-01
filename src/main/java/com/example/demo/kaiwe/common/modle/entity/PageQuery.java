package com.example.demo.kaiwe.common.modle.entity;

import lombok.Data;

import java.util.HashMap;

/**
 * @author: liangjinyin
 * @date:  2018/8/27 20:39
 * @description:
 */
@Data
public class PageQuery extends HashMap<String,Object>{

    public PageQuery(){}

    /**
     * 构造类，例：new Parameter(id, parentIds)
     * @param values 参数值
     */
    public PageQuery(Object... values) {
        if (values != null){
            for (int i=0; i<values.length; i++){
                put("p"+(i+1), values[i]);
            }
        }
    }

    /**
     * 构造类，例：new Parameter(new Object[][]{{"id", id}, {"parentIds", parentIds}})
     * @param parameters 参数二维数组
     */
    public PageQuery(Object[][] parameters) {
        if (parameters != null){
            for (Object[] os : parameters){
                if (os.length == 2){
                    put((String)os[0], os[1]);
                }
            }
        }
    }

    private String name;

    private String type;
}

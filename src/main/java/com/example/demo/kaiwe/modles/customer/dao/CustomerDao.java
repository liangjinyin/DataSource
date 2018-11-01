package com.example.demo.kaiwe.modles.customer.dao;

import com.example.demo.kaiwe.modles.customer.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: liangjinyin
 * @Date: 2018-08-30
 * @Description:
 */
@Mapper
public interface CustomerDao {

    @Select("select * from sys_customer limit 1,10")
    List<Customer> findAll1();
    @Select("select * from sys_customer limit 1,10")
    List<Customer> findAll2();

}

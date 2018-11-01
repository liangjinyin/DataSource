package com.example.demo.kaiwe.modles.customer.controller;


import com.example.demo.kaiwe.common.modle.controller.BaseController;
import com.example.demo.kaiwe.modles.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liangjinyin
 * @Date: 2018-08-30
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/customer")
public class CustomerController extends BaseController {


    @Autowired
    private CustomerService customerService;


    @GetMapping("/findList1")
    public String findCustomerList1() {
        data = customerService.findAll1();
        return result();
    }
    @GetMapping("/findList2")
    public String findCustomerList2() {
        data = customerService.findAll2();
        return result();
    }
}

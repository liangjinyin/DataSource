package com.example.demo.kaiwe.modles.customer.service;


import com.example.demo.kaiwe.common.enums.ResultCode;
import com.example.demo.kaiwe.common.modle.service.BaseService;
import com.example.demo.kaiwe.modles.customer.dao.CustomerDao;
import com.example.demo.kaiwe.modles.mydatasource.DS;
import com.example.demo.kaiwe.modles.mydatasource.DsEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author: liangjinyin
 * @Date: 2018-08-30
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class CustomerService extends BaseService {
    @SuppressWarnings("all")
    @Autowired
    private CustomerDao customerDao;

    @DS(value = DsEnum.SZ_DS)
    public Object findAll1() {
        try {
           return customerDao.findAll1();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}",getClass().getSimpleName(),e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }
    @DS(value = DsEnum.GZ_DS)
    public Object findAll2() {
        try {
           return customerDao.findAll2();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}",getClass().getSimpleName(),e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }
}

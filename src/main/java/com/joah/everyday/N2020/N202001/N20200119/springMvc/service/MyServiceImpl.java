package com.joah.everyday.N2020.N202001.N20200119.springMvc.service;

import com.joah.everyday.N2020.N202001.N20200119.springMvc.annotation.CustomService;

/**
 * @author Joah
 * @time 2020/1/19 11:39
 */
@CustomService("MyServiceImpl")
public class MyServiceImpl implements MyService {

    @Override
    public String query(String name, String age) {

        return "name:" + name + ";age:" + age;
    }
}

package com.joah.everyday.N2020.N202001.N20200119.springMvc.controller;

import com.joah.everyday.N2020.N202001.N20200119.springMvc.annotation.CustomController;
import com.joah.everyday.N2020.N202001.N20200119.springMvc.annotation.CustomQualifier;
import com.joah.everyday.N2020.N202001.N20200119.springMvc.annotation.CustomRequestMapping;
import com.joah.everyday.N2020.N202001.N20200119.springMvc.annotation.CustomRequestParam;
import com.joah.everyday.N2020.N202001.N20200119.springMvc.service.MyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Joah
 * @time 2020/1/19 11:37
 */
@CustomController
@CustomRequestMapping("/custom")
public class MyController {

    @CustomQualifier("MyServiceImpl")
    private MyService myService;

    @CustomRequestMapping("query1")
    public void query(HttpServletRequest request, HttpServletResponse response,
                      @CustomRequestParam("name")String name, @CustomRequestParam("age")String age){

        PrintWriter pw;

        try {
            PrintWriter writer = response.getWriter();
            String result = myService.query(name,age);
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

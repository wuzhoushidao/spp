package com.platform.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zwl
 * @Date: 2018/12/24 17:53
 */
@RequestMapping("/test")
@RestController
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String printHello(){
        return "hello";
    }

}

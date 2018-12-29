package com.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description：
 * @Author： Administrator
 * @Date： 2018-12-22 23:49
 **/
@Controller
public class HomeController {
    @RequestMapping("/hello")
    public ModelAndView printHelloWorld(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        ModelAndView modelAndView = new ModelAndView();
        if (email != null && password != null) {
            modelAndView.setViewName("redirect:/user/add");
            modelAndView.addObject("username", email );
            modelAndView.addObject("password" , password);
            return modelAndView;
        } else {
            modelAndView.setViewName("view/readingList");
            return modelAndView;
        }
    }

    @RequestMapping("/")
    public String printHelloWorld1() {
        return "/view/readingList";
    }
}

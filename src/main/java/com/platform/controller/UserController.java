package com.platform.controller;

import com.platform.entity.User;
import com.platform.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zwl
 * @Date: 2018/12/24 17:39
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/add")
    public String add(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return "1";
        } else {
            User user2 = new User();
            user2.setUsername(username);
            user2.setPassword(password);
            userRepository.save(user2);
            return "新增用户成功！用户名为" + user2.getUsername();
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("username") String username) {
        User user = userRepository.findByUsername(username);
        userRepository.delete(user);
        if (userRepository.findByUsername(username) == null) {
            return "删除成功！";
        } else {
            return "删除失败！";
        }
    }


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(@RequestParam("username") String username,@RequestParam("password") String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return "用户名不存在！";
        } else {
            user.setPassword(password);
            userRepository.saveAndFlush(user);
            return "修改用户成功!";
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public StringBuffer list() {
        List<User> users = userRepository.findAll();
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<users.size();i++){
            sb.append(users.get(i).getUsername()+","+users.get(i).getPassword()+"</br>");
        }
        return sb;
    }

}

package com.effort.Controller;

import com.effort.bean.User;
import com.effort.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/22.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getUser")
    public User getUser(){
        System.out.println("11111111111111");
        List<User> users = userMapper.selectAllUser();
        return users.get(0);
    }
}

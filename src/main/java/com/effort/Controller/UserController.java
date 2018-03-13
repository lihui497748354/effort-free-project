package com.effort.Controller;

import com.effort.bean.User;
import com.effort.Dao.UserMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/8/22.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    private static Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getUser")
    public User getUser(){
        List<User> users = userMapper.selectAllUser();
        logger.info(users);
        return users.get(0);
    }
}

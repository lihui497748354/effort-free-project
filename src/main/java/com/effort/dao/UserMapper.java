package com.effort.dao;

import com.effort.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM User_table WHERE 1 = 1")
    List<User> selectAllUser();

}

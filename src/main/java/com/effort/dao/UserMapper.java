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

    List<User> selectAllUser();

}

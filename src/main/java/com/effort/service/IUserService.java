package com.effort.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.effort.domain.User;

/**
 * =================================================================
 * @author Administrator
 * creator Effort
 * createDate 2017-6-6
 * 
 * User's CRUD
 * =================================================================
 */
public interface IUserService {
	

	/**
	 * save user
	 * @param user
	 * @return
	 */
	User saveUser(User user);
	
	/**
	 * update user
	 * @param user
	 * @return
	 */
	User updateUser(User user);
	
	/**
	 * delete users or user
	 * @param ids
	 * @return
	 */
	int deleteUser(String...ids);
	
	/**
	 * find userList
	 * @return
	 */
	List<User> selectUser();
	
	/**
	 * find user by Id
	 * @param id
	 * @return
	 */
	User selectUserById(String id);
	
}

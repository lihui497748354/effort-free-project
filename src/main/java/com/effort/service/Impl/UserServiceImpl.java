package com.effort.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.effort.domain.User;
import com.effort.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUser(String... ids) {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(ids[0]);
		return id;
	}

	@Override
	public List<User> selectUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}

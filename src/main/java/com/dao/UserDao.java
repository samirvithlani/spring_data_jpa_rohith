package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;
import com.service.UserRepository;
import com.service.UserServices;

@Repository
public class UserDao implements UserServices {

	// jdbcTemaplet
	@Autowired
	UserRepository userRepository;

	@Override
	public int addUser(UserBean userBean) {
		int res = 0;
		try {
			userRepository.save(userBean);
			res = 1;
		} catch (Exception e) {
			res = -1;
		}
		return res;
	}

	@Override
	public List<UserBean> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public int deleteUser(int id) {
		int res = 0;
		try {
			userRepository.deleteById(id);
			res = 1;
		} catch (Exception e) {

			res = -1;
		}
		return res;
	}

}

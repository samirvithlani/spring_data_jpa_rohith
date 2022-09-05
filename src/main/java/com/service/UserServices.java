package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bean.UserBean;

@Service
public interface UserServices {

	public int addUser(UserBean userBean);
	public List<UserBean> getAllUsers();
	public int deleteUser(int id);
}

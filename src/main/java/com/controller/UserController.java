package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.service.ResponseManager;
import com.service.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServices userServices;

	@PostMapping(value = "/user")
	public ResponseEntity<?> addUser(@RequestBody UserBean userBean) {

		int res = userServices.addUser(userBean);
		ResponseManager responseManager = new ResponseManager();
		if (res > 0) {

			responseManager.setCode(HttpStatus.CREATED);
			responseManager.setObject(userBean);
			responseManager.setStatus("success");
			return new ResponseEntity<ResponseManager>(responseManager, HttpStatus.CREATED);
		}
		responseManager.setCode(HttpStatus.EXPECTATION_FAILED);
		responseManager.setObject(null);
		responseManager.setStatus("failed");
		return new ResponseEntity<ResponseManager>(responseManager, HttpStatus.EXPECTATION_FAILED);

	}

	@GetMapping(value = "/user")
	public ResponseEntity<?> getAllUsers() {

		List<UserBean> users = userServices.getAllUsers();
		ResponseManager responseManager = new ResponseManager();

		if (users.size() > 0) {
			responseManager.setCode(HttpStatus.CREATED);
			responseManager.setObject(users);
			responseManager.setStatus("success");
			return new ResponseEntity<ResponseManager>(responseManager, HttpStatus.CREATED);

		}
		responseManager.setCode(HttpStatus.EXPECTATION_FAILED);
		responseManager.setObject(null);
		responseManager.setStatus("failed");
		return new ResponseEntity<ResponseManager>(responseManager, HttpStatus.EXPECTATION_FAILED);

	}

	@DeleteMapping(value = "/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {

		int res = userServices.deleteUser(id);
		ResponseManager responseManager = new ResponseManager();
		if (res > 0) {

			responseManager.setCode(HttpStatus.OK);
			responseManager.setObject(null);
			responseManager.setStatus("success");
			return new ResponseEntity<ResponseManager>(responseManager, HttpStatus.CREATED);

		}
		responseManager.setCode(HttpStatus.EXPECTATION_FAILED);
		responseManager.setObject(null);
		responseManager.setStatus("failed");
		return new ResponseEntity<ResponseManager>(responseManager, HttpStatus.EXPECTATION_FAILED);

	}

}

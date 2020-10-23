package com.chenlx.spring01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chenlx
 * @date 2020-08-15 11:20
 */
//@Component
public class UserService {

	public UserService() {
		System.out.println("初始话 UserService()");
	}

	private User user;

	@Autowired
	private List<User> list;

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
}

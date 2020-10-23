package com.chenlx.spring01;

/**
 * @author chenlx
 * @date 2020-08-13 12:16
 */
public class User {
	private Long userId;
	private String userName;

	public User() {
		System.out.println("User() 构造器被调用.........");
	}

	public User(String userName) {
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}

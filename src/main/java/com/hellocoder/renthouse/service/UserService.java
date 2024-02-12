package com.hellocoder.renthouse.service;

import java.util.List;

import com.hellocoder.renthouse.Pojo.User;

public interface UserService {

	public List<User> userList() throws Exception;
	public User login(User user) throws Exception;
	public User register(User user) throws Exception;
	public boolean insertUser(User user) throws Exception;
}

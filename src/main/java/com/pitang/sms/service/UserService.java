package com.pitang.sms.service;

import java.util.List;

import com.pitang.sms.model.UserModel;

public interface UserService {
	
	public List<UserModel> listUsers();
	
	public UserModel findUserByUsername(String username);
	
	public UserModel addUser (UserModel user);
	
	public UserModel updateUser (UserModel user);

	public void deleteUser(Long id);

}

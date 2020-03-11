package com.pitang.sms.service;

import java.util.List;

import com.pitang.sms.exceptions.ExceptionBadRequest;
import com.pitang.sms.exceptions.ExceptionConflict;
import com.pitang.sms.model.UserModel;

public interface UserService {
	
	List<UserModel> listUsers();
	
	UserModel findUserByUsername(String username);
	
	UserModel addUser (UserModel user) throws ExceptionConflict;
	
	UserModel updateUser (UserModel user) throws ExceptionConflict;

	void deleteUser(Long id) throws ExceptionBadRequest;

}

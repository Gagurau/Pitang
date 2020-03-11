package com.pitang.sms.controller;



import com.pitang.sms.exceptions.ExceptionBadRequest;
import com.pitang.sms.exceptions.ExceptionConflict;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pitang.sms.dto.UserDto;
import com.pitang.sms.mapper.ModelMapperComponent;
import com.pitang.sms.model.UserModel;
import com.pitang.sms.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@RequestMapping (method = RequestMethod.GET, path = "/hwu")
	public String hwu() {
		return "hello world! user!";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<UserDto>> listUsers(){
		List<UserModel> users = userService.listUsers();
		
		if(users.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<UserDto> usersDto =(ModelMapperComponent.modelMapper.map(users, new TypeToken<List<UserDto>>() {}.getType()));

		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<>(usersDto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<UserDto> addUsers(@RequestBody UserDto userDto) throws ExceptionConflict {
		
		if(userDto == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		UserModel userModel = ModelMapperComponent.modelMapper.map(userDto, new TypeToken<UserModel>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		userService.addUser(userModel);
		
		userDto = ModelMapperComponent.modelMapper.map(userModel, new TypeToken<UserDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<>(userDto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<UserDto> updateUsers(@PathVariable("id") Long id, @RequestBody UserDto userDto) throws ExceptionConflict {
		
		
		UserModel userModel = ModelMapperComponent.modelMapper.map(userDto, new TypeToken<UserModel>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		userService.updateUser(userModel);
		
		userDto = ModelMapperComponent.modelMapper.map(userModel, new TypeToken<UserDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<>(userDto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<UserDto> removeUser(@PathVariable("id") Long id) throws ExceptionBadRequest {
		
		userService.deleteUser(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
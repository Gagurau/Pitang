package com.pitang.sms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pitang.sms.exceptions.ExceptionBadRequest;
import com.pitang.sms.exceptions.ExceptionConflict;
import com.pitang.sms.model.UserModel;
import com.pitang.sms.repository.UserRepository;
import com.pitang.sms.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserModel> listUsers() {
		if(userRepository.findAll().size() == 0) {
			return null;
		}
		return userRepository.findAll();
	}
	
	@Override
	public UserModel findUserByUsername(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public UserModel addUser(UserModel user) {
		validateUser(user);
		checkIntegrity(user);
		return userRepository.save(user);
	}
	
	@Override
	public UserModel updateUser(UserModel user) {
		checkIntegrity(user);
		//validateUser(user);
		return userRepository.save(user);
	}
	
	private void checkIntegrity(UserModel user) {
		checkMandatoryFields(user);
		//checkRelations(user);
	}
	
	private void checkMandatoryFields(UserModel user) {
		if(user == null) {
			try {
				throw new ExceptionBadRequest("Usuário não pode ser nulo!");
			} catch (ExceptionBadRequest e) {
				e.printStackTrace();
			}
		}
		if(StringUtils.isEmpty(user.getEmail())) {
			try {
				throw new ExceptionBadRequest("Necessário informar o Email do usuário.");
			} catch (ExceptionBadRequest e) {
				e.printStackTrace();
			}
		}
		if(StringUtils.isEmpty(user.getPassword())) {
			try {
				throw new ExceptionBadRequest("Necessário informar a Senha do usuário.");
			} catch (ExceptionBadRequest e) {
				e.printStackTrace();
			}
		}
		if(StringUtils.isEmpty(user.getUserName())) {
			try {
				throw new ExceptionBadRequest("Necessário informar o Nome do usuário.");
			} catch (ExceptionBadRequest e) {
				e.printStackTrace();
			}
		}
	}
	
	private void validateUser(UserModel user) {
		if(!StringUtils.isEmpty(user.getUserName()) && userRepository.findByUserName(user.getUserName()) != null) {
			try {
				throw new ExceptionConflict("Nome de usuário informado já existe!");
			} catch (ExceptionConflict e) {
				e.printStackTrace();
			}
		}
		if(!StringUtils.isEmpty(user.getEmail()) && userRepository.findByEmail(user.getEmail()) != null) {
			try {
				throw new ExceptionConflict("Email informado já existe!");
			} catch (ExceptionConflict e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteUser(Long id) {
		Optional<UserModel> user = userRepository.findById(id);
		if(user.isPresent()) {
			userRepository.deleteById(id);
		}
	}
}

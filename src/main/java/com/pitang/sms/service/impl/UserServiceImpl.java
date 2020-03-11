package com.pitang.sms.service.impl;

import java.util.List;
import java.util.Optional;

import com.pitang.sms.repository.ContactRepository;
import com.pitang.sms.repository.MessageRepository;
import com.pitang.sms.repository.StoryRepository;
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

	@Autowired
	private ContactRepository contactRepository;

//	@Autowired
//	private HistoryPasswordService historyPasswordService;

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private StoryRepository storyRepository;

	@Override
	public List<UserModel> listUsers() {
		if (userRepository.findAll().size() == 0) {
			return null;
		}
		return userRepository.findAll();
	}

	@Override
	public UserModel findUserByUsername(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public UserModel addUser(UserModel user) throws ExceptionConflict {
		validateUser(user);
		return userRepository.save(user);
	}

	@Override
	public UserModel updateUser(UserModel user) throws ExceptionConflict {
		validateUserForUpdate(user);
		return userRepository.save(user);
	}

	private void checkMandatoryFields(UserModel user) throws ExceptionBadRequest {
		if (user == null) {
			throw new ExceptionBadRequest("Usuário não pode ser nulo!");
		}
		if (StringUtils.isEmpty(user.getEmail())) {
			throw new ExceptionBadRequest("Necessário informar o Email do usuário.");
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			throw new ExceptionBadRequest("Necessário informar a Senha do usuário.");
		}
		if (StringUtils.isEmpty(user.getUserName())) {
			throw new ExceptionBadRequest("Necessário informar o Nome do usuário.");
		}
	}

	private void validateUser(UserModel user) throws ExceptionConflict {
		if (!StringUtils.isEmpty(user.getUserName()) && userRepository.findByUserName(user.getUserName()) != null) {
			throw new ExceptionConflict("Nome de usuário informado já existe!");
		}
		if (!StringUtils.isEmpty(user.getEmail()) && userRepository.findByEmail(user.getEmail()) != null) {
			throw new ExceptionConflict("Email informado já existe!");
		}
	}

	private void validateUserForUpdate(UserModel user) throws ExceptionConflict {
		if (!StringUtils.isEmpty(user.getUserName()) && user.getId() != null) {
			UserModel userReturned = userRepository.findByUserName(user.getUserName());
			if (userReturned != null && userReturned.getId() != null && !userReturned.getId().equals(user.getId())) {
				throw new ExceptionConflict("Nome de usuário informado já existe!");
			}
		}
		if (!StringUtils.isEmpty(user.getEmail()) && user.getId() != null) {
			UserModel userReturned = userRepository.findByEmail(user.getEmail());
			if (userReturned != null && userReturned.getId() != null && !userReturned.getId().equals(user.getId())) {
				throw new ExceptionConflict("Email informado já existe!");
			}
		}
	}

	@Override
	public void deleteUser(Long id) throws ExceptionBadRequest {
		userRepository.delete(getUserById(id));
	}


	private UserModel getUserById(Long id) throws ExceptionBadRequest {
		Optional<UserModel> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new ExceptionBadRequest("Usuário não encontrado!");
		}
		return user.get();
	}

}

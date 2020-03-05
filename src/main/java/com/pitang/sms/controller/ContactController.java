package com.pitang.sms.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pitang.sms.dto.ContactDto;
import com.pitang.sms.exceptions.ExceptionBadRequest;
import com.pitang.sms.mapper.ModelMapperComponent;
import com.pitang.sms.model.ContactModel;
import com.pitang.sms.service.ContactService;

@RequestMapping(value = "/contact")
@RestController
public class ContactController {
	private ContactService contactService;	
	
	public ContactController (ContactService contactService) {
		super();
		this.contactService = contactService;
	}
	
	@GetMapping
	public ResponseEntity <List<ContactDto>> listContacts(){
		List<ContactModel> contacts = contactService.listContacts();
		if (contacts.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List <ContactDto> contactsDto = ModelMapperComponent.modelMapper.map(contacts, new TypeToken<List<ContactDto>>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		return new ResponseEntity<>(contactsDto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ContactDto> addContact(@RequestBody ContactDto contactDto) throws ExceptionBadRequest {
		if (contactDto == null) {
			throw new ExceptionBadRequest("Não é possível salvar um contato nulo!");
		}
		ContactModel contactModel = ModelMapperComponent.modelMapper.map(contactDto, new TypeToken<ContactModel>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		contactService.addContact(contactModel);
		contactDto = ModelMapperComponent.modelMapper.map(contactModel, new TypeToken<ContactDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		return new ResponseEntity<>(contactDto, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ContactDto> updateContact(@PathVariable Long id, @Valid @RequestBody ContactDto contactDto) throws ExceptionBadRequest{
		if (id == null) {
			throw new ExceptionBadRequest("Não é possível alterar um contato nulo");
		}
		
		ContactModel contactModel = ModelMapperComponent.modelMapper.map(contactDto, new TypeToken<ContactModel>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		contactService.updateContact(contactModel);
		contactDto = ModelMapperComponent.modelMapper.map(contactModel, new TypeToken<ContactDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		return new ResponseEntity<>(contactDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Void> removeContact(Long id){
		contactService.deleteContact(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

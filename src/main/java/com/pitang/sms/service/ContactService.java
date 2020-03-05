package com.pitang.sms.service;

import java.util.List;

import com.pitang.sms.model.ContactModel;

public interface ContactService {
	public List <ContactModel> listContacts();
	
	public ContactModel findContactById(Long id);
	
	public ContactModel addContact(ContactModel contact);
	
	public ContactModel updateContact(ContactModel contact);
	
	public void deleteContact (Long id);
}

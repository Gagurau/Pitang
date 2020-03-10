package com.pitang.sms.service.impl;

import com.pitang.sms.model.ContactModel;
import com.pitang.sms.repository.ContactRepository;
import com.pitang.sms.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<ContactModel> listContacts() {
        return null;
    }

    @Override
    public ContactModel findContactById(Long id) {
        return null;
    }

    @Override
    public ContactModel addContact(ContactModel contact) {
        return null;
    }

    @Override
    public ContactModel updateContact(ContactModel contact) {
        return null;
    }

    @Override
    public void deleteContact(Long id) {

    }
}

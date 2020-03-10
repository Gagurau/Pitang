package com.pitang.sms.repository;

import com.pitang.sms.model.ContactModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository <ContactModel, Long>{
    ContactModel findByNick (String nick);
}

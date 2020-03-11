package com.pitang.sms.repository;

import com.pitang.sms.model.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageModel, Long> {
}

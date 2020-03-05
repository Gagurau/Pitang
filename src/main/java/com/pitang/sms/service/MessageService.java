package com.pitang.sms.service;

import java.util.List;

import com.pitang.sms.model.MessageModel;

public interface MessageService {
	public List<MessageModel> listMessages();
	
	public MessageModel findMessageById(Long id);
	
	public MessageModel updateMessage(MessageModel message);
	
	public void deleteMessage(Long id);
	
}

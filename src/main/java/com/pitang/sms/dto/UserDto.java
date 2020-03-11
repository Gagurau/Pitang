package com.pitang.sms.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pitang.sms.model.ContactModel;
import com.pitang.sms.model.HistoryPasswordModel;
import com.pitang.sms.model.MessageModel;
import com.pitang.sms.model.ProfileModel;
import com.pitang.sms.model.StoryModel;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
	private long id;
	private String name;
	private String userName;
	private String email;
	private String Password;
	private List <ContactDto>contactsSrc;
	private List <ContactDto> contactsDst;
	private StoryDto story;
	private ProfileDto profile;
	private List <MessageDto> messageDst;
	private List <MessageDto> messageSrc;
	private List <HistoryPasswordDto> historyPassword;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public List<ContactDto> getContactsSrc() {
		return contactsSrc;
	}
	public void setContactsSrc(List<ContactDto> contactsSrc) {
		this.contactsSrc = contactsSrc;
	}
	public List<ContactDto> getContactsDst() {
		return contactsDst;
	}
	public void setContactsDst(List<ContactDto> contactsDst) {
		this.contactsDst = contactsDst;
	}
	public StoryDto getStory() {
		return story;
	}
	public void setStory(StoryDto story) {
		this.story = story;
	}
	public ProfileDto getProfile() {
		return profile;
	}
	public void setProfile(ProfileDto profile) {
		this.profile = profile;
	}
	public List<MessageDto> getMessageDst() {
		return messageDst;
	}
	public void setMessageDst(List<MessageDto> messageDst) {
		this.messageDst = messageDst;
	}
	public List<MessageDto> getMessageSrc() {
		return messageSrc;
	}
	public void setMessageSrc(List<MessageDto> messageSrc) {
		this.messageSrc = messageSrc;
	}
	public List<HistoryPasswordDto> getHistoryPassword() {
		return historyPassword;
	}
	public void setHistoryPassword(List<HistoryPasswordDto> historyPassword) {
		this.historyPassword = historyPassword;
	}


}

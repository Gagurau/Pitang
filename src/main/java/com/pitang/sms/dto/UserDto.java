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
	private List <ContactModel>contactsSrc;
	private List <ContactModel> contactsDst;
	private StoryModel story;
	private Boolean status;
	private ProfileModel profile;
	private List <MessageModel> messageDst;
	private List <MessageModel> messageSrc;
	private List <HistoryPasswordModel> historyPassword;

	public Boolean getStatus() {return this.status;}
	public void setStatus(Boolean status) {this.status = status;}
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
	public List<ContactModel> getContactsSrc() {
		return contactsSrc;
	}
	public void setContactsSrc(List<ContactModel> contactsSrc) {
		this.contactsSrc = contactsSrc;
	}
	public List<ContactModel> getContactsDst() {
		return contactsDst;
	}
	public void setContactsDst(List<ContactModel> contactsDst) {
		this.contactsDst = contactsDst;
	}
	public StoryModel getStory() {
		return story;
	}
	public void setStory(StoryModel story) {
		this.story = story;
	}
	public ProfileModel getProfile() {
		return profile;
	}
	public void setProfile(ProfileModel profile) {
		this.profile = profile;
	}
	public List<MessageModel> getMessageDst() {
		return messageDst;
	}
	public void setMessageDst(List<MessageModel> messageDst) {
		this.messageDst = messageDst;
	}
	public List<MessageModel> getMessageSrc() {
		return messageSrc;
	}
	public void setMessageSrc(List<MessageModel> messageSrc) {
		this.messageSrc = messageSrc;
	}
	public List<HistoryPasswordModel> getHistoryPassword() {
		return historyPassword;
	}
	public void setHistoryPassword(List<HistoryPasswordModel> historyPassword) {
		this.historyPassword = historyPassword;
	}
	
		
}

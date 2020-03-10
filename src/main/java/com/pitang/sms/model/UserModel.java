package com.pitang.sms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "users")
public class UserModel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size (max = 65)
	@Column (name = "name", unique = true)
	private String name;
	
	@NotNull
	@Size (max = 65)
	@Column(name = "userName")
	private String userName;
	
	@NotNull
	@Email
	@Size (max = 100)
	@Column (unique = true, name = "email")
	private String email;
	
	@NotNull
	@Size (max = 128)
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Column(name = "status")
	private boolean status;
	
	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<HistoryPasswordModel> historyPassword;
	
	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<ContactModel> contactSrc;
	
	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<ContactModel> contactDst;
	
	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<StoryModel> story;
	
	@OneToOne (fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private ProfileModel profile;
	
	@OneToMany (fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List <MessageModel> messageSrc;
	
	@OneToMany (fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List <MessageModel> messageDst;

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List <HistoryPasswordModel> getHistoryPassword() {
		return historyPassword;
	}

	public void setHistoryPassword(List<HistoryPasswordModel>historyPassword) {
		this.historyPassword = historyPassword;
	}

	public List <ContactModel> getContactTargets() {
		return contactSrc;
	}

	public void setContactTargets(List <ContactModel> contactTargets) {
		this.contactSrc = contactTargets;
	}

	public List<ContactModel> getContactOwners() {
		return contactDst;
	}

	public void setContactOwners(List<ContactModel> contactOwners) {
		this.contactDst = contactOwners;
	}

	public List<StoryModel> getStory() {
		return story;
	}

	public void setStory(List<StoryModel> story) {
		this.story = story;
	}

	public ProfileModel getProfile() {
		return profile;
	}

	public void setProfile(ProfileModel profile) {
		this.profile = profile;
	}

	public List<MessageModel> getMessageSrc() {
		return messageSrc;
	}

	public void setMessageSrc(List <MessageModel> messageSrc) {
		this.messageSrc = messageSrc;
	}

	public List<MessageModel> getMessageDst() {
		return messageDst;
	}

	public void setMessageDst(List<MessageModel> messageDst) {
		this.messageDst = messageDst;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ContactModel> getContactSrc() {
		return contactSrc;
	}

	public void setContactSrc(List<ContactModel> contactSrc) {
		this.contactSrc = contactSrc;
	}

	public List<ContactModel> getContactDst() {
		return contactDst;
	}

	public void setContactDst(List<ContactModel> contactDst) {
		this.contactDst = contactDst;
	}
}

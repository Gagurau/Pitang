package com.pitang.sms.service;

import java.util.List;

import com.pitang.sms.model.ProfileModel;

public interface ProfileService {
	public List<ProfileModel> listProfiles();
	
	public ProfileModel findProfileById(Long id);
	
	public ProfileModel addProfileById(ProfileModel profile);
	
	public ProfileModel updateProfile (ProfileModel profile);
	
	public void deleteProfile(Long id);
}


package com.pitang.sms.service;

import java.util.List;

import com.pitang.sms.model.StoryModel;

public interface StoryService {
	public List<StoryModel> listStories();
	
	public StoryModel findStoryById(Long id);
	
	public StoryModel addStory(StoryModel story);
	
	public StoryModel updateStory (StoryModel story);
	
	public void deleteStory(Long id);
}

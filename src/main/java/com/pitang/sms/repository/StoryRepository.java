package com.pitang.sms.repository;

import com.pitang.sms.model.StoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<StoryModel, Long> {

}

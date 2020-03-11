package com.pitang.sms.repository;

import com.pitang.sms.model.HistoryPasswordModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryPasswordRepository extends JpaRepository<HistoryPasswordModel, Long> {
}

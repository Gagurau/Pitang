package com.pitang.sms.service;

import java.util.List;

import com.pitang.sms.model.HistoryPasswordModel;

public interface HistoryPasswordService {
	public List<HistoryPasswordModel> listHistoriess();
	
	public HistoryPasswordModel findHistoryById(Long id);
	
	public HistoryPasswordModel addHistory(HistoryPasswordModel history);
	
	public HistoryPasswordModel updateHistory(HistoryPasswordModel history);
	
	public void deleteHistory (Long id);
	
}

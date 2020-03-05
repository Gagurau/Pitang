package com.pitang.sms.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDto {
	private Long id;
	private Long idDst;
	private Long idSrc;
	private String message;
	private LocalDateTime dateTime;
	private byte statusSrc;
	private byte statusDst;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdDst() {
		return idDst;
	}
	public void setIdDst(Long idDst) {
		this.idDst = idDst;
	}
	public Long getIdSrc() {
		return idSrc;
	}
	public void setIdSrc(Long idSrc) {
		this.idSrc = idSrc;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public byte getStatusSrc() {
		return statusSrc;
	}
	public void setStatusSrc(byte statusSrc) {
		this.statusSrc = statusSrc;
	}
	public byte getStatusDst() {
		return statusDst;
	}
	public void setStatusDst(byte statusDst) {
		this.statusDst = statusDst;
	}
	

	
	}

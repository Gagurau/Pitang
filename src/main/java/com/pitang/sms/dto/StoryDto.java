package com.pitang.sms.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoryDto {
	private Long id;
	private Long idSrc;
	private String message;
	private LocalDateTime dateTime;
	private byte type;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public LocalDateTime getLocalDateTime() {return dateTime;}
	public void setLocalDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	
}

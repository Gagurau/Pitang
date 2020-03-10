package com.pitang.sms.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class StoryModel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column (name = "id_src")
	private Long idSrc;
	
	@NotNull
	@Column (name = "message")
	@Size (max = 200)
	private String message;
	
	@NotNull
	@Column (name = "post_date")
	private LocalDateTime dateTime;
	
	@NotNull
	@Column (name="type")
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

	public LocalDateTime getLocalDateTime() {
		return dateTime;
	}

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

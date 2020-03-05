package com.pitang.sms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MessageModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="id_src")
	private Long idSrc;
	
	@NotNull
	@Column (name = "id_dst")
	private Long idDst;
	
	@NotNull
	@Column(name="date")
	private Date datetime;
	
	@NotNull
	@Column(name = "message")
	@Size (max = 200)
	private String message;
	
	@NotNull
	@Column (name = "status_src")
	private byte  statusSrc;
	
	@NotNull
	@Column (name = "status_dst")
	private byte  statusDst;

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

	public Long getIdDst() {
		return idDst;
	}

	public void setIdDst(Long idDst) {
		this.idDst = idDst;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

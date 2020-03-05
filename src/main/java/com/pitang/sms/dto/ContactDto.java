package com.pitang.sms.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactDto {
	private Long id;
	private Long idOwner;
	private Long idTarget;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdOwner() {
		return idOwner;
	}
	public void setIdOwner(Long idOwner) {
		this.idOwner = idOwner;
	}
	public Long getIdTarget() {
		return idTarget;
	}
	public void setIdTarget(Long idTarget) {
		this.idTarget = idTarget;
	}
	
}

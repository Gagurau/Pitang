package com.pitang.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "contacts")
public class ContactModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "id_src")
	private Long idSrc;
	
	@NotNull
	@Column(name = "id_target")
	private Long idDst;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdOwner() {
		return idSrc;
	}

	public void setIdOwner(Long idOwner) {
		this.idSrc = idOwner;
	}

	public Long getIdTarget() {
		return idDst;
	}

	public void setIdTarget(Long idTarget) {
		this.idDst = idTarget;
	}
}

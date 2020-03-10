package com.pitang.sms.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "contacts")
public class ContactModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_src_id", nullable = false)
	private UserModel userSrc;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_dst_id", nullable = false)
	private UserModel userDst;
	
	@Column(name = "nick")
	private String nick;

	@NotNull
	@Column(name = "id_src")
	private Long idSrc;

	@NotNull
	@Column(name = "id_target")
	private Long idDst;

	public ContactModel(){
		super();
	}
	public UserModel getUserSrc() {
		return userSrc;
	}

	public void setUserSrc(UserModel userSrc) {
		this.userSrc = userSrc;
	}

	public UserModel getUserDst() {
		return userDst;
	}

	public void setUserDst(UserModel userDst) {
		this.userDst = userDst;
	}

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

	public String getNick() { return nick;	}

	public void setNick(String nick) {this.nick = nick;	}
}

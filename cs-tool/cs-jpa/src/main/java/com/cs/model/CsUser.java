package com.cs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="cs_user")
public class CsUser {

	 private Long id;
	 
	 private String nickname;
	 
	 private String email;
	 
	 private String pwd;
	 
	 private Date createDate;
	 
	 private Date lastLoginTime;
	 
	 private Integer status;

	 
	 @Id
		@GeneratedValue(generator = "paymentableGenerator")
		@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
		@Column
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="nickname",columnDefinition="varchar(20) DEFAULT NULL COMMENT '用户昵称'")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name="email",columnDefinition="varchar(128) DEFAULT NULL COMMENT '邮箱|登录帐号'")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="pwd",columnDefinition="varchar(32) DEFAULT NULL COMMENT '密码'")
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Column(name="createDate",columnDefinition="timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name="lastLoginTime",columnDefinition="timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间'")
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Integer getStatus() {
		return status;
	}

	@Column(name="status",columnDefinition="int(1) DEFAULT '1' COMMENT '1:有效，0:禁止登录'")
	public void setStatus(Integer status) {
		this.status = status;
	}
	 
	 
	 
}

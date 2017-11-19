package com.cs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="cs_user_role")
public class CsUserRole {

	  private Long id;
	  
	  private Long uid;
	  
	  private Long rid;
	  
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
	@Column(name="uid",columnDefinition="bigint(20) DEFAULT NULL COMMENT '用户ID'")
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	@Column(name="rid",columnDefinition="bigint(20) DEFAULT NULL COMMENT '角色ID'")
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	  
	  
}

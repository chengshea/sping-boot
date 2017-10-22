package com.cs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
* @Title: CsRolePermission.java 
* @Description: 角色 权限 
* @author cs 
* @date 2017年10月19日 下午12:47:02 
* @version V1.0
 */
@Entity
@Table(name="cs_role_permission")
public class CsRolePermission {
 
  private Long id;
	  
	  private Long pid;
	  
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
	@Column(name="pid",columnDefinition="bigint(20) DEFAULT NULL COMMENT '权限ID'")
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	
	@Column(name="rid",columnDefinition="bigint(20) DEFAULT NULL COMMENT '角色ID'")
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
}

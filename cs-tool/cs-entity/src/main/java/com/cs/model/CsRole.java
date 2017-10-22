package com.cs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * 
* @Title: CsRole.java 
* @Description: 角色 
* @author cs 
* @date 2017年10月19日 下午12:27:08 
* @version V1.0
 */
@Entity
@Table(name="cs_role")
public class CsRole {
	
	  
	  private Long id;
	  
	  private String name;
	  
	  private String type;
	  
	  private Date createDate;
	  
	  
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
	@Column(name="name",columnDefinition="varchar(32) DEFAULT NULL COMMENT '角色名称'")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="type",columnDefinition="varchar(10) DEFAULT NULL COMMENT '角色类型'")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	  
	@Column(name="createDate",columnDefinition="timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	} 
}

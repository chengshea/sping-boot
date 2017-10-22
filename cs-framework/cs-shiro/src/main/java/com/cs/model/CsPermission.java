package com.cs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="cs_permission")
public class CsPermission {

private long id;
	
	private String name;
	
	private String  url;
	
	private String type;
	
	private Long pid;
	
	private int sort;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
	@Column
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name ="name",columnDefinition = "varchar(50) default null comment '名称'")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name ="url",columnDefinition = "varchar(50) default null comment '路径'")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name ="type",columnDefinition = "varchar(20) default null comment '类型 1 菜单；2 按钮'")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name ="pid",columnDefinition = "bigint(50) default null comment '父id'")
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	@Column(name ="sort",columnDefinition = "int(4) default null comment '排序'")
	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
	
}

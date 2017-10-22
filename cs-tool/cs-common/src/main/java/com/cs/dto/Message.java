package com.cs.dto;

import java.util.Map;

public class Message {
     
   private int status;	
   private 	Map<String,Object>  data;
   private String msg;
   
   
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Message(int status, Map<String, Object> data, String msg) {
		super();
		this.status = status;
		this.data = data;
		this.msg = msg;
	}
	public Message(int status, String string, String msg) {
		this.status = status;
		this.msg = msg;
	}
	   
   
   
}

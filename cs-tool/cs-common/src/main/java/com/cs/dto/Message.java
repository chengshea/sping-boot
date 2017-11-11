package com.cs.dto;

import java.util.Map;

public class Message {
     
   private int status;	
   private 	Object data;
   private String msg;
   
   
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getData() {
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
	public Message(int status, Object obj, String msg) {
		this.status = status;
		this.msg = msg;
		this.data= obj;
	}
	   
   
   
}

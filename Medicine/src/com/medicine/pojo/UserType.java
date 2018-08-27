package com.medicine.pojo;

import java.io.Serializable;

public class UserType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6165171393942341038L;
	
	private String userName;
	
	private String realName;
	
	private String gender;
	
	private String pwd;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}

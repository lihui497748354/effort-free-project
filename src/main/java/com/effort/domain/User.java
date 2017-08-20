package com.effort.domain;

public class User {
	
	private String UId;
	
	private String UName;
	
	private Integer Uage;
	
	public User(){}

	public User(String uId, String uName, Integer uage) {
		super();
		UId = uId;
		UName = uName;
		Uage = uage;
	}

	public String getUId() {
		return UId;
	}

	public void setUId(String uId) {
		UId = uId;
	}

	public String getUName() {
		return UName;
	}

	public void setUName(String uName) {
		UName = uName;
	}

	public Integer getUage() {
		return Uage;
	}

	public void setUage(Integer uage) {
		Uage = uage;
	}
	
	
	
}

package com.ys.example;

public class UserBean {
	
	private int id;
	private String nickName;
	private int sex;
	private String name;
	private String password;
	
	public UserBean(int id, String name, String nickName, int sex, String password) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.sex = sex;
		this.name = name;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}

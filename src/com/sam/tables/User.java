package com.sam.tables;

public class User {
	private long id;
	private String name;
	private String email;
	private long mobileNo;
	private byte[] finger;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public byte[] getFinger() {
		return finger;
	}

	public void setFinger(byte[] finger) {
		this.finger = finger;
	}
}

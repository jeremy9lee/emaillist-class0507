package com.sds.icto.vo;

public class EmailListVO {

	private long no;
	private String firstName;
	private String lastName;
	private String email;

	
	
	public EmailListVO(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public EmailListVO(long no, String firstName, String lastName, String email) {
		super();
		this.no = no;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public EmailListVO() {
		// TODO Auto-generated constructor stub
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

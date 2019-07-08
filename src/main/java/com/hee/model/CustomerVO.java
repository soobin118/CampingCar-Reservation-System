package com.hee.model;

import java.sql.Date;

public class CustomerVO {
	private String licenseNum;
	private String phoneNum;
	private String cusName;
	private String address;
	private String email;
	private Date prevDate;
	private int prevCarInfo;
	
	public CustomerVO() {
		
	}
	public CustomerVO(String licenseNum, String phoneNum, String cusName, String address,
			String email, Date prevDate, int prevCarInfo) {
		super();
		this.licenseNum=licenseNum;
		this.phoneNum=phoneNum;
		this.cusName=cusName;
		this.address=address;
		this.email=email;
		this.prevDate=prevDate;
		this.prevCarInfo=prevCarInfo;
	}
	
	public String getLicenseNum() {
		return licenseNum;
	}
	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		email = email;
	}
	public Date getPrevDate() {
		return prevDate;
	}
	public void setPrevDate(Date prevDate) {
		this.prevDate = prevDate;
	}
	public int getPrevCarInfo() {
		return prevCarInfo;
	}
	public void setPrevCarInfo(int prevCarInfo) {
		this.prevCarInfo = prevCarInfo;
	}
	@Override
	public String toString() {
		return "CustomerVO [licenseNum=" + licenseNum + ", phoneNum=" + phoneNum + ", cusName=" + cusName + ", address="
				+ address + ", Email=" + email + ", prevDate=" + prevDate + ", prevCarInfo=" + prevCarInfo + "]";
	}
	
}

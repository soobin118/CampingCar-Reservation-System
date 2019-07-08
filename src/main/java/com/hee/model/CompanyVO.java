package com.hee.model;

public class CompanyVO {
	private int companyID;
	private String companyName;
	private String address;
	private String phoneNum;
	private String managerName;
	private String managerEmail;
	
	public CompanyVO() {
		
	}
	public CompanyVO(int companyID, String companyName, String address, 
			String phoneNum, String managerName, String managerEmail) {
		super();
		this.companyID=companyID;
		this.companyName=companyName;
		this.address=address;
		this.phoneNum=phoneNum;
		this.managerName=managerName;
		this.managerEmail=managerEmail;
	}
	
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	@Override
	public String toString() {
		return "CompanyVO [companyID=" + companyID + ", companyName=" + companyName + ", address=" + address
				+ ", phoneNum=" + phoneNum + ", managerName=" + managerName + ", managerEmail=" + managerEmail + "]";
	}
}

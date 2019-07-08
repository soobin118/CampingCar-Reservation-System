package com.hee.model;

public class RepairShopVO {
	private int repairShopID;
	private String repairShopName;
	private String phoneNum;
	private String address;
	private String managerName;
	private String managerEmail;
	
	public RepairShopVO() {
		
	}
	public RepairShopVO(int repairShopID, String repairShopName, String phoneNum,
			String address, String managerName, String managerEmail) {
		super();
		this.repairShopID=repairShopID;
		this.repairShopName=repairShopName;
		this.phoneNum=phoneNum;
		this.address=address;
		this.managerName=managerName;
		this.managerEmail=managerEmail;
	}
	public int getRepairShopID() {
		return repairShopID;
	}
	public void setRepairShopID(int repairShopID) {
		this.repairShopID = repairShopID;
	}
	public String getRepairShopName() {
		return repairShopName;
	}
	public void setRepairShopName(String repairShopName) {
		this.repairShopName = repairShopName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
		return "RepairShopVO [repairShopID=" + repairShopID + ", repairShopName=" + repairShopName + ", phoneNum="
				+ phoneNum + ", address=" + address + ", managerName=" + managerName + ", managerEmail=" + managerEmail
				+ "]";
	}
	
}

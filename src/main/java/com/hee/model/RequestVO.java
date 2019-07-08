package com.hee.model;

import java.sql.Date;

public class RequestVO {
	private int repairNum;
	private int carID;
	private int companyID;
	private String licenseNum;
	private Date dueDate;
	private String repairDetails;
	private Date repairDate;
	private int repairCost;
	private String otherRepairDetails;
	private int repairShopID;
	
	public RequestVO() {
		
	}

	public RequestVO(int repairNum, int carID, int companyID, String licenseNum, Date dueDate, String repairDetails,
			Date repairDate, int repairCost, String otherRepairDetails, int repairShopID) {
		super();
		this.repairNum = repairNum;
		this.carID = carID;
		this.companyID = companyID;
		this.licenseNum = licenseNum;
		this.dueDate = dueDate;
		this.repairDetails = repairDetails;
		this.repairDate = repairDate;
		this.repairCost = repairCost;
		this.otherRepairDetails = otherRepairDetails;
		this.repairShopID = repairShopID;
	}

	public int getRepairNum() {
		return repairNum;
	}

	public void setRepairNum(int repairNum) {
		this.repairNum = repairNum;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public int getCompanyID() {
		return companyID;
	}

	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getRepairDetails() {
		return repairDetails;
	}

	public void setRepairDetails(String repairDetails) {
		this.repairDetails = repairDetails;
	}

	public Date getRepairDate() {
		return repairDate;
	}

	public void setRepairDate(Date repairDate) {
		this.repairDate = repairDate;
	}

	public int getRepairCost() {
		return repairCost;
	}

	public void setRepairCost(int repairCost) {
		this.repairCost = repairCost;
	}

	public String getOtherRepairDetails() {
		return otherRepairDetails;
	}

	public void setOtherRepairDetails(String otherRepairDetails) {
		this.otherRepairDetails = otherRepairDetails;
	}

	public int getRepairShopID() {
		return repairShopID;
	}

	public void setRepairShopID(int repairShopID) {
		this.repairShopID = repairShopID;
	}

	@Override
	public String toString() {
		return "RequestVO [repairNum=" + repairNum + ", carID=" + carID + ", companyID=" + companyID + ", licenseNum="
				+ licenseNum + ", dueDate=" + dueDate + ", repairDetails=" + repairDetails + ", repairDate="
				+ repairDate + ", repairCost=" + repairCost + ", otherRepairDetails=" + otherRepairDetails
				+ ", repairShopID=" + repairShopID + "]";
	}
	
}

package com.hee.model;

import java.sql.Date;

public class RentalVO {
	private int rentalNum;
	private int charges;
	private int carID;
	private String licenseNum;
	private int companyID;
	private Date startDate;
	private int rentalPeriod;
	private Date dueDate;
	private String otherChargesDetails;
	private int otherCharges;
	
	public RentalVO() {
		
	}
	public RentalVO(int rentalNum, int charges, int carID, String licenseNum, int companyID, Date startDate,
			int rentalPeriod, Date dueDate, String otherChargesDetails, int otherCharges) {
		super();
		this.rentalNum = rentalNum;
		this.charges = charges;
		this.carID = carID;
		this.licenseNum = licenseNum;
		this.companyID = companyID;
		this.startDate = startDate;
		this.rentalPeriod = rentalPeriod;
		this.dueDate = dueDate;
		this.otherChargesDetails = otherChargesDetails;
		this.otherCharges = otherCharges;
	}
	public int getRentalNum() {
		return rentalNum;
	}
	public void setRentalNum(int rentalNum) {
		this.rentalNum = rentalNum;
	}
	public int getCharges() {
		return charges;
	}
	public void setCharges(int charges) {
		this.charges = charges;
	}
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public String getLicenseNum() {
		return licenseNum;
	}
	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getRentalPeriod() {
		return rentalPeriod;
	}
	public void setRentalPeriod(int rentalPeriod) {
		this.rentalPeriod = rentalPeriod;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getOtherChargesDetails() {
		return otherChargesDetails;
	}
	public void setOtherChargesDetails(String otherChargesDetails) {
		this.otherChargesDetails = otherChargesDetails;
	}
	public int getOtherCharges() {
		return otherCharges;
	}
	public void setOtherCharges(int otherCharges) {
		this.otherCharges = otherCharges;
	}
	@Override
	public String toString() {
		return "Rental [rentalNum=" + rentalNum + ", charges=" + charges + ", carID=" + carID + ", licenseNum="
				+ licenseNum + ", companyID=" + companyID + ", startDate=" + startDate + ", rentalPeriod="
				+ rentalPeriod + ", dueDate=" + dueDate + ", otherChargesDetails=" + otherChargesDetails
				+ ", otherCharges=" + otherCharges + "]";
	}
	
}

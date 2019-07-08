package com.hee.model;

import java.sql.Blob;
import java.sql.Date;

public class CampingCarVO {
	private int carID;
	private String carName;
	private String carNum;
	private Blob img;
	private String carDetails;
	private int numOfPassenger;
	private Date carRegisterDate;
	private int companyID;
	private int rentalCost;
	
	public CampingCarVO() {
		
	}
	
	public CampingCarVO(int carID, String carName, String carNum, Blob img, String carDetails, int numOfPassenger,
			Date carRegisterDate, int companyID, int rentalCost) {
		super();
		this.carID = carID;
		this.carName = carName;
		this.carNum = carNum;
		this.img = img;
		this.carDetails = carDetails;
		this.numOfPassenger = numOfPassenger;
		this.carRegisterDate = carRegisterDate;
		this.companyID = companyID;
		this.rentalCost = rentalCost;
	}

	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public Blob getImg() {
		return img;
	}
	public void setImg(Blob img) {
		this.img = img;
	}
	public String getCarDetails() {
		return carDetails;
	}
	public void setCarDetails(String carDetails) {
		this.carDetails = carDetails;
	}
	public int getNumOfPassenger() {
		return numOfPassenger;
	}
	public void setNumOfPassenger(int numOfPassenger) {
		this.numOfPassenger = numOfPassenger;
	}
	public Date getCarRegisterDate() {
		return carRegisterDate;
	}
	public void setCarRegisterDate(Date carRegisterDate) {
		this.carRegisterDate = carRegisterDate;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public int getRentalCost() {
		return rentalCost;
	}
	public void setRentalCost(int rentalCost) {
		this.rentalCost = rentalCost;
	}
	@Override
	public String toString() {
		return "CampingCarVO [carID=" + carID + ", carName=" + carName + ", carNum=" + carNum + ", img=" + img
				+ ", carDetails=" + carDetails + ", numOfPassenger=" + numOfPassenger + ", carRegisterDate="
				+ carRegisterDate + ", companyID=" + companyID + ", rentalCost=" + rentalCost + "]";
	}
	
	

}

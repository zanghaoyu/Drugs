package com.medicine.pojo;

import java.io.Serializable;

public class Medicinetype implements Serializable {

	private static final long serialVersionUID = -2057973602820477616L;

	private  String medicineTypeId;//药品类别编号
	
	private  String medicinename;//药品类别名称
	
	public String getMedicineTypeId() {
		return medicineTypeId;
	}
	public void setMedicineTypeId(String medicineTypeId) {
		this.medicineTypeId = medicineTypeId;
	} 
	public String getMedicinename() {
		return medicinename;
	}
	public void setMedicinename(String medicinename) {
		this.medicinename = medicinename;
	}
	
	
}

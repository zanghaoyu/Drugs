package com.medicine.pojo;

import java.io.Serializable;

public class Medicinetype implements Serializable {

	private static final long serialVersionUID = -2057973602820477616L;

	private  String medicineTypeId;//ҩƷ�����
	
	private  String medicineName;//ҩƷ�������
	
	public String getMedicineTypeId() {
		return medicineTypeId;
	}
	public void setMedicineTypeId(String medicineTypeId) {
		this.medicineTypeId = medicineTypeId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	} 
	
	
	
}

package com.medicine.pojo;

import java.io.Serializable;

public class T_Stock implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 610004516615435294L;
	
	//“©∆∑id
	private String medicineId; 
	//ø‚¥Ê¡ø
	private Integer amount;
	
	
	
	public String getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}

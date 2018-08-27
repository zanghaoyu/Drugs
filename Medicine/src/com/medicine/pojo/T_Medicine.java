package com.medicine.pojo;

import java.io.Serializable;

public class T_Medicine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8979624643618575522L;
	//药品编号
	private String medicineId;
	//药品名称
	private String emdicineName;
	//药品单位
	private String unit;
	//药品产地
	private String region;
	//零售价
	private Float retailPrice;
	//药品类别
	private String medicineTypeId;
	
	public String getMedicineId() {
		return medicineId; 
	}
	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}
	public String getEmdicineName() {
		return emdicineName;
	}
	public void setEmdicineName(String emdicineName) {
		this.emdicineName = emdicineName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Float getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(Float retailPrice) {
		this.retailPrice = retailPrice;
	}
	public String getMedicineTypeId() {
		return medicineTypeId;
	}
	public void setMedicineTypeId(String medicineTypeId) {
		this.medicineTypeId = medicineTypeId;
	}
	
}

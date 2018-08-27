package com.medicine.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Purchase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6752996567151540254L;
		
	//购药编号
	private String Purchaseid;
	//药品编号
	private String MedicineId;
	//供应商编号
	private String supplierid;
	//购药日期
	private Date Purchasedate;
	//购药数量
	private int purchaseamout;
	//进价
	private float Purchaseprice;
	
	public String getPurchaseid() {
		return Purchaseid;
	}
	public void setPurchaseid(String purchaseid) {
		Purchaseid = purchaseid;
	}
	public String getMedicineId() {
		return MedicineId;
	}
	public void setMedicineId(String medicineId) {
		MedicineId = medicineId;
	}
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	public Date getPurchasedate() {
		return Purchasedate;
	}
	public void setPurchasedate(Date purchasedate) {
		Purchasedate = purchasedate;
	}
	public int getPurchaseamout() {
		return purchaseamout;
	}
	public void setPurchaseamout(int purchaseamout) {
		this.purchaseamout = purchaseamout;
	}
	public float getPurchaseprice() {
		return Purchaseprice;
	}
	public void setPurchaseprice(float purchaseprice) {
		Purchaseprice = purchaseprice;
	}
	
	
}

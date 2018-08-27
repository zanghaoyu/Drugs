package com.medicine.pojo;

import java.io.Serializable;

public class T_supplier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5517107890783964549L;

	//供应商编号
	private String supplierid;
	//供应商名称
	private String suppliername;
	//供应商地址
	private String Address;
	//供应商电话
	private String Phone;
	
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
}

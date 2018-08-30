package com.medicine.dao;

import java.util.Vector;

import com.medicine.pojo.Medicine;

public interface MedicineDao {
	//查询药品
	public Vector getAllDrug();
	
	//添加药品
	public int addDrug(Medicine medicine);
	
	//根据药品名称查
	public Vector checkDurg(String suppName);
	
	//修改
	public int chargeDrug(Medicine medicine);
	
	//判断是否关联
	public Vector connect(String str);
	
	//查询药品编号，名称，规格，零售价
	public Vector getAllDrugSale();
	
	
}

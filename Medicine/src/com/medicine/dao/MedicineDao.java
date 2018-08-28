package com.medicine.dao;

import java.util.Vector;

import com.medicine.pojo.Medicine;

public interface MedicineDao {
	//查询药品
	public Vector getAllDrug();
	
	//添加药品
	public int addDrug(Medicine medicine);
	
	//根据药品名称查
}

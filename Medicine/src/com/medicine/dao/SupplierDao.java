package com.medicine.dao;

import java.util.List;

import com.medicine.pojo.Supplier;

public interface SupplierDao {
		
	public int addSupplier(Supplier supplier);
	
	public List<String> checkSupplier();
	
	public String getSupplierid();
}

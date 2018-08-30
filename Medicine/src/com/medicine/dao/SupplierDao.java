package com.medicine.dao;

import java.util.List;
import java.util.Vector;

import com.medicine.pojo.Medicine;
import com.medicine.pojo.Supplier;

public interface SupplierDao {
		
	public int addSupplier(Supplier supplier);
	
	
	public List<Supplier> checkSupplier();
	
	//查询所有
	public Vector getAllSupplier();
	
	//查询单独
	public Vector<Supplier>  checkSupplier(String supplierName);
	
	//删除单独
	public int delSupplier(String supName);
	
	//修改
	public int chargeSupplier(Supplier supplier);
	
	//判断是否有主从建的关联
	public Vector connect(String str);
	
	
	
}

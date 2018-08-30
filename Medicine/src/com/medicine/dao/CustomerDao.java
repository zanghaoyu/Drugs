package com.medicine.dao;

import java.util.Vector;

import com.medicine.pojo.Customer;

public interface CustomerDao {
	//添加患者
	public int addCustomer(Customer customer);
	
	//查询患者
	public Vector getAllCustomer();
	
	//根据姓名搜索
	public Vector getCustomerByName(String name);
	
	//删除患者
	public int delCustomer(int customerId);
	
	//修改患者
	public int updateCustomer(Customer customer);
}

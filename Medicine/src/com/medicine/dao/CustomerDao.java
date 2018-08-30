package com.medicine.dao;

import java.util.Vector;

import com.medicine.pojo.Customer;

public interface CustomerDao {
	//��ӻ���
	public int addCustomer(Customer customer);
	
	//��ѯ����
	public Vector getAllCustomer();
	
	//������������
	public Vector getCustomerByName(String name);
	
	//ɾ������
	public int delCustomer(int customerId);
	
	//�޸Ļ���
	public int updateCustomer(Customer customer);
}

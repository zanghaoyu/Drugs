package com.medicine.dao;

import java.util.List;
import java.util.Vector;

import com.medicine.pojo.Medicine;
import com.medicine.pojo.Supplier;

public interface SupplierDao {
		
	public int addSupplier(Supplier supplier);
	
	
	public List<Supplier> checkSupplier();
	
	//��ѯ����
	public Vector getAllSupplier();
	
	//��ѯ����
	public Vector<Supplier>  checkSupplier(String supplierName);
	
	//ɾ������
	public int delSupplier(String supName);
	
	//�޸�
	public int chargeSupplier(Supplier supplier);
	
	//�ж��Ƿ������ӽ��Ĺ���
	public Vector connect(String str);
	
	
	
}

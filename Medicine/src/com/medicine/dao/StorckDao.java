package com.medicine.dao;

import java.util.Vector;

import com.medicine.pojo.Stock;

public interface StorckDao {
	
	//��ѯ����Ӧ��
	public Vector getAllStorck();
	
	//��ӹ�Ӧ��
	public int addStorck(Stock stock);
	
	

}

package com.medicine.dao;

import java.util.Vector;

import com.medicine.pojo.Stock;

public interface StorckDao {
	
	//��ѯ����Ӧ��
	public Vector getAllStorck();
	
	//����ҩƷ���Ʋ�ѯ�����
	public Vector getByStockName(String stockName);
	
	//��ѯ����ҩƷ�Ŀ����
	public Vector getMedicineAmount();
	
	//��ӿ��
	public int addStorck(Stock stock);
	
	//ɾ��
	public int deleStorck(int storckId);
	
	//�޸Ŀ��
	public int updateStorck(Stock stock);
	

}

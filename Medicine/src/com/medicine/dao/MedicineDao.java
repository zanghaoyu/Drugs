package com.medicine.dao;

import java.util.Vector;

import com.medicine.pojo.Medicine;

public interface MedicineDao {
	//��ѯҩƷ
	public Vector getAllDrug();
	
	//���ҩƷ
	public int addDrug(Medicine medicine);
	
	//����ҩƷ���Ʋ�
	public Vector checkDurg(String suppName);
	
	//�޸�
	public int chargeDrug(Medicine medicine);
	
	//�ж��Ƿ����
	public Vector connect(String str);
	
	//��ѯҩƷ��ţ����ƣ�������ۼ�
	public Vector getAllDrugSale();
	
	
}

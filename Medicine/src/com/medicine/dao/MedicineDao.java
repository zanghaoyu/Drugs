package com.medicine.dao;

import java.util.Vector;

import com.medicine.pojo.Medicine;

public interface MedicineDao {
	//��ѯҩƷ
	public Vector getAllDrug();
	
	//���ҩƷ
	public int addDrug(Medicine medicine);
	
	//����ҩƷ���Ʋ�
}

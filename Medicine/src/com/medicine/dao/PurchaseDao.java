package com.medicine.dao;

import com.medicine.pojo.Purchase;

public interface PurchaseDao {
	
	//���ҩƷ
	public int getPurchas(Purchase purchas);
		
	//��ȡid���ֵ
	public String getMaxId(Purchase purchas);
}

package com.medicine.dao;

import com.medicine.pojo.Purchase;

public interface PurchaseDao {
	
	//添加药品
	public int getPurchas(Purchase purchas);
		
	//获取id最大值
	public String getMaxId(Purchase purchas);
}

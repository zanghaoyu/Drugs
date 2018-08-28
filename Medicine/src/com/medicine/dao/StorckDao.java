package com.medicine.dao;

import java.util.Vector;

import com.medicine.pojo.Stock;

public interface StorckDao {
	
	//查询所供应商
	public Vector getAllStorck();
	
	//根据药品名称查询库存量
	public Vector getByStockName(String stockName);
	
	//查询所有药品的库存量
	public Vector getMedicineAmount();
	
	//添加库存
	public int addStorck(Stock stock);
	
	//删除
	public int deleStorck(int storckId);
	
	//修改库存
	public int updateStorck(Stock stock);
	

}

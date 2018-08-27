package com.medicine.dao;

import java.util.Vector;

import com.medicine.pojo.Stock;

public interface StorckDao {
	
	//查询所供应商
	public Vector getAllStorck();
	
	//添加供应商
	public int addStorck(Stock stock);
	
	

}

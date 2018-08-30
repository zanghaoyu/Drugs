package com.medicine.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.function.DoubleUnaryOperator;

import com.medicine.dao.PurchaseDao;
import com.medicine.pojo.Purchase;

import util.DBUTIL;

public class PurchaseDaoImpl implements PurchaseDao {

	@Override
	public int getPurchas(Purchase purchas) {
		String sql="INSERT INTO t_medicine values(?,?,?,?,?,?)";
		return DBUTIL.executeUpdate(sql, purchas.getMedicineId(),purchas.getPurchaseid(),
									purchas.getSupplierid(),purchas.getPurchasedate(),
									purchas.getPurchaseamout(),purchas.getPurchaseprice());
		
		
	}

	@Override
	public String addPurid(Purchase purchas) {
		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql="SELECT MAX(Purchaseid) FROM t_purchase";
		String s=null;
		try {
			conn=DBUTIL.getConn();
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			
			while(rs.next()){
				s=rs.getString("Purchaseid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUTIL.close(conn, pstm , rs);
		}
		return s;
	}

}

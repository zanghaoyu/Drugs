package com.medicine.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.medicine.dao.SupplierDao;

import util.DBUTIL;

public class SupplierDaoImpl implements SupplierDao {

	@Override
	public int addSupplier(com.medicine.pojo.Supplier supplier) {
		
		return 0;
	}

	public List<String> checkSupplier() {
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql="SELECT suppliername FROM t_supplier";
		List<String> list = new ArrayList<>();
		try {
			conn=DBUTIL.getConn();
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				list.add(rs.getString("suppliername"));
				
			}
		} catch (Exception e) {
				e.printStackTrace();
		}finally{
			DBUTIL.close(conn, pstm, rs);
		}
		
		
		return list;
	}

	@Override
	public String getSupplierid() {
		// TODO Auto-generated method stub
		return null;
	}

	

}

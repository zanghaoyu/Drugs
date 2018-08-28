package com.medicine.dao.impl;

import java.sql.Connection;	
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;	

import com.medicine.dao.StorckDao;
import com.medicine.pojo.Stock;

import util.DBUTIL;

public class StorckDaoImpl implements StorckDao {

	@Override
	public Vector getAllStorck() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql="select * from t_storck";
		Vector rowVector = new Vector<>();
		try {
			conn =DBUTIL.getConn();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			Vector v ;
			while(rs.next()){
				v = new Vector<>();
				v.add(rs.getString(1));
				v.add(rs.getInt(2));
				rowVector.add(v);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
		return rowVector;
	}

	@Override
	public int addStorck(Stock stock) {
		String sql ="insert into t_stock values(?,?)";
		int rows = DBUTIL.executeUpdate(sql, stock.getMedicineId(),stock.getAmount());
		return rows;
	}

	@Override
	public int deleStorck(int storckId) {
		String sql = "delete from t_stock where medicineid=?";
		int rows = DBUTIL.executeUpdate(sql, storckId);
		return rows;
	}

	@Override
	public int updateStorck(Stock stock) {
		String sql ="update t_stock set amount=? where medicineid=?";
		int rows = DBUTIL.executeUpdate(sql,stock.getAmount(),stock.getMedicineId());
		return rows;
	}

	@Override
	public Vector getByStockName(String stockName) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		String sql="SELECT t_medicine.MedicineId,t_medicine.Medicinename,t_medicine.unit,t_stock.Amount FROM t_medicine,t_stock WHERE t_medicine.MedicineId=t_stock.MedicineId AND t_medicine.Medicinename=? ";
		Vector rewsVector = new Vector<>();
		try {
			conn = DBUTIL.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, stockName);
			rs = stmt.executeQuery();
			Vector v;
			while(rs.next()){
				v =new Vector<>();
				v.add(rs.getString("medicineId"));
				v.add(rs.getString("Medicinename"));
				v.add(rs.getString("unit"));
				v.add(rs.getInt("Amount"));
				rewsVector.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rewsVector;
	}

	@Override
	public Vector getMedicineAmount() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		//String sql="SET @rowNO=0;SELECT (@rowNo := @rowNo+1) num,t_medicine.MedicineId,t_medicine.Medicinename,t_medicine.unit,t_stock.Amount FROM t_medicine,t_stock WHERE t_medicine.MedicineId=t_stock.MedicineId";
		String sql="SELECT t_medicine.MedicineId,t_medicine.Medicinename,t_medicine.unit,t_stock.Amount FROM t_medicine,t_stock WHERE t_medicine.MedicineId=t_stock.MedicineId";
		Vector rewsVector = new Vector<>();
		try {
			conn = DBUTIL.getConn();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			Vector v;
			while(rs.next()){
				v =new Vector<>();
//				v.add(rs.getString("num"));
				v.add(rs.getString("medicineId"));
				v.add(rs.getString("Medicinename"));
				v.add(rs.getString("unit"));
				v.add(rs.getInt("Amount"));
				rewsVector.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rewsVector;
	}


}

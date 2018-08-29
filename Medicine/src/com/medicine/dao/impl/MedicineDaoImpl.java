package com.medicine.dao.impl;

import java.sql.Connection;	
import java.sql.ResultSet;
import java.util.Vector;

import com.medicine.dao.MedicineDao;
import com.medicine.pojo.Medicine;

import util.DBUTIL;

import java.sql.PreparedStatement;



public class MedicineDaoImpl implements MedicineDao{
	
	//添加药品
	public int addDrug(Medicine medicine) {
		// TODO Auto-generated method stub
	
	String sql="INSERT INTO t_medicine values(?,?,?,?,?,?)";
	
		return DBUTIL.executeUpdate(sql, medicine.getMedicineId(),medicine.getEmdicineName(),medicine.getUnit()
										,medicine.getRegion(),medicine.getRetailPrice(),medicine.getMedicineTypeId()
										);
	}
	
	//查询药品
	public Vector getAllDrug() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql="SELECT m.MedicineId, m.Medicinename, m.unit, m.region, s.suppliername, m.Retailprice ,p.Purchaseprice "
				+ "FROM t_medicine AS m, t_purchase AS p, t_supplier AS s "
				+ "WHERE  m.MedicineId=p.MedicineId "
				+ "AND p.supplierid=s.supplierid";
		Vector vector=new Vector<>();
		
		try {
			conn=DBUTIL.getConn();
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			Vector v;
			while(rs.next()){
				v=new Vector<>();
				v.add(rs.getString("MedicineId"));
				v.add(rs.getString("Medicinename"));
				v.add(rs.getString("unit"));
				v.add(rs.getString("region"));
				v.add(rs.getString("suppliername"));
				v.add(rs.getFloat("Retailprice"));
				v.add(rs.getFloat("Purchaseprice"));
				vector.add(v);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUTIL.close(conn, pstm , rs);
		}
		
		return vector;
	}

	@Override//查询
	public Vector checkDurg(String suppName) {
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql="SELECT m.MedicineId, m.Medicinename, m.unit, m.region, s.suppliername, m.Retailprice ,p.Purchaseprice "
				+ "FROM t_medicine AS m, t_purchase AS p, t_supplier AS s "
				+ " WHERE  m.MedicineId=p.MedicineId "
				+ " AND p.supplierid=s.supplierid"
				+ " AND s.suppliername=?";
		Vector vector=new Vector<>();
		System.out.println(sql);
		try {
			conn=DBUTIL.getConn();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, suppName);
			rs=pstm.executeQuery();
			Vector v;
			while(rs.next()){
				v=new Vector<>();
				v.add(rs.getString("MedicineId"));
				v.add(rs.getString("Medicinename"));
				v.add(rs.getString("unit"));
				v.add(rs.getString("region"));
				v.add(rs.getString("suppliername"));
				v.add(rs.getFloat("Retailprice"));
				v.add(rs.getFloat("Purchaseprice"));
				vector.add(v);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUTIL.close(conn, pstm , rs);
		}
		
		return vector;
	}

	@Override//修改
	public int chargeDrug(Medicine medicine) {
		String sql="UPDATE t_medicine SET Medicinename=? , unit=? , region=? , Retailprice=? "
				+ " WHERE MedicineId = ?";
		return DBUTIL.executeUpdate(sql,medicine.getEmdicineName(),medicine.getUnit(),medicine.getRegion(), medicine.getRetailPrice(),medicine.getMedicineId());
	}

	@Override//判断是否有主从建的关联
	public Vector connect(String str) {
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql="SELECT * FROM t_purchase WHERE MedicineId=?";
		System.out.println(sql);
		System.out.println(str);
		Vector vector=new Vector<>(); 
		try {
			conn=DBUTIL.getConn();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, str);
			rs=pstm.executeQuery();
			Vector v;
			
			while(rs.next()){
				v=new Vector<>();
				v.add(rs.getString("Purchaseid"));
				v.add(rs.getString("MedicineId"));
				v.add(rs.getString("supplierid"));
				v.add(rs.getDate("Purchasedate"));
				v.add(rs.getInt("purchaseamout"));
				v.add(rs.getFloat("Purchaseprice"));
				
				vector.add(v);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUTIL.close(conn, pstm, rs);
		}
		return vector;
		
	}
}

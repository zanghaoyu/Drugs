package com.medicine.dao.impl;

import java.sql.Connection;	
import java.sql.ResultSet;
import java.util.Vector;

import com.medicine.dao.MedicineDao;
import com.medicine.pojo.Medicine;

import util.DBUTIL;

import java.sql.PreparedStatement;



public class MedicineDaoImpl implements MedicineDao{
	
	public int addDrug(Medicine medicine) {
		// TODO Auto-generated method stub
	
	String sql="INSERT INTO t_medicine values(?,?,?,?,?,?)";
	
		return DBUTIL.executeUpdate(sql, medicine.getMedicineId(),medicine.getEmdicineName(),medicine.getUnit()
										,medicine.getRegion(),medicine.getRetailPrice(),medicine.getMedicineTypeId()
										);
	}
		
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

}

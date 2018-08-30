package com.medicine.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.function.DoubleUnaryOperator;

import com.medicine.dao.SupplierDao;
import com.medicine.pojo.Supplier;

import util.DBUTIL;

public class SupplierDaoImpl implements SupplierDao {

	@Override
	public int addSupplier(Supplier supplier) {
		String sql="INSERT INTO t_supplier values(?,?,?,?)";
		return DBUTIL.executeUpdate(sql, supplier.getSupplierid(),supplier.getSuppliername(),
									supplier.getAddress(),supplier.getPhone());
	}
	@Override
	public List<Supplier> checkSupplier() {
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql="SELECT supplierid,suppliername FROM t_supplier";
		List<Supplier> list = new ArrayList<>();
		try {
			conn=DBUTIL.getConn();
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				Supplier s = new Supplier();
				s.setSupplierid(rs.getString("supplierid"));
				s.setSuppliername(rs.getString("suppliername"));
				list.add(s);
				
			}
		} catch (Exception e) {
				e.printStackTrace();
		}finally{
			DBUTIL.close(conn, pstm, rs);
		}
		return list;
		

	}

	@Override//显示全部
	public Vector getAllSupplier() {
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql="SELECT * FROM t_supplier";
		
		Vector vector=new Vector<>();
		
		try {
			conn=DBUTIL.getConn();
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			Vector v;
			
			while(rs.next()){
				v=new Vector<>();
				v.add(rs.getString("supplierid"));
				v.add(rs.getString("suppliername"));
				v.add(rs.getString("address"));
				v.add(rs.getString("phone"));
				vector.add(v);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUTIL.close(conn, pstm, rs);
		}
		return vector;
	}

	@Override//查询
	public Vector checkSupplier(String supplierName) {
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql="SELECT * FROM t_supplier WHERE suppliername='"+supplierName+"'";
		Vector vector=new Vector<>();
		
		try {
			conn=DBUTIL.getConn();
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			Vector v;
			
			while(rs.next()){
				v=new Vector<>();
				v.add(rs.getString("supplierid"));
				v.add(rs.getString("suppliername"));
				v.add(rs.getString("address"));
				v.add(rs.getString("phone"));
				vector.add(v);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUTIL.close(conn, pstm, rs);
		}
		return vector;
	}

	@Override//删除某个供应商
	public int delSupplier(String id) {
		String sql="DELETE FROM t_supplier WHERE supplierid=?";
		return DBUTIL.executeUpdate(sql, id);
	}
	
	@Override//修改
	public int chargeSupplier(Supplier supplier) {
		String sql="UPDATE t_supplier SET suppliername=? , Address=? , Phone=? 	WHERE supplierid=?";
		return DBUTIL.executeUpdate(sql ,supplier.getSuppliername(),supplier.getAddress(),supplier.getPhone() , supplier.getSupplierid());
	}
	@Override//确定是否关联
	public Vector connect(String str) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql="SELECT * FROM t_purchase WHERE supplierid=?";
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

package com.medicine.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.medicine.dao.CustomerDao;
import com.medicine.pojo.Customer;

import util.DBUTIL;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public int addCustomer(Customer customer) {
		String sql ="insert into t_customer values(?,?,?,?,?,?)";
		int rows = DBUTIL.executeUpdate(sql, customer.getCustomerId(),customer.getCustomerName()
				,customer.getAge(),customer.getPhone(),customer.getCardId(),customer.getAddress());
		return rows;
	}

	@Override
	public Vector getAllCustomer() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql="select * from t_customer";
		Vector rowVector = new Vector<>();
		try {
			conn =DBUTIL.getConn();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			Vector v ;
			while(rs.next()){
				v = new Vector<>();
				v.add(rs.getString(1));
				v.add(rs.getString(2));
				v.add(rs.getInt(3));
				v.add(rs.getString(4));
				v.add(rs.getString(5));
				v.add(rs.getString(6));
				rowVector.add(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rowVector;
	}

	@Override
	public Vector getCustomerByName(String name) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		String sql = "SELECT * FROM t_customer "
				+ "WHERE t_customer.customername LIKE \"%\"?\"%\" ";
		Vector rewsVector = new Vector<>();
		try {
			conn = DBUTIL.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			Vector v;
			while(rs.next()){
				v =new Vector<>();
				v.add(rs.getString("customerId"));
				v.add(rs.getString("customerName"));
				v.add(rs.getInt("age"));
				v.add(rs.getString("phone"));
				v.add(rs.getString("cardId"));
				v.add(rs.getString("address"));
				rewsVector.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rewsVector;
	}

	@Override
	public int delCustomer(int customerId) {
		String sql = "delete from t_customer where customerid=?";
		int rows = DBUTIL.executeUpdate(sql, customerId);
		return rows;
	}

	@Override
	public int updateCustomer(Customer customer) {
		String sql ="UPDATE t_customer SET "
				+ "customername=? , Age=? ,phone=? ,cardid=? ,"
				+ "address=? WHERE customerid=?";
		int rows = DBUTIL.executeUpdate(sql,customer.getCustomerName(),customer.getAge(),customer.getPhone(),customer.getCardId(),customer.getAddress(),customer.getCustomerId());
		return rows;
	}

	@Override
	public Vector getCustomerSele() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql="SELECT customerid,customername,cardId "
				+ "FROM t_customer";
		Vector rowVector = new Vector<>();
		try {
			conn =DBUTIL.getConn();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			Vector v ;
			while(rs.next()){
				v = new Vector<>();
				v.add(rs.getString(1));
				v.add(rs.getString(2));
				v.add(rs.getString(3));
				rowVector.add(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rowVector;
	}

}

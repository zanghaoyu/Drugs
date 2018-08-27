package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUTIL {
	
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String URL="jdbc:mysql://localhost:3306/yao";
	private static String USERNAME="root";
	private static String PASSWORD="1234";
	
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//连接数据库
	public static Connection getConn() throws SQLException {
		
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
	
	//关闭数据库
	public static void close(Connection conn,Statement state){
		if(state!=null && conn!=null){
			try {
				state.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void close(Connection conn,Statement state,ResultSet rs){
		if(rs!=null && state!=null && conn!=null){
			try {
				rs.close();
				state.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//通用增删改操作代码
	public static int executeUpdate(String sql,Object ...params){
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = getConn();
			pstm = conn.prepareStatement(sql);
			if(pstm!=null){
				for (int i = 0; i < params.length; i++) {
					pstm.setObject(i+1, params[i]);
				}
			}
			return pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(conn, pstm);
		}
		return 0;
	}

}

package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPhoneNumber {
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/phan2bai1";
			String user = "root";
			String password = "1998";
			return DriverManager.getConnection(url, user, password);
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public  void insertPhoneNumber(String phoneNumber) {
		String query = "insert into msisdn(msisdn) value(?)";
		Connection conn = null;
		PreparedStatement ptmt = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			ptmt = conn.prepareStatement(query);
			if(conn != null) {
				ptmt.setObject(1, phoneNumber);
			}
			ptmt.execute();
			//neu thanh cong
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if(conn != null) {
				 try {
					conn.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			if(ptmt != null ) { 
				try {
					ptmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void insert100Line(String sql) {
		
		Connection conn = null;
		PreparedStatement ptmt = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			ptmt = conn.prepareStatement(sql);
			
			ptmt.execute();
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if(conn != null) {
				 try {
					conn.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			if(ptmt != null ) { 
				try {
					ptmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	

}

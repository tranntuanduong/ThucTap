package com.jun.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.jun.model.PhoneNumber;
import com.jun.repository.IPhoneNumberRepository;

public class PhoneNumberRepositoryImpl implements IPhoneNumberRepository {
	
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/p2bai1";
			String user = "root";
			String password = "1998";
			return DriverManager.getConnection(url, user, password);
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	public void closeConnection(Connection conn, PreparedStatement ptmt, ResultSet resultSet) {
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
				e.printStackTrace();
			}
		}
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Long save(PhoneNumber phoneNumber) {
		String query = "insert into phoneNumber(phoneNumber) value(?)";
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet resultSet = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			ptmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			if(conn != null) {
				ptmt.setObject(1, phoneNumber);
			}
			int rowInserted = ptmt.executeUpdate();
			resultSet = ptmt.getGeneratedKeys();
			conn.commit();
			
			if(rowInserted!=0) {
				if(resultSet.next()) {
					Long id = resultSet.getLong(1);
					return id;
				}
			}
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			closeConnection(conn, ptmt, resultSet);
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhoneNumber findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhoneNumber> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

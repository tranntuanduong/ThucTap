package com.jun.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.jun.dao.GenericDAO;
import com.jun.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {

	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

	private static final Logger log = Logger.getLogger(BusinessTypeDAOImpl.class);

	public synchronized Connection getConnection() {
		try {
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public synchronized Long save(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement ptmt = null;
		ResultSet resultSet = null;
		try {
			Long id = null;
			connection = getConnection();
			connection.setAutoCommit(false);
			ptmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < parameters.length; i++) {
				int index = i + 1;
				ptmt.setObject(index, parameters[i]);
			}
			ptmt.executeUpdate();
			resultSet = ptmt.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			log.info(e.getMessage());
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					log.info(e1.getMessage());
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (ptmt != null) {
					ptmt.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				log.info(e2.getMessage());
			}
		}
		return null;
	}

	@Override
	public synchronized <T> List<T> findByProperty(String sql, RowMapper<T> rowMapper, Object param) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement ptmt = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			if (param != null) {
				ptmt.setObject(1, param);
			}
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (SQLException e) {
			log.info(e.getMessage());
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (ptmt != null) {
					ptmt.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				log.info(e.getMessage());
				return null;
			}
		}
	}

}

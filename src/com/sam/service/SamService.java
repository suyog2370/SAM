package com.sam.service;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dbmanager.connection.setting.AbstractConnectionSettings;
import com.sam.tables.User;
import com.sam.util.ConnectionUtils;

public class SamService {
	private static final Logger LOG = LoggerFactory.getLogger(SamService.class);
	private AbstractConnectionSettings connectionSettings;

	public SamService() throws IOException {
		connectionSettings = ConnectionUtils.getConnectionSettings();
	}

	public void register(User user) throws ClassNotFoundException, SQLException {
		connectionSettings.build();
		String query = "insert into user(name,email,mobile_no) values (?,?,?)";
		PreparedStatement prepareStatement = connectionSettings.getConnection().prepareStatement(query);
		prepareStatement.setString(1, user.getName());
		prepareStatement.setString(2, user.getEmail());
		prepareStatement.setLong(3, user.getMobileNo());
		prepareStatement.executeUpdate();
		connectionSettings.closeConnection();
	}

	public User getUserByMobileNo(long mobileNo) throws ClassNotFoundException, SQLException {
		connectionSettings.build();
		String query = "select * from user where mobile_no=?";
		PreparedStatement prepareStatement = connectionSettings.getConnection().prepareStatement(query);
		prepareStatement.setLong(1, mobileNo);
		ResultSet resultSet = prepareStatement.executeQuery();
		User user = null;
		if (resultSet.next()) {
			user = new User();
			user.setName(resultSet.getString("name"));
			user.setMobileNo(resultSet.getLong("mobile_no"));
			user.setEmail(resultSet.getString("email"));
		}
		connectionSettings.closeConnection();
		return user;
	}

	public User getUserByEmail(String email) throws ClassNotFoundException, SQLException {
		connectionSettings.build();
		String query = "select * from user where email=?";
		PreparedStatement prepareStatement = connectionSettings.getConnection().prepareStatement(query);
		prepareStatement.setString(1, email);
		ResultSet resultSet = prepareStatement.executeQuery();
		User user = null;
		if (resultSet.next()) {
			user = new User();
			user.setName(resultSet.getString("name"));
			user.setMobileNo(resultSet.getLong("mobile_no"));
			user.setEmail(resultSet.getString("email"));
		}
		connectionSettings.closeConnection();
		return user;
	}

	public boolean checkUserExist(User user) throws ClassNotFoundException, SQLException {
		User userByMobileNo = getUserByMobileNo(user.getMobileNo());
		if (userByMobileNo != null) {
			return false;
		}
		User userByEmail = getUserByEmail(user.getEmail());
		if (userByEmail != null) {
			return false;
		}
		return true;
	}
}

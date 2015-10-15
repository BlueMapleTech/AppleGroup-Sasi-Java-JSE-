package com.bluemaple.userdetails.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bluemaple.userdetails.model.User;
import com.bluemaple.userdetails.service.UserService;

public class UserDao {
	Connection connection;
	PreparedStatement p;
	ResultSet rs;

	UserService userService;

	public void saveUser(User userModel) throws ClassNotFoundException,
			SQLException {

		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://LocalHost:3306/student";

		Class.forName(JDBC_DRIVER);
		Connection connection = DriverManager.getConnection(DB_URL, "root",
				"admin");
		p = connection
				.prepareStatement("insert into altered values(?,?,?,?,?,?,?,?)");
		p.setInt(1, userModel.getId());
		p.setString(2, userModel.getName());
		p.setString(3, userModel.getPassword());
		p.setString(4, userModel.getEmailAddress());
		p.setString(5, userModel.getSex());
		p.setString(6, userModel.getContact());
		p.setString(7, userModel.getCreatedDate());
		p.setString(8, userModel.getUpdatedDate());
		int i = p.executeUpdate();
		if (i == 1) {
			System.out.println("inserted");
		}

	}

	public List<User> retriveUser() throws SQLException {
		List<User> list = new ArrayList<User>();
		//String details = "select id, name, password, email, sex, contact, createdate, updatedate from altered";
		PreparedStatement listOfUsers = connection.prepareStatement("select id, name, password, email, sex, contact, createdate, updatedate from altered where id=1");
		ResultSet count = listOfUsers.executeQuery();


			User user1 = new User();
			user1.setId(count.getInt(1));
			user1.setName(count.getString(2));
			user1.setPassword(count.getString(3));
			user1.setEmailAddress(count.getString(4));
			user1.setSex(count.getString(5));
			user1.setContact(count.getString(6));
			user1.setCreatedDate(count.getString(7));
			user1.setUpdatedDate(count.getString(8));
			list.add(user1);
		
		return list;
	}
}

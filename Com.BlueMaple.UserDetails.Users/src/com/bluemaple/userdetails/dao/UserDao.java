package com.bluemaple.userdetails.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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

	public List<User> retriveUser() throws SQLException, ClassNotFoundException {
		System.out.println("Retrived user has been called");
		List<User> list = new ArrayList<User>();

		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://LocalHost:3306/student";

		Class.forName(JDBC_DRIVER);
		Connection connection = DriverManager.getConnection(DB_URL, "root",
				"admin");
		String details = "select id, name, password, email, sex, contact, createdate, updatedate from altered";
		PreparedStatement listOfUsers = connection.prepareStatement(details);
		ResultSet count = listOfUsers.executeQuery();
		while (count.next()) {
			User user1 = new User();
			user1.setId(count.getInt("id"));
			user1.setName(count.getString("name"));
			user1.setPassword(count.getString("password"));
			user1.setEmailAddress(count.getString("email"));
			user1.setSex(count.getString("sex"));
			user1.setContact(count.getString("contact"));
			user1.setCreatedDate(count.getString("createdate"));
			user1.setUpdatedDate(count.getString("updatedate"));
			list.add(user1);
		}
		return list;
	}

	public List<User> loginDetails() throws SQLException,
			ClassNotFoundException {
		List<User> loginUserList = new ArrayList<>();

		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://LocalHost:3306/student";

		Class.forName(JDBC_DRIVER);
		Connection connection = DriverManager.getConnection(DB_URL, "root",
				"admin");
		String loginDetails = "select * from altered";
		PreparedStatement loginUsers = connection
				.prepareStatement(loginDetails);
		ResultSet count1 = loginUsers.executeQuery();

		while (count1.next()) {
			User user2 = new User();
			user2.setName(count1.getString("name"));
			user2.setPassword(count1.getString("password"));
			loginUserList.add(user2);
		}
		return loginUserList;

	}

	public int updateUser(User user0) throws SQLException,
			ClassNotFoundException {

		// User user0 = new User();

		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://LocalHost:3306/student";

		Class.forName(JDBC_DRIVER);
		Connection connection = DriverManager.getConnection(DB_URL, "root",
				"admin");

		/*
		 * System.out.println("Enter ID : "); Scanner get = new
		 * Scanner(System.in); int id11 = get.nextInt();
		 * 
		 * /*System.out.println("Enter name : "); Scanner get1 = new
		 * Scanner(System.in); String uName = get1.nextLine();
		 */

		/*
		 * System.out.println("Enter passWord : "); Scanner get2 = new
		 * Scanner(System.in); String pWord = get2.nextLine();
		 * 
		 * System.out.println("Enter emailAddress : "); Scanner get3 = new
		 * Scanner(System.in); String eAddress = get3.nextLine();
		 * 
		 * System.out.println("Enter sex : "); Scanner get4 = new
		 * Scanner(System.in); String sex = get4.nextLine();
		 * 
		 * System.out.println("Enter contact : "); Scanner get5 = new
		 * Scanner(System.in); String contact = get5.nextLine();
		 */

		/*
		 * System.out.println("Enter contact : "); Scanner get6 = new
		 * Scanner(System.in); String cdate = get6.nextLine();
		 * 
		 * System.out.println("Enter contact : "); Scanner get7 = new
		 * Scanner(System.in); String udate = get7.nextLine();
		 */

		// String update =
		// "update altered set name = ?,password=?,email=?,sex=?,contact=?,createdatd='"+day+"',updatedate='"+day+"'  where id =?";
		Date date = new Date();
		String day = date.toString();

		String update = "update altered set name =password='"
				+ user0.getPassword() + "',email='" + user0.getEmailAddress()
				+ "',sex='" + user0.getSex() + "',contact='"
				+ user0.getContact() + "',createdate='" + day
				+ "',updatedate='" + day + "'  where id =" + user0.getId();

		p = connection.prepareStatement(update);
		int count2 = p.executeUpdate();

		return count2;

	}

	public void deleteUser(User userDelete) throws ClassNotFoundException,
			SQLException {

		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://LocalHost:3306/student";

		Class.forName(JDBC_DRIVER);
		Connection connection = DriverManager.getConnection(DB_URL, "root",
				"admin");
		String loginDetails = "delete  from altered where name='"
				+ userDelete.getName() + "'";
		PreparedStatement loginUsers = connection
				.prepareStatement(loginDetails);
		int count1 = loginUsers.executeUpdate();

	}
}

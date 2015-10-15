package com.bluemaple.userdetails.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.bluemaple.userdetails.dao.UserDao;
import com.bluemaple.userdetails.model.User;
import com.bluemaple.userdetails.service.UserService;

public class UserController {

	static UserService userService = new UserService();
	UserDao userDao;

	public static void main(String arg[]) throws ClassNotFoundException,
			SQLException {

		System.out.println("Enter choice:");
		System.out.println("menu");
		System.out.println("1.login:");
		System.out.println("2.signup:");
		System.out.println("3.list of users");
		System.out.println("4.exit");

		Scanner selectOption = new Scanner(System.in);
		int option = selectOption.nextInt();

		switch (option) {
		case 1:
			System.out.println("Login :");
			System.out.println();
		case 2: {

			Date date = new Date();
			String day = date.toString();

			/*
			 * System.out.println("Enter ID : "); Scanner get = new
			 * Scanner(System.in); int id11 = get.nextInt();
			 */

			System.out.println("Enter name : ");
			Scanner get1 = new Scanner(System.in);
			String uName = get1.nextLine();

			System.out.println("Enter passWord : ");
			Scanner get2 = new Scanner(System.in);
			String pWord = get2.nextLine();

			System.out.println("Enter emailAddress : ");
			Scanner get3 = new Scanner(System.in);
			String eAddress = get3.nextLine();

			System.out.println("Enter sex : ");
			Scanner get4 = new Scanner(System.in);
			String sex = get4.nextLine();

			System.out.println("Enter contact : ");
			Scanner get5 = new Scanner(System.in);
			String contact = get5.nextLine();

			User userModel = new User();
			// userModel.setId(id11);
			userModel.setName(uName);
			userModel.setPassword(pWord);
			userModel.setEmailAddress(eAddress);
			userModel.setSex(sex);
			userModel.setContact(contact);
			userModel.setCreatedDate(day);
			userModel.setUpdatedDate(day);

			userService.addDetails(userModel);
			break;
		}
		case 3: {
			System.out.println("The List of users are:");
			userService.retrive();
			List<User> user = userService.retrive();
			System.out.println("User deatils:" + user.toString());
			break;
		}
		}
	}
}

/*
 * Date date = new Date(); String day = date.toString();
 * 
 * User userModel = new User(); userModel.setId(9); userModel.setName("sasi");
 * userModel.setPassword("12345"); userModel.setEmailAddress("sasi@gmail.com");
 * userModel.setContact("9876543211"); userModel.setCreatedDate(day);
 * userModel.setUpdatedDate(day);
 * 
 * userService.addDetails(userModel);
 * 
 * }
 * 
 * public List<User> receiveDbdata(ResultSet count) throws SQLException { //
 * List<User> user = userService.sendRetrievedData(count); int s =
 * count.getInt("id"); String name = count.getString("name"); String password =
 * count.getString("password"); String email = count.getString("email"); String
 * sex = count.getString("sex"); String contact = count.getString("contact");
 * String createdate = count.getString("createdate"); String updatedate =
 * count.getString("updatedate");
 * 
 * System.out.println("List of users:" + s + " " + name + " " + password + " " +
 * email + " " + sex + " " + contact + " " + createdate + " " + updatedate);
 * 
 * return receiveDbdata(count);
 * 
 * }
 * 
 * public void getDetailsOfUser() throws SQLException { List<User> user =
 * userService.retrive(); System.out.println("User deatils:" + user.toString());
 * 
 * } }
 */

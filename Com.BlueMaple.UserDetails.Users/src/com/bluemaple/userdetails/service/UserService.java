package com.bluemaple.userdetails.service;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bluemaple.userdetails.controller.UserController;
import com.bluemaple.userdetails.dao.UserDao;
import com.bluemaple.userdetails.model.User;

public class UserService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDao();
	UserController userController = new UserController();

	public void addDetails(User userModel) throws ClassNotFoundException,
			SQLException {

		userDao.saveUser(userModel);
	}

	/*
	 * public List<User> sendRetrievedData(ResultSet count) throws SQLException
	 * {
	 * 
	 * return userDao.retriveUser(); }
	 */

	public List<User> retrive() throws SQLException, ClassNotFoundException {
		userDao.retriveUser();
		// List<User> dbDatas = userDao.retriveUser();
		return userDao.retriveUser();
	}

	public List<User> login() throws SQLException, ClassNotFoundException {
		// userDao.loginDetails();
		List<User> loginNames = userDao.loginDetails();
		return loginNames;
	}

	public int update(User user0) throws SQLException, ClassNotFoundException {
		// userDao.updateUser(user0);
		int number = userDao.updateUser(user0);
		return number;

	}

	public void delete(User userDelete) throws ClassNotFoundException,
			SQLException {
		userDao.deleteUser(userDelete);
	}

}

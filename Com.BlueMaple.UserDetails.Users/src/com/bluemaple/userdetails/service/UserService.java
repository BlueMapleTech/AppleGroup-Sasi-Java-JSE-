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

	public List<User> retrive() throws SQLException {
		//List<User> dbDatas = userDao.retriveUser();
		return userDao.retriveUser();
	}

}

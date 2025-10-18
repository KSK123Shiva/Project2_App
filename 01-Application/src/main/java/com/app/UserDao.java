package com.app;

public class UserDao {

	public String getUserNameById(Integer id) {

		if (id == 100) {
			return "Shiva";
		} else if (id == 101) {
			return "kumar";
		} else {
			return null;
		}

	}

}
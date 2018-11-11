package com.proj1.login;

import java.util.List;

public class LoginBO {
	LoginDAO loginDAO = null;
	User user = null;
	public int registerUser(String name, String email) {
		
		loginDAO = new LoginDAO();
		user = new User();
		int i =0;
		user.setName(name);
		user.setEmail(email);
		
		i = loginDAO.saveUser(user);
		
		return i;
		
	}
	public List<User> getUserList() {
		
		loginDAO = new LoginDAO();
		return loginDAO.getUserList();
		
	}
}

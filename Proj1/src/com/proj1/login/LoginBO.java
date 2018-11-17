package com.proj1.login;

import java.util.List;

public class LoginBO {
	LoginDAO loginDAO = null;
	User user = null;
	public int registerUser(String name, String email) {
		System.out.println(""+email);
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
	public int updateUser(String id, String name, String email) {
		
		loginDAO = new LoginDAO();
		user = new User();
		int i =0;
		user.setId(Integer.parseInt(id));
		user.setName(name);
		user.setEmail(email);
		
		i = loginDAO.updateUser(user);
		
		return i;
		
	}
}

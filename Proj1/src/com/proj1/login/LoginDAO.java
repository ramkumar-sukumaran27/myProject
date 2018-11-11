package com.proj1.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Driver;


public class LoginDAO {
	private Log log = LogFactory.getLog(LoginDAO.class);
	public Connection getConnection() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Welcome@123");
			return con;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
		
	}
	
	public int saveUser(User user) {
		
		LoginDAO conObj = new LoginDAO();
		Connection con = conObj.getConnection();
		int i =0;
		try {
			
			log.info(" user name :: " + user.getName());
			log.info(" user email :: " + user.getEmail());
			PreparedStatement statement = con.prepareStatement("insert into user(name,email) values(?,?)");
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			
			 i = statement.executeUpdate();
			con.close();
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
	
	public List<User> getUserList(){
		
		LoginDAO conObj = new LoginDAO();
		Connection con = conObj.getConnection();
		List<User> usrList = new ArrayList<User>();
		int i =1;
		try {
			
			PreparedStatement statement = con.prepareStatement("select id,name,email from user;");
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				User usr = new User();
				usr.setId(rs.getInt("id"));
				usr.setName(rs.getString("name"));
				usr.setEmail(rs.getString("email"));
				System.out.println(rs.getString("email"));
				usrList.add(usr);
				i++;
			}
			return usrList;
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

}

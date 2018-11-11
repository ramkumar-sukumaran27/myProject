package com.proj1.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		LoginBO loginBO = new LoginBO();
		List<User> usrList = loginBO.getUserList();
		request.getSession().setAttribute("usrList", usrList);
		
		usrList.forEach(u -> System.out.println(u.getName()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		LoginBO loginBO = new LoginBO();
		int i =0;
		String id = request.getParameter("id");
		if(id==null) {
		String uname = request.getParameter("name");
		i = loginBO.registerUser(request.getParameter("name"), request.getParameter("email"));
		response.getWriter().append(i + " record saved Successfully.." + System.lineSeparator());
		response.getWriter().append("Welcome " + uname);
		}else {
			i = loginBO.updateUser(request.getParameter("id"),request.getParameter("name"), request.getParameter("email"));
			response.getWriter().append(i + " record updated Successfully.." + System.lineSeparator());
			
		}
	}

}

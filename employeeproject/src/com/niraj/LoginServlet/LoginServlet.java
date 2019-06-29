package com.niraj.LoginServlet;

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
			String Username=request.getParameter("uname");
			String Password=request.getParameter("pwd");
			

	        String url = "jdbc:mysql://localhost:3306/sdc";
	        String user = "root";
	        String pwd1 = "niraj";
	        try
	        {
			PrintWriter out=response.getWriter();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pwd1);
            String sql = "Select * from login where username=? and password=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, Username);
            st.setString(2, Password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) 
            {
                String a = rs.getString("username");
                String b = rs.getString("password");
                if (Username.equals(a) && Password.equals(b))
                {
			//if(un.equals("niraj")&& pwd.equals("rokka"))
			//{
				HttpSession session=request.getSession();
				session.setAttribute("suname",Username);
				RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
			    rd.forward(request,response);	
			}
            	}
				out.println("Login Failed");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			    rd.include(request,response);
			    out.close();
	}
	        catch (Exception ex) {
	            System.out.println(ex);
	        }

}
}

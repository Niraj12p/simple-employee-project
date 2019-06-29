package org.niraj.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.niraj.modal.Employee;
import org.niraj.service.EmployeeService;
import org.niraj.service.EmployeeServiceImpl;
@WebServlet("/EmployeeServlet1")
public class EmployeeServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService empService=new EmployeeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String theCommand=request.getParameter("command");
		 if(theCommand==null)
		 {
			 theCommand="List";
		 }
		 
		 
			 switch(theCommand)
			 {
			 case "List":
				 doList(request,response);
				 break;
			 case "ADD":
				 doAdd(request,response);
				 break;
			 case "LOAD":
				 doLoad(request,response);
				 break;
			 case "Update":
				 doUpdate(request,response);
				 break;
			  case "Delete":
				 doDelete(request,response);
				 break;
			  case "SEARCH":
			   searchStudents(request, response);
			   break;
			  case "addlogin":
				  addLogin(request, response);
			 }
		 
	
	}
	protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
	         String fn=request.getParameter("firstName");
	 		String ln=request.getParameter("lastName");  
	 		Double s= Double.parseDouble(request.getParameter("salary")); 
	 		Integer a=Integer.parseInt(request.getParameter("age"));
	 		String em=request.getParameter("email");	  
		Employee e=new Employee();
		e.setFirstName(fn);
		e.setLastName(ln);
		e.setSalary(s);
		e.setAge(a);
		e.setEmail(em);
		empService.saveEmployee(e);
		doList(request,response);

	}
	protected void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	    EmployeeService es=new EmployeeServiceImpl();
	     List<Employee> employeeList=es.allEmployees();
	     request.setAttribute("employeeList",employeeList);
		 RequestDispatcher dispatcher=request.getRequestDispatcher("list.jsp");
		    dispatcher.forward(request,response);
	}
		
		    protected void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    	PrintWriter out=response.getWriter();
				Integer id=Integer.parseInt(request.getParameter("eId"));
		         String fn=request.getParameter("firstName");
		 		String ln=request.getParameter("lastName");
		 		Double s= Double.parseDouble(request.getParameter("salary"));
		 		Integer a=Integer.parseInt(request.getParameter("age"));
		 		String em=request.getParameter("email");	  
			Employee e=new Employee();
			e.setId(id);
			e.setFirstName(fn);
			e.setLastName(ln);
			e.setSalary(s);
			e.setAge(a);
			e.setEmail(em);
			empService.updateEmployee(e);
			doList(request,response);
			
			}
		    protected void doLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		    	PrintWriter out=response.getWriter();
				int theEmployeId =Integer.parseInt(request.getParameter("employeeId"));
				Employee e=empService.employeeById(theEmployeId);
				request.setAttribute("hawa",e);
			 RequestDispatcher dispatcher=request.getRequestDispatcher("edit.jsp");   
			    dispatcher.forward(request,response);

		}
		    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				int theEmployeId1 =Integer.parseInt(request.getParameter("employeeId"));
				empService.deleteEmployee(theEmployeId1);
				doList(request,response);
}
		    protected void searchStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		        String theSearchName = request.getParameter("theSearchName");
		        List<Employee> s = 	empService.searchStudents(theSearchName);
		        request.setAttribute("employeeList", s);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		        dispatcher.forward(request, response);	
		        
		    
}
		    protected void addLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				  response.setContentType("text/html");
					String Username=request.getParameter("username");
					String Password=request.getParameter("password");
			        String url = "jdbc:mysql://localhost:3306/sdc";
			        String user = "root";
			        String pwd1 = "niraj";
			        try
			        {
					PrintWriter out=response.getWriter();
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection con = DriverManager.getConnection(url, user, pwd1);
		            String sql = "insert into login  (username,password)values(?,?)";
		            PreparedStatement st=con.prepareStatement(sql);
		            st.setString(1,Username);
		            st.setString(2,Password);
		            st.execute();
		            out.println("save to login database");
		            con.close();
		    }
			        catch(Exception ex)
			        {
			        	System.out.println(ex);
			        }
}
}


	
	



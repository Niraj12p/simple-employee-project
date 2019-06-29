package org.niraj.service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.niraj.modal.Employee;
import org.niraj.util.*;
public class EmployeeServiceImpl implements EmployeeService {
	@Override
	public void saveEmployee(Employee emp) 
	{
		try {
			Connection con=DbConnection.getDbConnection();
			String sql="INSERT INTO employee(firstName, lastName,salary,age,email) VALUES (?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4, emp.getAge());
			ps.setString(5, emp.getEmail());
			int i=ps.executeUpdate();
			System.out.println("Data Inserted Successfully With Id..."+i);	
		}
		catch(Exception ex)
		{
			System.out.println();
		}
}

	 public List<Employee> allEmployees(){
			List<Employee> empList=new ArrayList<Employee>();
			try{
			Connection con=DbConnection.getDbConnection();
			String sql="SELECT * FROM employee";  
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery(); 
			while(rs.next()){	
			Employee e=new Employee();
			e.setId(rs.getInt("id"));

			e.setFirstName(rs.getString("firstName"));
			e.setLastName(rs.getString("lastName"));
			e.setSalary(rs.getDouble("salary"));
			e.setAge(rs.getInt("age"));
			e.setEmail(rs.getString("email"));
			empList.add(e);	
		 } 	
	 }catch(Exception ex) {
		System.out.println(ex);
		}
	
	 return empList;

}
	 public void deleteEmployee(Integer id) {
			
			try {
				Connection con=DbConnection.getDbConnection();        
				String sql="DELETE FROM employee WHERE id=?";
				PreparedStatement ps=con.prepareStatement(sql);     
				ps.setInt(1, id);             
				ps.executeUpdate();         
				System.out.println("Data Deleted Successfully of id::"+id);    
				
			}catch(Exception ex) {
				System.out.println(ex);
			}
	
}
	 public Employee employeeById(Integer id) {
			Employee e=null;
			try {
			Connection con=DbConnection.getDbConnection();
			String sql="SELECT *FROM employee WHERE id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				e=new Employee();
				e.setId(rs.getInt("id"));
				e.setFirstName(rs.getString("firstName"));
				e.setLastName(rs.getString("lastName"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
				e.setEmail(rs.getString("email"));
			}
					
			}catch(Exception ex) {
				System.out.println(ex);
			}
			return e;
			
	}

		public void updateEmployee(Employee emp)
		{
			
			try{
				Connection con=DbConnection.getDbConnection();
				String sql="UPDATE employee SET firstName=?,lastName=?,salary=?,age=?,email=? WHERE id=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, emp.getFirstName());
				ps.setString(2, emp.getLastName());
				ps.setDouble(3, emp.getSalary());
				ps.setInt(4, emp.getAge());
				ps.setString(5, emp.getEmail());
				ps.setInt(6, emp.getId());
				
				int id=ps.executeUpdate();
				
				System.out.println(id+"...UpdatedId.."+emp.getId());
				
			}
			catch(Exception ex) {
	    		System.out.println(ex);
	    		}
		}
		
		
		 public List<Employee> searchStudents(String theSearchName)
		 {
 			PreparedStatement ps=null;
			 List<Employee> empList=new ArrayList<Employee>();
				try
				{
					Connection con=DbConnection.getDbConnection();
	            if (theSearchName != null && theSearchName.trim().length() > 0) 
	            {
	                String sql = "select * from employee where lower(firstName) like ? or lower(lastName) like ?";
	                
	            	//String sql = "select * from employee where firstName = ?";
	            	
	                 ps = con.prepareStatement(sql);
	               // ps.setString(1, theSearchName);
	                String theSearchNameLike = "%" + theSearchName.toLowerCase() + "%";
	                ps.setString(1, theSearchNameLike);
	                ps.setString(2, theSearchNameLike);
	                
	                
	    		
	            } 
	            else {
	    			
	    			String sql="SELECT * FROM employee";  
	    			ps=con.prepareStatement(sql);
	            }
	            
	    			ResultSet rs=ps.executeQuery(); 
	    			while(rs.next())
	    			{	
	    			Employee e=new Employee();
	    			e.setId(rs.getInt("id"));
	    			e.setFirstName(rs.getString("firstName"));
	    			e.setLastName(rs.getString("lastName"));
	    			e.setSalary(rs.getDouble("salary"));
	    			e.setAge(rs.getInt("age"));
	    			e.setEmail(rs.getString("email"));
	    			empList.add(e);	
	    		
				}
				}
				
	            catch(Exception ex)
	            {
	            	System.out.println(ex);
	            }
		
		
	          	
		    	 
		    			return empList;		
}
}

	            
	            
	        
	            
		 

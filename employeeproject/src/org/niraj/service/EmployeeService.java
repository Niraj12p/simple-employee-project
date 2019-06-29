package org.niraj.service;
import java.util.List;

import org.niraj.modal.Employee;
public interface EmployeeService {
public void  saveEmployee(Employee emp);
	
	public List<Employee> allEmployees();
	
	public void deleteEmployee(Integer id);
	
	public Employee employeeById(Integer id);
	
	public void updateEmployee(Employee emp);
	 public List<Employee> searchStudents(String theSearchName);


}

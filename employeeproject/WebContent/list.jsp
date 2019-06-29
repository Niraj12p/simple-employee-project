<html>
<body>
<title>List of Employees </title> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include.jsp" %>
<form action="EmployeeServlet1" method="get">
    <input type="hidden" name="command" value="SEARCH" />
            
                Search student: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" />
</form>
            
    <table border="1">
        <thead>
            <tr>
                <th>S.No.</th>
                <th>First Name</th>
                 <th>Last Name</th>
                  <th>Salary</th>
                   <th>Age</th>
                    <th>Email</th>
       				<th>Action</th>
            </tr>
        </thead>
        <tbody>
            
            <c:forEach items="${employeeList}" var="emp">
            <c:url var="tempLink" value="EmployeeServlet1">
            <c:param name="command" value="LOAD" />
            <c:param name="employeeId" value="${emp.id}"/>
            </c:url>
            
            <c:url var="deleteLink" value="EmployeeServlet1">
            <c:param name="command" value="Delete" />
            <c:param name="employeeId" value="${emp.id}"/>
            </c:url>
                <tr align="center" >
                    <td>${emp.id}</td>
                     <td>${emp.firstName}</td>
                      <td>${emp.lastName}</td>
                       <td>${emp.salary}</td>
                        <td>${emp.age}</td>
                        <td>${emp.email}</td>
                        <td><a  href="${tempLink }">Update</a>
                        |
                        <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this employee?')))return false" >Delete</a></td>
                </tr>
                </c:forEach>
        </tbody>
        </table>
        <%@include file="footer.jsp" %>

</body>
</html>
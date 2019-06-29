<html>
<body>
<h1>Employee Details</h1>
      <form action="EmployeeServlet1" method="get">
      <input type="hidden" name="command" value="ADD" />
             <table border="1"  >
            <tr>
                <td> First Name:</td><td> <input type="text" name="firstName" /></td>
            </tr>
            <tr>
                <td> Last Name:</td><td> <input type="text" name="lastName" ></td>
            </tr>
            <tr>
                <td> Salary:</td> <td><input type="text" name="salary" /></td>
            </tr>
            <tr>
                <td>Age:</td> <td><input type="text" name="age" /></td>
            </tr>
            <tr>
                <td> Email:</td> <td><input type="text" name="email" /></td>
            </tr>
            <tr>
                <td>submit:</td><td><input type="submit" name="submit" value="Save" ></td>
            </tr>
             </table>
        </form>
</body>
</html>
<head>
<body>
      <form action="EmployeeServlet1" method="get">
      
<h1>Employee Details::<input type="hidden" name="eId" value="${hawa.id }">  </h1>
<input type="hidden" name="command" value="Update" />
             <table>
             <tr>
                <td> Id:</td><td> <input type="text" name="eId" value="${hawa.id}" /></td>
            </tr>
            <tr>
                <td> First Name:</td><td> <input type="text" name="firstName" value="${hawa.firstName}" /></td>
            </tr>
            <tr>
                <td> Last Name:</td><td> <input type="text" name="lastName" value="${hawa.lastName}" ></td>
            </tr>
            <tr>
                <td> Salary:</td> <td><input type="text" name="salary"  value="${hawa.salary}"/></td>
            </tr>
            <tr>
                <td>Age:</td> <td><input type="text" name="age" value="${hawa.age}" /></td>
            </tr>
            <tr>
                <td> Email:</td> <td><input type="text" name="email" value="${hawa.email}" /></td>
            </tr>
            <tr>
                <td>submit:</td><td><input type="submit" name="update"  value="submit"></td>
            </tr>
             </table>
        </form>





</body>
</head>
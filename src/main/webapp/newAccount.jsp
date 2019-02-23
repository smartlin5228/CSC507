<%--
  Created by IntelliJ IDEA.
  User: tlin504
  Date: 2/6/19
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create your account</title>
</head>
<body>
    <center>
        <h1>
            Please Enter Your Account Information!
        </h1>
        <form method="post" action="CreateAccount">
            Username: <input type="text" name="username"><br>
            <br><br>
            Password: <input type="password" name="password"><br>
            <span class="error">${error}</span>
            <br>
            <select name="role" size="1">
                <option>Employee</option>
                <option>SystemAdmin</option>
                <option>Manager</option>
                <option>Customer</option>
            </select>
            <br><br>
            <input type="submit" value="Create">
            <br>
            <span class="error">${success}</span>
            <br>
            <a href="index.jsp">${url}</a>
        </form>
    </center>
</body>
</html>

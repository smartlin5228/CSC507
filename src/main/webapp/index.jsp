<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BookMyRoom Login</title>
</head>
<body>
<center>
    <h1>
        Please Enter Your Username and Password!
    </h1>
    <form method="post" action="BookMyRoom">
        Username: <input type="text" name="uname"><br>
        <br><br>
        Password: <input type="password" name="password"><br>
        <span class="error">${error}</span>
        <br>
        <select name="Roles" size="1">
            <option>Employee</option>
            <option>SystemAdmin</option>
            <option>Manager</option>
            <option>Customer</option>
        </select>
        <br><br>
        <input type="submit" value="Login">
        <a href="newAccount.jsp">Create new Account</a>
    </form>
</center>


</body>
</html>

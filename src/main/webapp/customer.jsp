<%--
  Created by IntelliJ IDEA.
  User: tlin504
  Date: 1/14/19
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
    <h1>
        Welcome Customer!
    </h1>
        <%
            Date date = new Date();
            out.print(date.toString());
        %>
</body>
</html>
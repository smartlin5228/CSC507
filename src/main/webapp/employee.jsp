<%--
  Created by IntelliJ IDEA.
  User: tlin504
  Date: 1/14/19
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import ="java.util.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<body>
<center>
    <h1>
        Welcome Employee!
    </h1>
    <form>

        <table border="2">
            <tr>
                <td>ID</td>
                <td>Time</td>
                <td>Service Type</td>
                <td>Owner</td>
                <td>Room Number</td>
            </tr>
            <%
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String url="jdbc:mysql://localhost:3306/userlogin";
                    String username="csc505";
                    String password="password";
                    String query="SELECT * FROM service";
                    Connection conn= DriverManager.getConnection(url,username,password);
                    Statement stmt=conn.createStatement();
                    ResultSet rs=stmt.executeQuery(query);
                    while(rs.next())
                    {

            %>
            <tr><td><%=rs.getInt("id") %></td>
            <td><%=rs.getString("timestamp") %></td>
            <td><%=rs.getString("service_type") %></td>
            <td><%=rs.getString("owner") %></td>
            <td><%=rs.getString("room") %></td></tr>
            <%

                }
            %>
        </table>
        <%
                rs.close();
                stmt.close();
                conn.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }




        %>

    </form>
    <h4>Please enter the Room number for the service you want to assign to your self:</h4>
    <form action="Employee">
        <table>
            <tr>
                <td>Enter the Room Number:</td>
                <td><input type="" name="id"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Search"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
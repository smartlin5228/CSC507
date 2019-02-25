<%--
  Created by IntelliJ IDEA.
  User: tlin504
  Date: 1/14/19
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import ="java.util.*" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
      <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
      <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>



<div class="container">

<form id="bookresform" method="post" action="">

<div>
      <h3>Room Details</h3>
</div>

<sql:setDataSource var="ds" dataSource="jdbc/health"/>
<sql:query dataSource="${ds}" sql='select * from ROOM_DETAIL' var="results" scope="page">
</sql:query>
 <table id="testing" class="table table-bordered">
    <thead>
      <tr>
         <th>ROOM NUMBER</th>
         <th>AVAILABLE STATUS</th>
         <th>PRICE</th>
         <th>CAPACITY</th>
         <th>CATEGORY</th>
         <th>BOOKED FROM DATE</th>
         <th>BOOKED TO DATE</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var = "flag" items = "${results.rows}" varStatus="loop">
      <fmt:formatDate value="${flag.BOOKED_FROM}" pattern="MM/dd/yyyy" var="fromdate" />
      <fmt:formatDate value="${flag.BOOKED_TO}" pattern="MM/dd/yyyy" var="todate" />
            <tr>
               <td> <c:out value = "${flag.ROOM_NUM}"/></td>
               <td> <c:out value = "${flag.AVAILABLE_STATUS}"/></td>
               <td> <c:out value = "${flag.PRICE}"/></td>
               <td> <c:out value = "${flag.CAPACITY}"/></td>
               <td> <c:out value = "${flag.CATEGORY}"/></td>
               <td> <c:out value = "${fromdate}"/></td>
               <td> <c:out value = "${todate}"/></td>
            </tr>
         </c:forEach>
    </tbody>
  </table>
</form>
</div>

</body>

<script type="text/javascript">


</script>
</html>
<%--  <%@ page import="com.saintrose.models.User" %> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%--  <link rel="stylesheet" href="${pageContext.request.contextPath}/BookMyRoom/WEB-INF/css/bootstrap.min.css"> --%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<%--  <script src="${pageContext.request.contextPath}/BookMyRoom/WEB-INF/JS/bootstrap.min.js"></script> --%>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">

.disabledTab{
    pointer-events: none;
}
	.bs-example{
		margin: 20px;
	}
	
	{
  box-sizing: border-box;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>
</head>
<body>
 <div class="bs-example">
  
        <!-- Brand and toggle get grouped for better mobile display -->
        
  <ul class="nav nav-tabs">
        <li class="active"><a data-toggle="tab" href="#userProfile">User Profilelower</a></li>
        <li><a data-toggle="tab" href="#bookReservation">Book Reservation</a></li>
         <li><a data-toggle="tab" href="#serviceRequest">Service Request</a></li>
    </ul>
    <div class="tab-content">
        <div id="userProfile" class="tab-pane fade in active">
            <%@include file="/userRegistration.jsp" %>
        </div>
        <div id="bookReservation" class="tab-pane fade">
            <h3>Book your room.</h3>
            <p></p>
        </div>
        
         <div id="serviceRequest" class="tab-pane fade">
            <h3>Please raise room service request by filling up below form.</h3>
            <p></p>
        </div>
      
        
    </div>
</div>
<%-- <center>
            <% User currentUser = ((User)(session.getAttribute("currentSessionUser")));%>
			
            Welcome <%= currentUser.getRole() %><br>
            
            Today's date: <%= (new java.util.Date()).toLocaleString()%>
         </center>
	 --%>
<%-- <%@include file="../views/logout.jsp" %> --%>
 
    <!-- Include all compiled plugins (below), or include individual files as needed -->


 
</body>

<script type="text/javascript">


$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
	  var target = $(e.target).attr("href"); // activated tab
	  //var check=urlInitial.substr(0,4);
	  var hash = window.location.hash.split('#')[0];
	  window.location.replace(hash+target);
	});

	$('#submitform').click(function() {
      
       $(".disabledTab").removeClass("disabledTab");
   /*    $('.nav-tabs li:eq(1) a').addClass('active');
		$('.nav-tabs a:last').addClass('active'); */
	});

	$(document).ready(function() {
		urlInitial = window.location;
		var valnew = $(".nav-tabs").find(".active a").attr("href");
		var url = urlInitial+valnew;
		
		window.location.replace(url);

		/* $('.nav-tabs li:eq(1) a').addClass('disabledTab');
		$('.nav-tabs a:last').addClass('disabledTab'); */
		
		 
	});
</script>

</html>
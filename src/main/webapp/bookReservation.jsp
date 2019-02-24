<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


    <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
      <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
      <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<div class="container">

<jsp:useBean id="roomsel" class="com.sample.model.RoomDetail" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="roomsel"/>

<c:forEach var="flag" items="${results.rows}">

<p>${flag.PRICE}</p>

</c:forEach>

<form id="bookresform" method="post" action="${pageContext.request.contextPath}/userCustomerLoggedIn">

<input type="hidden" id="setaction" name="action" value="bookroom"></input>
<input type="hidden" id="displaydec" name="displaydec" value="<%= request.getAttribute("displaydec")%>"></input>
<input type="hidden" id="roomnosel" name="roomnosel" value=""></input>
<input type="hidden" id="fromdatehid" name="fromdatehid" value="<%= request.getAttribute("fromdate")%>"></input>
<input type="hidden" id="todatehid" name="todatehid" value="<%= request.getAttribute("todate")%>"></input>

<input type="hidden" id="firstname" name="firstname" value="<%= request.getAttribute("firstname")%>"></input>
<input type="hidden" id="middlename" name="middlename" value="<%= request.getAttribute("middlename")%>"></input>
<input type="hidden" id="lastname" name="lastname" value="<%= request.getAttribute("lastname")%>"></input>
<input type="hidden" id="email" name="email" value="<%= request.getAttribute("email")%>"></input>
<input type="hidden" id="address" name="address" value="<%= request.getAttribute("address")%>"></input>
<input type="hidden" id="dob" name="dob" value="<%= request.getAttribute("dob")%>"></input>
<input type="hidden" id="ssn" name="ssn" value="<%= request.getAttribute("ssn")%>"></input>
<input type="hidden" id="bookroomflaag" name="bookroomflaag" value="<%= request.getSession().getAttribute("bookroomflaag")%>"></input>

<div>
      <h3>Book your room.</h3>
      <p></p>
</div>

<c:if test="${bookroomflaag=='true'}">
 <h3> <c:out value = "Your room is booked!"/></h3>
 <h3> PLease get key for Room No : <c:out value='<%= request.getSession().getAttribute("roomSelected")%>'></c:out></h3>
</c:if>
<c:if test="${bookroomflaag != 'true'}">
<div id="initial">
<div class="row">
    <div class="col-25">
        <br>
     <p>Room Type :    <select name="type" size="1">
            <option>Single</option>
            <option>Double</option>
            <option>Deluxe</option>
        </select>
        <br><br>
      </p>
    </div>
</div>
<div class="row">
    <div class="col-25">
        <br>
     <p>Number of Guests :    <select name="guests" size="1">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>            

        </select>
        <br><br>
      </p>
    </div>
</div>
<div class="row">
    <div class="col-25">
        <br>
     <p>Number of Rooms :    <select name="rooms" size="1">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
        </select>
        <br><br>
      </p>
    </div>
</div>
<div class="row">
    <div class="col-25">
        <br>
     <p>From Date : <input class="datepicker" name="fromdate" type="text" id="datepicker1"></p>
      
    </div>
</div>

<div class="row">
    <div class="col-25">
        <br>
     <p>To Date : <input  class="datepicker" name="todate"  type="text" id="datepicker2"></p>
      
    </div>
</div>
<div class="row">
    <div class="col-25">
        <br>
     <p>Number of Rooms :    <select name="rooms" size="1">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
        </select>
        <br><br>
      </p>
    </div>
</div>
<div class="row">
   <input id="submitformnow" type="submit" value="Submit">
    <!-- <button type="button" class="btn btn-primary">Submit</button> -->
</div>
</div>
</c:if>
<c:if test="${displaydec=='display'}">
<sql:setDataSource var="ds" dataSource="jdbc/health"/>
<sql:query dataSource="${ds}" sql='select * from ROOM_DETAIL where CATEGORY=? and CAPACITY=? and NUMBER_OF_ROOMS=?' var="results" scope="page">
<sql:param><%= request.getAttribute("type")%></sql:param>
<sql:param><%= request.getAttribute("guests")%></sql:param>
<sql:param><%= request.getAttribute("rooms")%></sql:param>
</sql:query>
 <table id="testing" class="table table-bordered">
    <thead>
      <tr>
         <th>SELECT</th>
         <th>ROOM NUMBER</th>
         <th>AVAILABLE STATUS</th>
         <th>PRICE</th>
         <th>CAPACITY</th>
         <th>CATEGORY</th>
         <th>BOOKED FROM DATE</th>
         <th>BOOKED TO DATE</th>
         <th>PAYMENT TYPE</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var = "flag" items = "${results.rows}" varStatus="loop">
      <fmt:formatDate value="${flag.BOOKED_FROM}" pattern="MM/dd/yyyy" var="fromdate" />
      <fmt:formatDate value="${flag.BOOKED_TO}" pattern="MM/dd/yyyy" var="todate" />
            <tr>
               <td><input name="reservationrow" type="checkbox" id="${loop.index}" value="${loop.index}"></td>
               <td id="room_${loop.index}"> <c:out value = "${flag.ROOM_NUM}"/></td>
               <td> <c:out value = "${flag.AVAILABLE_STATUS}"/></td>
               <td> <c:out value = "${flag.PRICE}"/></td>
               <td> <c:out value = "${flag.CAPACITY}"/></td>
               <td> <c:out value = "${flag.CATEGORY}"/></td>
               <td> <c:out value = '<%= request.getAttribute("fromdate")%>'/></td>
               <td> <c:out value = '<%= request.getAttribute("todate")%>'/></td>
               <td><select name="rooms" size="1">
               <option value="1">CREDIT</option>
               <option value="2">CASH</option>
              </select></td>
            </tr>
         </c:forEach>
    </tbody>
  </table>
    <input id="confirm" type="button" value="Confirm">  
</c:if>
</form>
</div>
<script type="text/javascript">

$(function() {
    $( "#datepicker1" ).datepicker();

    $( "#datepicker2" ).datepicker();
   
 });
  
  
$(document).ready(function () {
	
	
	
	$( "#confirm" ).click(function() {
		var selected = [];
		$("input:checkbox[name='reservationrow']:checked").each(function(){    
			selected.push($(this).val());    		
  		});
		
		 var id= "room_"+selected[0];
		 var valueSel =document.getElementById(id).innerText;
		 document.getElementById("roomnosel").value = valueSel;//setaction
		 document.getElementById("setaction").value="bookroomfinal";
		 $("#bookresform").submit();
	});
	
	
	
	var value = document.getElementById("displaydec").value;
	
	if(value=='display'){
		$('#initial').hide();
	}
	
	
	/* $("#submitformnow").click(function() {
		alert("aaaa");
		 document.getElementById("setaction").value = "notsubmit";
		 var value = document.getElementById("setaction").value; 
		alert(value);
		$("#bookresform").submit();
		

	}); */
	});

</script>
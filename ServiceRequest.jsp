<div class="container">
<form method="post" action="${pageContext.request.contextPath}/userCustomerLoggedIn">
<style type="text/css">
h2 {
    color:#069;
}
</style>
<div>
      <h4>Call Front desk @5181112223 for any Service / Maintenance request</h4>
      <h4>Or Submit online to schedule Service / Maintenance for the room</h4>
      <p></p>
</div>
<br><br>
<div>
      <h3>Submit your Service Request Online</h3>
      <p></p>
</div>
<div class="row">
    <div class="col-25">
        <br>
     <p>Room Service :    <select name="roomservice" size="1">
            <option>Room Cleaning</option>
            <option>Breakfast Request/Order</option>
            <option>Lunch Request/Order</option>
            <option>Dinner Request/Order</option>
            <option>Other Queries</option>            
        </select>
        <br><br>
      </p>
    </div>
</div>
<div class="row">
    <div class="col-25">
        <br>
     <p>Service Requst Time:    <select name="servicetime" size="1">
            <option>09:00 AM - 10:00 AM</option>
            <option>10:00 AM - 11:00 AM</option>
            <option>11:00 AM - 12:00 PM</option>
            <option>12:00 PM - 01:00 PM</option>
            <option>01:00 PM - 02:00 PM</option>
            <option>02:00 PM - 03:00 PM</option>
            <option>03:00 PM - 04:00 PM</option>
            <option>04:00 PM - 05:00 PM</option>
            <option>05:00 PM - 06:00 PM</option>
            <option>06:00 PM - 07:00 PM</option>
            <option>07:00 PM - 08:00 PM</option>
            <option>08:00 PM - 09:00 PM</option>
        </select>
        <br><br>
      </p>
    </div>
</div>
<div class="row">
    <div class="col-25">
      <label for="rnum">Your Room Number:</label>
    </div>
    <div class="col-25">
      <input type="text" id="rnum" name="roomnumber" placeholder="Your room numbber.." value="<%= request.getAttribute("roomnumber")%>">
    </div>
</div>
<div class="row">
    <div class="col-25">
      <label for="yname">Your Name:</label>
    </div>
    <div class="col-25">
      <input type="text" id="yname" name="yname" placeholder="Enter Your Name.." value="<%= request.getAttribute("yname")%>">
    </div>
</div>
<div class="row">
   <input id="submitform" type="submit" value="Submit">
    <!-- <button type="button" class="btn btn-primary">Submit</button> -->
</div>
</form>
</div>
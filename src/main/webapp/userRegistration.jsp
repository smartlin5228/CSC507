<div class="container">
  <form method="post" action="${pageContext.request.contextPath}/userCustomerLoggedIn">
  <div class="row">
    <div class="col-25">
      <label for="fname">First Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="fname" name="firstname" placeholder="Your first name.." value="<%= request.getAttribute("firstname")%>">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="lname">Middle Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="lname" name="middlename" placeholder="Your middle name.." value="<%= request.getAttribute("middlename")%>">
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label for="lname">Last Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="lname" name="lastname" placeholder="Your last name.." value="<%= request.getAttribute("lastname")%>" >
    </div>
  </div>
   <div class="row">
    <div class="col-25">
      <label for="lname">Email</label>
    </div>
    <div class="col-75">
      <input type="text" id="lname" name="email" placeholder="Your email.." value="<%= request.getAttribute("email")%>">
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label for="lname">Date Of Birth</label>
    </div>
    <div class="col-75">
      <input type="text" id="lname" name="dob" placeholder="Your DOB.." value="<%= request.getAttribute("dob")%>">
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="lname">SSN</label>
    </div>
    <div class="col-75">
      <input type="text" id="lname" name="ssn" placeholder="Your SSN.." value="<%= request.getAttribute("ssn")%>">
    </div>
  </div>
  
   <div class="row">
    <div class="col-25">
      <label for="lname">Address</label>
    </div>
    <div class="col-75">
      <input type="text" id="lname" name="address" placeholder="Your Address.." value="<%= request.getAttribute("address")%>">
    </div>
  </div>


  <div class="row">
   <input id="submitform" type="submit" value="Submit">
    <!-- <button type="button" class="btn btn-primary">Submit</button> -->
  </div>
  </form>
</div>

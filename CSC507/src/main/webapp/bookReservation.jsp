<div class="container">
<form method="post" action="${pageContext.request.contextPath}/userCustomerLoggedIn">
<div>
      <h3>Book your room.</h3>
      <p></p>
</div>
<div class="row">
    <div class="col-25">
        <br>
     <p>Room Type :    <select name="roomtype" size="1">
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
     <p>Number of Guests :    <select name="numguests" size="1">
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
     <p>Number of Rooms :    <select name="numrooms" size="1">
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
   <input id="submitform" type="submit" value="Submit">
    <!-- <button type="button" class="btn btn-primary">Submit</button> -->
</div>
</form>
</div>
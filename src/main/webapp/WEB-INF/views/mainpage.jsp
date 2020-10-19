<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
  
    <title>Electricity Billing System</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<link href="../resources/login.css" rel="stylesheet" type="text/css">
    <link
      href="https://fonts.googleapis.com/css?family=Montserrat"
      rel="stylesheet"
    />
    
    <style>
	    .footer {
			position: absolute;
			bottom: 0;
			width: 100%;
			height: 60px;
			background-color: #f5f5f5;
	   }
    </style>
  </head>
  
  <body>
  
  	<nav class="navbar navbar-default">
		<a href="/" class="navbar-brand">ELECTRICITY BILLING SYSTEM</a>
	</nav>
	
	<div class="container">
    <div id="popupmain">
      <div id="popup">
        <div class="sign-up-form">
          <div class="button-box">
            <div id="btn"></div>
            <button type="button" class="toggle-btn" onclick="login()">
              Admin
            </button>
            <button type="button" class="toggle-btn" onclick="register()">
              Customer
            </button>
          </div>
         
          <br /><br />
          <br /><br />
          <form id="register" action="/customer-login.do" method="post"">
            <input type="text" class="input-box" name="name" placeholder="Customer name" required />
            <input type="password" class="input-box" name="password" placeholder="Customer Password" required />
            <button type="submit" class="signup-btn" id="signup-btn">
              Login
            </button>
          </form>
           <br /><br />
          
          <form id="login" action="/login.do" method="post">
            <input type="text" class="input-box" name="name" placeholder="Admin name" required />
            <input type="password" class="input-box" name="password" placeholder="Admin Password" required />
            <button type="submit" class="signup-btn" id="signup-btn">
              Login
            </button>
          </form>
        </div>
      </div>
    </div>
    </div>
    
    <footer class="footer">
		<center><h2>HELLO THERE</h2></center>
	</footer>
    
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="../resources/login.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  </body>
</html>

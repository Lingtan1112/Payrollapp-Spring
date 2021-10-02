<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Portal</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br/>
		<div class="d-flex justify-content-center">
		
			<div class="md=5 row">
		
				<h3 >ADMIN LOGIN PORTAL</h3>
			
			</div>
		
		</div><br>

		<form id= "loginForm" action="AdminLogin" method="post" onclick=login() >
		<div class="d-flex justify-content-center">
			<div class="mb-4 col-5">
				<input type="text" name="adminUsername" id="adminUsername" class="form-control form-control-sm" placeholder="Employee ID" required autofocus>
				<div class = "invalid-feedback"> Please enter an Employee ID</div>
		</div>	
		</div>
		<div class="d-flex justify-content-center">
			<div class="mb-2 col-5">
				<input type="password" name="adminPassword" id="adminPassword" class="form-control form-control-sm"	placeholder="password" required>
				<div class = "invalid-feedback"> Please Enter a password</div>
			</div>	
		</div>
		<div class="d-flex justify-content-center">
		<div class="md=2 row">
			<%
			final String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				out.println("<font color='red'>" + errorMessage + "</font>");
			}
			%>
		</div>
		</div><br/>
			
		
		
			<div class=" d-flex justify-content-center">
				<div class="md=4 row">
					<button class="btn btn-primary" class="form-control form-control-sm">Login</button>
				</div>
			</div><br/>
			<div class="d-flex justify-content-center">
				<div class="md=2 row">
					<br> <a href="employeeLogin.jsp" >Employee Login</a>
				</div>
			</div>
	<script type="text/javascript">
		function login(){
			let loginForm = document.querySelector("#loginForm");
			let adminUsername = document.querySelector("#adminUsername");
			let adminPassword = document.querySelector("#adminPassword");
			if(loginForm.checkValidity()){
				loginForm.classList.remove("was-validated");
				
			} else {
				loginForm.classList.add("was-validated"); 
			}
					
			if (adminUsername.value.length == 0) {
				adminUsername.classList.add("is-invalid");
			}
			else{
				adminUsername.classList.add("is-valid");
			}			
		}
	</script>

		</form>
		
	</main>
</body>
</html>
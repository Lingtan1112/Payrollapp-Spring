<!DOCTYPE>

<html lang="en">
<head>
<title>Employee Login portal</title>
</head>
<style>
#errorMessage{
color:red;
font-size:14px;
}

</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<br />
	<main class="container-fluid">
	<div class="d-flex justify-content-center">	
		<div class="md=5 row">
				<h3 >Employee Login Portal</h3>
			</div>
		</div><br>

	<form id="loginForm"  method="post" onclick=login() >
		<div class="d-flex justify-content-center">
			<div class="mb-4 col-5">
				<input type="text" name="employeeLoginId" id="employeeLoginId" class="form-control form-control-sm" placeholder="Employee ID" required autofocus>
				<div class = "invalid-feedback"> Please enter an Employee ID</div>
		</div>	
		</div>
		<div class="d-flex justify-content-center">
			<div class="mb-2 col-5">
				<input type="password" name="employeePassword" id="employeePassword" class="form-control form-control-sm"	placeholder="password" required>
				<div class = "invalid-feedback"> Please Enter a password</div>
			</div>	
		</div><br/>
		
		<div class="d-flex justify-content-center">
			<label id="errorMessage"></label>
		</div>
		

		<div class=" d-flex justify-content-center">
				<div class="md=4 row">
					<input type="submit" class="btn btn-primary" class="form-control form-control-sm">
				</div>
			</div><br/>
			<div class="d-flex justify-content-center">
				<div class="md=2 row">
					<br> <a href="adminLogin.jsp" >Admin Login</a>
				</div>
			</div>
	
<script type="text/javascript">

/**
 * This method is used to check whether the username and password fields are filled or and indicates error if not filled.
 */
function login(){
		let loginForm = document.querySelector("#loginForm");
		let adminUsername = document.querySelector("#employeeLoginId");
		let adminPassword = document.querySelector("#employeePassword");
		if(loginForm.checkValidity()){
			loginForm.classList.remove("was-validated");
		
			//loginForm.submit(); 
				
		} else {
			loginForm.classList.add("was-validated"); 
		}
				
					
	}
		

const exampleForm = document.getElementById("loginForm");
exampleForm.addEventListener("submit", loginValidation);

/**
 * This method sends the form data to the servlet for credential validation and goes to
 * next page on successfull validation and returns error on invalid credentials.
 */
	
	function loginValidation(event) {
		event.preventDefault();
		
		let employeeId = document.getElementById('employeeLoginId').value;
		let password = document.getElementById('employeePassword').value;
		let params = 'employeeLoginId='+employeeId+'&employeePassword='+password;
		
		let url = "EmployeeLogin?"+params;
		
		fetch(url,{ method:'POST'}).then(res => res.json()).then(res=>{
			console.log(res);
			if(res.IS_VALID==true){
				window.location.href="employeePortal.jsp";
			}
			else if(res.IS_VALID!=null){
				document.getElementById('errorMessage').innerHTML = (res.IS_VALID);
			}
		})
		};
</script>
</form>
</main>
</body>
</html>
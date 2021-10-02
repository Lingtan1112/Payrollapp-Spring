<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Portal</title>
</head>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.css">
<script src="https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.js"></script>	

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<br/>
		<div class="d-flex justify-content-center">
		
			<div class="md=5 row">
		
				<h3 >ADMIN LOGIN PORTAL</h3>
			
			</div>
		
		</div><br>

		<form id= "loginForm" action="" method="post" onsubmit="validateUser()" onclick="login()" >
			<div class="d-flex justify-content-center">
				<div class="mb-4 col-5">
					<input type="text" name="userName" id="userName" class="form-control form-control-sm" placeholder="Employee ID" required autofocus>
					<div class = "invalid-feedback"> Please enter an Employee ID</div>
			</div>	
			</div>
			<div class="d-flex justify-content-center">
				<div class="mb-2 col-5">
					<input type="password" name="password" id="password" class="form-control form-control-sm"	placeholder="password" required>
					<div class = "invalid-feedback"> Please Enter a password</div>
				</div>	
			</div>
			<div class="d-flex justify-content-center">
				<label id="errorLabel"></label>
			</div>
			
		
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
			let adminUsername = document.querySelector("#userName");
			let adminPassword = document.querySelector("#password");
			if(loginForm.checkValidity()){
				loginForm.classList.remove("was-validated");
				
			} else {
				loginForm.classList.add("was-validated"); 
			}
		}
		
		function validateUser(){
			event.preventDefault();
			let myForm = event.target;
			let formData = new FormData(myForm);
			
			let obj = {};
			for(let key of formData.keys()){
				obj[key] = formData.get(key);
			}
			
			let url = "user/v1/ValidateUser";
			axios.post(url, obj).then(res=>{ 
				if(res.data){
					window.location.href="adminPortal.jsp";
				}else{
					let notyf = new Notyf({
						ripple:false,
						duration:3000,
						dismissible:true,
						position:{x:'right',y:'top'}
					});
					notyf.error("Invalid Credentials");
					
				}
			}).catch(err=>{
				let error = err.response.data.errorMessage;
				
				if(error=="validation error"){
					
					for(let error of err.response.data.errorMessages){
						let name = error.objectName;
						console.log(error);
						
						if(name=="userName"){		
							document.querySelector("#errorLabel").innerHTML = "<font style='font-size:12px' color='red'>"+(error.defaultMessage)+"</font>";
						}
						}
					}
				});
				}
	
		
		</script>

		</form>
		
	</main>
</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Employee Portal</title>
</head>
<body>
	<jsp:include page="headerForEmployee.jsp"></jsp:include>
	<main class="container-fluid">
	<br/>
	<form id="changePasswordForm"  method="post" onclick=login() >
	<div class="d-flex justify-content-center">
			<div class="mb-4 col-5">
			<label>Employee Id</label>
				<input type="text" name="employeeId" id="employeeId" class="form-control form-control-sm" placeholder="EmployeeID" required autofocus>
				<div class = "invalid-feedback"> Please enter your EmployeeId</div>
		</div>	
		</div>
		<div class="d-flex justify-content-center">
			<div class="mb-4 col-5">
			<label>Old password</label>
				<input type="password" name="oldPassword" id="oldPassword" class="form-control form-control-sm" placeholder="Old Password" required autofocus>
				<div class = "invalid-feedback"> Please enter old Password</div>
		</div>	
		</div>
		<div class="d-flex justify-content-center">
			<div class="mb-4 col-5">
			<label>New password</label>
				<input type="password" name="newPassword" id="newPassword" class="form-control form-control-sm" placeholder="New Password" required autofocus>
				<div class = "invalid-feedback"> Please enter New Password</div>
		</div>	
		</div>
		<div class="d-flex justify-content-center">
			<div class="mb-2 col-5">
			<label>Confirm password</label>
				<input type="password" name="confirmPassword" id="confirmPassword" class="form-control form-control-sm"	placeholder="Confirm New password" required>
				<div class = "invalid-feedback"> Please Re-enter password</div>
			</div>	
		</div><br/>
		
		<div class="d-flex justify-content-center">
			<label id="errorMessage"></label>
		</div>
		
		<div class="d-flex justify-content-center">
			<label id="message" ></label>
		</div>
		
		<div class=" d-flex justify-content-center">
				<div class="md=4 row">
					<input type="submit" onclick="checkPasswordMatch()" class="btn btn-primary" class="form-control form-control-sm">
				</div>
		</div>
			
<script type="text/javascript">
/**
 * This method is used to check whether the username and password fields are filled or and indicates error if not filled.
 */
	function login(){
		let loginForm = document.querySelector("#changePasswordForm");
		let employeeId = document.querySelector("#employeeId");
		let oldPassword = document.querySelector("#oldPassword");
		let newPassword = document.querySelector("#newPassword");
		let confirmPassword = document.querySelector("#confirmPassword");
		
		if(loginForm.checkValidity()){
			loginForm.classList.remove("was-validated");
						
		} else {
			loginForm.classList.add("was-validated"); 
		}
		
		if (employeeId.value.length == 0) {
			employeeId.classList.add("is-invalid");
		}else{
			employeeId.classList.add("is-valid");
		}		
		if (oldPassword.value.length == 0) {
			oldPassword.classList.add("is-invalid");
		}else{
			oldPassword.classList.add("is-valid");
		}
		if (newPassword.value.length == 0) {
			newPassword.classList.add("is-invalid");
		}else{
			newPassword.classList.add("is-valid");
		}
		if (confirmPassword.value.length == 0) {
			confirmPassword.classList.add("is-invalid");
		}else{
			confirmPassword.classList.add("is-valid");
		}
					
	}
	
	/**
	*This method compares whether the new password and confirm fields match and if both matches
	*it fetches the acknowledgement whether the password is updated or not.
	*
	*/
	function checkPasswordMatch(){
		event.preventDefault();
		let employeeId = document.getElementById("employeeId").value;
		let oldPassword = document.getElementById("oldPassword").value;

		let newPassword = document.getElementById("newPassword").value;
		let confirmPassword = document.getElementById("confirmPassword").value;

		let params = 'employeeId='+employeeId+'&newPassword='+newPassword+'&oldPassword='+oldPassword;
	
		if(newPassword == confirmPassword){
			console.log("Password Matched");
			let url="ChangePasswordServlet?"+params;
			fetch(url,{method:'post'}).then(res=>res.json()).then(res=>{
								
				if(res.IS_CHANGED==true){
					document.getElementById('message').innerHTML="<font color='green'>Successfully Changed Password</font>";
				}else{
					document.getElementById('message').innerHTML="<font color='red'>"+(res.IS_CHANGED)+"</font>";
				}
					
			})
		} else{
			document.getElementById('message').innerHTML="<font color='red'>Password does not match</font>";
	}	
}
</script>

</form>
</main>
</body>
</html>
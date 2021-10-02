<!DOCTYPE html>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.HashMap"%>

<html lang="en">
<head>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<meta charset="ISO-8859-1">
<title>Register Employee</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<div class="d-flex justify-content-center">
		<h3>Employee Registration</h3>
	</div>
	<div class="btn-group-vertical pull-right">
		<div class="row">
			<div class="form-group col-md-2">
			<a href="displayAllEmployees.jsp" class="btn btn-primary">Display Employees</a>
		</div>
		</div>
	</div>
	
	
<form action="" method="post" onsubmit="registerEmployee()" id="registerForm" >
	
	
	
	

	<label id="testLabel"></label>
	
	<div class="row">
	  <div class="col">
			<label>First Name  </label><input type="text" name="firstName" class="form-control form-control-sm" id="firstName" pattern="[a-zA-Z]+" placeholder="First Name" required autofocus>
	  </div>
	  <div class="col">
			<label>Last Name  </label><input type="text" name="lastName" id="lastName" class="form-control form-control-sm" placeholder="Employee's Father Name" required >
	  </div>
	</div>
	<div class="row">
		<div class="col">
			<label>Role </label>
			<select name = "role" id = "role" class="form-control form-control-sm" required >
				<option value="Technical Consultant" >Technical Consultant </option>
				<option value="HR" >HR </option>
				<option value="System Administration" >System Administration</option>
				<option value="PL SQL" >PL SQL </option>
				<option value="Software Developer" >Software Developer </option>
				<option value="UI-Designer" >Ui-Designer</option>
			</select>
		</div>
		<div class="col">
			<label>Date of Birth</label><input type="date" min='1985-01-01' max='2004-01-01' class="form-control form-control-sm" name="dob" id="dob"  placeholder="YYYY-MM-DD" required>
		</div>
	</div>
	
	<div class="row">
		<div class=" col">
			<label>Mobile Number</label><input type="number" name="mobileNumber" min="0000000000" max="9999999999" id="mobileNumber" class="form-control form-control-sm" placeholder="Mobile Number" required>
		</div>
		<div class="col">
			<label>Joined Date</label><input type="date" name="joiningDate" class="form-control form-control-sm"  value="<%=LocalDate.now()%>" id="joiningDate" placeholder="YYYY-MM-DD" required>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<label>Gender</label>
			<div class="form-check form-check-inline">
				<label>Male</label><input type="radio" id="Male" name="gender"  value ="Male" required>
			</div>
			<div class="form-check form-check-inline">
				<label>Female</label><input type="radio" id="Female" name="gender"   value ="Female" required>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-md-2">
			<button class="btn btn-success">Register</button><br>
		</div>
		<div class="form-group col-md-2">
			<a href="registerEmployee.jsp" class="btn btn-danger">Reset</a>
		</div>

		<div class="form-group col-md-2">
			<a href="adminPortal.jsp" class="btn btn-primary">Admin Portal</a>
		</div>
	
	</div>
	
	
	<br/>
	

<script>
function registerEmployee(){
	event.preventDefault();
	let myForm = event.target;
	let formData = new FormData(myForm);
	
	let obj = {};
	for(let key of formData.keys()){
		obj[key] = formData.get(key);
	}
	let url = "RegisterEmployeeServlet1";
	axios.post(url, obj).then(res=>{ 
		
		console.log("Recieved Data"); 
		console.log("Data--"+JSON.stringify(res.data));
		document.getElementById("testLabel").innerHTML="<font color='darkgreen'>Successfully registered-"+res.data.name+"</font>";
		
	}).catch(err=>{
			console.log(err.response.data);
			console.log("error---"+JSON.stringify(err.response.data.errorMessage));	
			document.getElementById("testLabel").innerHTML="<font color='red'>"+(err.response.data.errorMessage)+"</font>";
	});


}
</script>

</form>


</main>

</body>
</html>
<!DOCTYPE html>
<%@page import="java.time.LocalDate"%>


<html lang="en">
<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Register Employee</title>
<style>

.card{
margin-top:10px;
margin-left:-10px;
margin-bottom:10px;
height:70px;
width:150px;
}
</style>

</head>
<link rel="stylesheet" href="assets/css/adminPortal.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>	
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="pageTitle" class="d-flex justify-content-center">
	 	<h4 class="pageTitleText">Employee Registration</h4>
	 </div>
	<main class="container-fluid">
	<div class="col">
            <div class="card l-bg-green-dark">
                <div class="card-statistic-3 p-4">
                       <div class="card-icon card-icon-large"></div>
                    	<div class="mb-4">
                    	<a class="card-block stretched-link text-decoration-none" href="displayAllEmployees.jsp" ></a>
                   			<h6 class="cardTitle">Display Employees</h6>
                   		</div>
                    </div>
                </div>
            </div>
	
<form action="" method="post" onsubmit="registerEmployee()" id="registerForm" >
	
	<label id="pageError"></label>
	
	<div class="row">
	  <div class="col">
			<label>First Name  </label><input type="text" value="Lingtan" name="firstName" class="form-control form-control-sm" id="firstName" placeholder="First Name"  autofocus>
			<label class="clear" id="firstNameError"></label>
	  </div>
	  <div class="col">
			<label>Last Name  </label><input type="text" value="Navis Anthoni samy" name="lastName" id="lastName" class="form-control form-control-sm" placeholder="Employee's Father Name"  >
	  		<label id="lastNameError"></label>
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
			<label>Date of Birth</label><input type="date" min='1985-01-01' value="<%=LocalDate.now().minusDays(100)%>" max='2022-01-01' class="form-control form-control-sm" name="dob" id="dob"  placeholder="YYYY-MM-DD" required>
			<label id="dobError"></label>
		</div>
	</div>
	
	<div class="row">
		<div class=" col">
			<label>Mobile Number</label><input type="number" value="9600923846" name="mobileNumber" min="0000000000"  max="9999999999" id="mobileNumber" class="form-control form-control-sm" placeholder="Mobile Number" required>
			<label id="mobileNumberError"></label>
		</div>
		<div class="col">
			<label>Joined Date</label><input type="date" name="joiningDate" class="form-control form-control-sm"  value="<%=LocalDate.now()%>" id="joiningDate" placeholder="YYYY-MM-DD" required>
			<label id="joinDateError"></label>
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
		<div class="form-group col-md-1">
			<button class="btn btn-success">Register</button><br>
		</div>
		<div class="form-group col-md-1">
			<button type="reset" class="btn btn-danger">Reset</button>
		</div>

		<div class="form-group col-md-1">
			<a href="adminPortal.jsp" style="width:150px;" class="btn btn-primary">Admin Portal</a>
		</div>
	
	</div>
	
</form>
</main>


<script>

function registerEmployee(){
	event.preventDefault();
	document.querySelector("#firstNameError").innerHTML = "";
	document.querySelector("#lastNameError").innerHTML = "";
	document.querySelector("#dobError").innerHTML = "";
	document.querySelector("#mobileNumberError").innerHTML = "";
	document.querySelector("#joinDateError").innerHTML = "";
	document.querySelector("#pageError").innerHTML = "";
	
	let myForm = event.target;
	let formData = new FormData(myForm);
	
	let obj = {};
	for(let key of formData.keys()){
		obj[key] = formData.get(key);
	}
	let url = "employee/v1/RegisterEmployee";
	axios.post(url, obj).then(res=>{ 
		console.log(res);
		if(res){
			let notyf = new Notyf({
				ripple:false,
				duration:3000,
				dismissible:true,
				position:{x:'right',y:'top'}
			});
			notyf.success("Successfully Registered");
			document.getElementById("registerForm").reset();
		}		
	}).catch(err=>{
		
		let error = err.response.data.errorMessage;
		console.log(err.response.data);
		if(error=="validation error"){
			
			for(let error of err.response.data.errorMessages){
				let name = error.objectName;
				console.log(error);
				
				if(name=='firstName'){		
					document.querySelector("#firstNameError").innerHTML = "<font style='font-size:12px' color='red'>"+(error.defaultMessage)+"</font>";
				}
				if(name=='lastName'){		
					document.querySelector("#lastNameError").innerHTML = "<font style='font-size:12px' color='red'>"+(error.defaultMessage)+"</font>";
				}
				if(name=='dob'){		
					document.querySelector("#dobError").innerHTML = "<font style='font-size:12px' color='red'>"+(error.defaultMessage)+"</font>";
				}
				if(name=='mobileNumber'){		
					document.querySelector("#mobileNumberError").innerHTML = "<font style='font-size:12px' color='red'>"+(error.defaultMessage)+"</font>";
				}
				if(name=='joiningDate'){		
					document.querySelector("#joinDateError").innerHTML = "<font style='font-size:12px' color='red'>"+(error.defaultMessage)+"</font>";
				}
			}
		}else if(error.errorSource="EmployeeIdInactive"){
			document.querySelector("#pageError").innerHTML = "<font style='font-size:12px' color='red'>"+(err.response.data.employeeId)+" is Inactive - </font><a href='' onclick = 'activateEmployee('"+err.response.data.employeeId+"')' class='btn btn-info'>Activate</a>";
		}
	});
}

function activateEmployee(employeeId){
	alert("Hello");
	event.preventDefault();
	console.log(employeeId);
	
	let url = "employee/v1/ActivateEmployee?employeeID="+employeeId;	
	axios.put(url).then(res=>{
		if(res){
			let notyf = new Notyf({
				ripple:false,
				duration:3000,
				dismissible:true,
				position:{x:'right',y:'top'}
			});notyf.success("Successfully Activated");
		}
		console.log(res);
	}).catch(err=>{
		let error = err.response.data;
		console.log(err.response.data);
		let notyf = new Notyf({
			ripple:false,
			duration:3000,
			dismissible:true,
			position:{x:'right',y:'top'}
		});notyf.error(error.errorMessage);
	});
}

</script>

</body>
</html>
<!DOCTYPE html>

  <html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Salary Modification</title>
</head>
<link rel="stylesheet" href="assets/css/adminPortal.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.css">
<script src="https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.js"></script>	

<style type="text/css">
#estimatedSalary{
color:black;
background-color : lightgreen;
font-weight:bold;
position : absolute;
top:       170px; 
left:      300px;
height:    80px;
}
#estimatedSalaryLabel{
color:darkGreen;
font-weight:bold;
position : absolute;
top:       140px; 
left:      300px;
height:    80px;
}
#ctcLabel{
color:darkGreen;
font-weight:bold;
position : absolute;
top:       300px; 
left:      300px;
height:    80px;
}
#ctc{
color:black;
background-color:lightgreen;
font-weight:bold;
position : absolute;
top:       330px; 
left:      300px;
height:    80px;
}
</style>
<body >

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<div class="pageTitle" class="d-flex justify-content-center">
	 	<h4 class="pageTitleText">Activate Employee</h4>
	 </div>
<div class="d-flex justify-content-left">
	<a href="registerEmployee.jsp" class="btn btn-primary" style='margin:5px;'>Register Employee</a>
	<a href="displayAllEmployees.jsp" class="btn btn-primary" style='margin:5px;' >Display Employee</a>
</div>
<form action="" id="" method="post">
	
	
	<br/>
	<div class="d-flex justify-content-center">
		<input type="text" id="employeeId"  Placeholder="Enter an Employee-ID"  autofocus >
	</div>
	<br/>
	<div class="d-flex justify-content-center">
			<button class="btn btn-success" id="activate" onclick="activateEmployee()" style="width:180px;">Activate</button>
	</div>
	
	
</form>
</main>
</body>

<script>

function showSaveButton(){
	document.getElementById("activate").style.visibility="visible";
}

function activateEmployee(){
	event.preventDefault();
	let employeeId = $("#employeeId").val();
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

/**
 * This Method uses json strings to assign values to the textboxes which are recieved from the servlet.
 */
 
        
         
   
</script>

</html>
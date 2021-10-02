<!DOCTYPE html>

<%@page import="java.util.Map"%>
<%@page import="in.lingtan.service.EmployeeService"%>
<%@page import="in.lingtan.model.Employee"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.security.KeyStore.Entry"%>
<html lang="en">
<head>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>	
<meta charset="ISO-8859-1">
<title>Employee Data</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<br />
	<main class="container-fluid">
	<a href="" onclick="gotoPaySlipPage()" type="button" class="btn btn-primary btn-color btn-bg-color btn-sm col-xs-2 margin-left">Pay slip</a>
	
	<br/>
	<table id="employeeDataTable" class="table" border="1">
	
	
	
		<caption>Employee Data</caption>
		<tbody>
 		<thead class="thead-dark">
 			<tr>
 			<th id="title"></th>
 			<th scope="col" ></th>
 			</tr>
 			
 		</thead>
		
		<tbody>
		
			<tr>
				<th scope="row">Employee Name</th>
				<td id="name"></td>
			</tr>
			
			<tr>
				<th scope="row">Employee-ID</th>
				<td id="employeeId"></td>
			</tr>
			
			<tr>
				<th scope="row">Email</th>
				<td id="email"></td>
			</tr>
		
			<tr>
				<th scope="row">Role</th>
				<td id="role"></td>
			<tr>
				<th scope="row">Gender</th>
				<td id="gender"></td>
			</tr>
			<tr>
				<th scope="row">Mobile Number</th>
				<td id="mobileNumber"></td>
			</tr>
			<tr>
				<th scope="row">Date of Birth</th>
				<td id="dob"></td>
			</tr>
			<tr>
				<th scope="row">Joined Date</th>
				<td id="joiningDate"></td>
			</tr>
			
			
		

		</tbody>
	</table>
	</main>
<script type="text/javascript">


function displayEmployeeData(){

	const url ="GetEmployeeData?employeeId="+employeeId;
	axios.get(url).then(res=>{
		
		console.log(res.data);
		for(let dataToDisplay of res.data){
		document.getElementById("title").innerHTML=(dataToDisplay.employeeID);
		document.getElementById("name").innerHTML=(dataToDisplay.name);
		document.getElementById("employeeId").innerHTML=(dataToDisplay.employeeID);
		document.getElementById("email").innerHTML=(dataToDisplay.email);
		document.getElementById("role").innerHTML=(dataToDisplay.role);
		document.getElementById("gender").innerHTML=(dataToDisplay.gender);
		document.getElementById("mobileNumber").innerHTML=(dataToDisplay.mobileNumber);
		document.getElementById("dob").innerHTML=(dataToDisplay.dob);
		document.getElementById("joiningDate").innerHTML=(dataToDisplay.joiningDate);
		
		}
	});
}

function gotoPaySlipPage(){
	event.preventDefault();
	const params = new URLSearchParams(window.location.search);
	let employeeId = params.get('employeeId');
	window.location.href="paySlipOfEmployee.jsp?employeeId="+employeeId;
	
}

const params = new URLSearchParams(window.location.search);
let employeeId = params.get('employeeId');
displayEmployeeData(employeeId);


</script>


</body>
<a href="displayAllEmployees.jsp">Previous page</a>

</html>
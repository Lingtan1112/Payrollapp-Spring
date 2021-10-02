<!DOCTYPE>


<%@page import="java.util.Map.Entry"%>
<%@page import="in.lingtan.service.EmployeeService"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<title>Employee Payroll</title>
</head>
<body onload="displayEmployee()">
	<jsp:include page="header.jsp"></jsp:include>
	<br />
	<main class="container-fluid">

		<h3>Employees in the Company</h3>
		
		


		<br>
		<table id="employeeTable" class="table" border="1">
 			
			<caption>List of Employees in a company</caption>
			 <thead class="thead-dark">
				<tr>
					<th scope="col">Employee ID</th>
					<th scope="col">Name</th>
					<th scope="col">Details</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>
			<a href="adminPortal.jsp">Main menu</a>
			<br>
	</main>
	<script>
	function displayEmployee(){
		let url = "GetEmployeeList";
		axios.get(url).then(res=>{
			
			let i=1;
			for(let data of res.data){
				var table = document.getElementById("employeeTable");

				var row = table.insertRow(i); 
		
				var employeeId = row.insertCell(0);
				var employeeName = row.insertCell(1);
				var viewEmployee = row.insertCell(2);
				var deleteEmployee = row.insertCell(3);
				
				employeeId.innerHTML = data.employeeID;
				employeeName.innerHTML = data.name;
				viewEmployee.innerHTML = "<a href='displayIndividualEmployeeData.jsp?employeeId="+data.employeeID+"'>View Details</a>";
				deleteEmployee.innerHTML = "<a href='registerEmployee.jsp?employeeId="+data.employeeID+"'>Delete</a>";
				
				
				console.log(data);
				console.log(data.employeeID);
				i++;
			}
		});
	}
	
	/**
	*
	*/
	function deleteConfirmation(employeeId){
		if(confirm("Are You sure want to delete "+employeeId)){
		}else{
			event.preventDefault();
		}
	}
	</script>
</body>
</html>
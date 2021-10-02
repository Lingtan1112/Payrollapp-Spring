<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">

<title>Admin portal</title>
</head>
<style>
#displayEmployee, #payRollPortal, #registerEmployee{
color:white;
font-weight:bold;

}


</style>
<body>


	<jsp:include page="header.jsp"></jsp:include>
	<div class="d-flex justify-content-center">
		<h4>
			<%
			String employeeId = (String) session.getAttribute("ADMIN_ID");
			out.println("<h4>" + " Welcome " + employeeId + "</h4>");
			%>
		</h4>
	</div>

	<main class="container-fluid">
	
	<div class="d-flex justify-content-center">
	<div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
  	<div class="btn-group mr-2" role="group" aria-label="First group">

		<div class="btn btn-primary" >
			<a id="registerEmployee" href="registerEmployee.jsp">Register Employee</a><br>
		</div>

		</div>
	</div>
	<div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
 	<div class="btn-group mr-2" role="group" aria-label="First group">

		<div class="btn btn-primary" >
			<a id="displayEmployee" href="displayAllEmployees.jsp">Display Employees</a><br>
		</div>
	</div>
	</div>
	<div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
  	<div class="btn-group mr-2" role="group" aria-label="First group">

		<div class="btn btn-primary" >
			<a id="payRollPortal" href="addSalary.jsp">Pay Roll Portal</a><br>
		</div>
	</div>
</div>
</div>

	</main>


</body>
</html>
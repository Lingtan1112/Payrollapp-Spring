<!DOCTYPE html>

<%@page import="java.util.List"%>

<%@page import="java.time.LocalDate"%>
<%@page import="java.util.HashMap"%>
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
<body onload="displayRoles()">

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	
<form action="" id="" method="post">
	<div class="pageTitle" class="d-flex justify-content-center">
	 	<h4 class="pageTitleText">Roles</h4>
	 </div>
	
	<div class="d-flex justify-content-center">
		<input type="text" id="role" oninput="showSaveButton()" Placeholder="Enter a New Role"  autofocus >
	</div>
	<br/>
	<div class="d-flex justify-content-center">
			<button class="btn btn-success" id="saveButton" onclick="saveRole()" style="visibility: hidden;width:180px;">Save Changes</button>
	</div>
	<br/>
	<div class="d-flex justify-content-center">
		<table id="roleTable" class="table" border="1">
			<thead class="thead-dark">
				<th>S.NO</th>
				<th>Role</th>
				<th>Added Date</th>
	
			</thead>
			<tbody id="roleBody">
			
			</tbody>
		</table>
	</div>
</form>
</main>
</body>

<script>

function showSaveButton(){
	document.getElementById("saveButton").style.visibility="visible";
}

function saveRole(){
	event.preventDefault();
	let role = $("#role").val();
	let url = "payroll/v1/AddRole?role="+role;
	axios.post(url).then(res=>{
		let notyf = new Notyf({
			ripple:false,
			duration:3000,
			dismissible:true,
			position:{x:'right',y:'top'}
		});
		notyf.success("Successfully Saved");
		console.log(res.data); 
		$('#roleBody').empty();
		displayRoles();
	}).catch(err=>{
		let notyf = new Notyf({
			ripple:false,
			duration:3000,
			dismissible:true,
			position:{x:'right',y:'top'}
		});
		notyf.error(err.response.data.errorMessage);
	});
}


function displayRoles(){
	
	let url = "payroll/v1/GetRoles";
	axios.get(url).then(res=>{
		if(res.data.length==0){
			$("#roleBody").append("<tr><td colspan=3 class='text-center'>" + "<font color='red'>No Records Found</font></tr>")
			
		}else{
		let i = 0;
		for(let role of res.data){
			i++;
			$("#roleBody").append("<tr><td>"+i+"</td><td>"+role.role+"</td><td>"+role.createdDate+"</td></tr>")
		}
		}
	})
}
/**
 * This Method uses json strings to assign values to the textboxes which are recieved from the servlet.
 */
 
 
 // Fetch the role data and display

        
         
   
</script>

</html>
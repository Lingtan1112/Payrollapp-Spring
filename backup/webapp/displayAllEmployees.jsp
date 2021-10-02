<!DOCTYPE>

<html lang="en">
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.css">

<style>
label{
	margin-top:20px;
	margin-bottom:0px;
}

</style>

<script src="https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.js"></script>	
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="jquery-3.5.1.min.js"></script>

<link rel="stylesheet" href="assets/css/adminPortal.css">



<title>Employee Payroll</title>
</head>
<body onload="display()">
	<jsp:include page="header.jsp"></jsp:include>
	<div class="pageTitle" class="d-flex justify-content-center">
		<h4 class="pageTitleText">Employees in the Company</h4>
	</div>
	<main class="container-fluid">
	
		<div class="row">
		<div class="col">
			<label>Search Employee</label><input type="text" id="searchEmployee" oninput="search()" class="form-control form-control-sm"  placeholder="Enter Employee Name" > <br>
		</div>
		<div class="col">
		<label>Gender</label>
			<select name="gender" class="form-control form-control-sm" id="gender" onchange="search()">
				<option value="" selected>...</option>
				<option value="Male" >Male</option>
				<option value="Female">Female</option>		
			</select>
		</div>
		<div class="col">
		<label>Role</label>
			<select name = "role" id = "role" onchange="search()" class="form-control form-control-sm" required >
				<option value="" selected>...</option>
				<option value="Technical Consultant" >Technical Consultant </option>
				<option value="HR" >HR </option>
				<option value="System Administration" >System Administration</option>
				<option value="PL SQL" >PL SQL </option>
				<option value="Software Developer" >Software Developer </option>
				<option value="UI-Designer" >Ui-Designer</option>
			</select>
		</div>
		<div class="col">
		<label>Sort Aphabetically</label>
			<select class="form-control form-control-sm" name="alphabetical" id="alphabetical" onchange="search()">
				<option value="" selected>...</option>
				<option value="ascending" >A->Z</option>	
				<option value="descending" >Z-A</option>	
			</select>
			</div>
		</div>
		
		
		<div class=" d-flex justify-content-left">
					<a href="" onclick="clearFilters()" class="btn btn-primary" class="form-control form-control-sm">Clear Filters</a>
				</div>
		<br/>
		<table id="employeeTable" class="table" border="1">

			<caption>List of Employees in a company</caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>

		<a href="adminPortal.jsp">Main menu</a> <br>
	</main>
	
<script>
function display(){
	search();
}
/**
 * This function fetches the data from the servlet and stores it in a variable and does the filteration and sends the data to display function.
 * And this function also performs sorting operation which includes the sorting of gender, role and ascending or descending and performs searching also. 
 */
function search(){
	
	event.preventDefault();
	let value = document.getElementById("searchEmployee").value.trim();
	let gender = document.getElementById("gender").value;
	let role = document.getElementById("role").value;
	let sort = document.getElementById("alphabetical").value;
	
	let url = "employee/v1/GetEmployeeList";
	fetch(url).then(res=>res.json()).then(res=>{
	console.log(res);
	let filteredData = [];
	
	filteredData = res;
	if(value!=null){
		filteredData = searchEmployeeFilter(filteredData,value);
	}if(gender!=""){
		filteredData = filterByGender(filteredData,gender);
	}if(role!=""){
		filteredData = filterByRole(filteredData,role);
	}if(sort!=""){
		filteredData = sortByAlphabeticalOrder(filteredData,sort);	
	}	
	displayEmployee(filteredData);
	});
	}


/**
 * This function performs the search operation inside the JSON object for a specific text.
 */
	function searchEmployeeFilter(res,value){
		filteredData = res.filter(res => res.name.toLowerCase().includes(value.toLowerCase()) || res.employeeID.toLowerCase().includes(value.toLowerCase()));
		return filteredData;
	}

/**
 * This function filters the the employees based on their gender.
 */
	function filterByGender(res,gender){
		filteredData = res.filter(res => res.gender.includes(gender));
		return filteredData;
	}

/**
 * This function is used to sort the employee based on their roles.
 */
	function filterByRole(res,role){
		filteredData = res.filter(res => res.role.includes(role));
		return filteredData;
	}
/**
 * This function sorts the employee names in ascending or descending order.
 */
	function sortByAlphabeticalOrder(res,sort){
		filteredData = [];
		res.sort( function( a, b ) {
	  	  a = a.name.toLowerCase();
	  	  b = b.name.toLowerCase();
	  	  return a < b ? -1 : a > b ? 1 : 0;
		});
		if(sort=="ascending"){
			filteredData = res;
		}else if(sort=="descending"){
			filteredData = res.reverse();
		}
		return filteredData;
	}
	
	
	/**
	 * This Function gets the filtered data as parameter and aligns it in the table.
	 */
	function displayEmployee(filteredData){
		var tableData = '<thead class="thead-dark"><th>S.no</th><th>Name</th><th>EmployeeID</th><th>Gender</th><th>Role</th><th>Details</th><th>Delete</th></thead>'
			tableData+= '<tbody>'
			
			if(filteredData.length!=0){
		    for(i = 0;i < filteredData.length; i++){
		    	tableData+= '<tr>';
		    	tableData+= '<td>' + (parseInt(i)+1) + '</td>';
		    	tableData+= '<td>' + filteredData[i].name + '</td>';
		    	tableData+= '<td>' + filteredData[i].employeeID + '</td>';
		    	tableData+= '<td>' + filteredData[i].role + '</td>';
		    	tableData+= '<td>' + filteredData[i].gender + '</td>';
		    	tableData+= '<td><a href="displayIndividualEmployeeData.jsp?employeeId='+filteredData[i].employeeID+'"" class="btn btn-primary">Profile</a></td>';
		    	let deleteId = filteredData[i].employeeID;
		    	let actionMethod  = "confirmDelete('" +  deleteId + "')";		    	
		    	tableData+= '<td><a href="" onclick=' +  actionMethod +' class="btn btn-danger" >Delete</a></td>';		        
		    	tableData+= '</tr>';
		    }
			tableData+='</tbody>';
			
			}else{
				tableData+="<tr><td colspan=7 class='text-center'>" + "<font color='red'>No Records Found</font>" + "</td></tr>"; 
			}
		    document.getElementById("employeeTable").innerHTML = tableData;
	}	
	/**
	*This function confirms whether to delete the employee or not.
	*/
	function confirmDelete(employeeId){
		
		event.preventDefault();
		console.log(employeeId);
			
		if(confirm("Are You sure want to delete  "+employeeId)){
			let url = "employee/v1/DeleteEmployeeId?employeeID="+employeeId;
			axios.get(url).then(res=>{
				if(res.data){	
					let notyf = new Notyf({
						dismissible:true,
						duration:3000,
						ripple:false,
						position:{x:'right',y:'top'}
					});
					notyf.success("Successfully Deleted");
					display();
				}
			}).catch(err=>{
				let error = err.response.data.errorMessage;
				let notyf = new Notyf({
					ripple:false,
					duration:3000,
					dismissible:true,
					position:{x:'right',y:'top'}
				});
				notyf.error(error);
			});
			
		}else{
			event.preventDefault();
			let notyf = new Notyf({
				ripple:false,
				duration:3000,
				dismissible:true,
				position:{x:'right',y:'top'}
			});
			notyf.error("Delete cancelled");
		}
	}
	/**
	*This method clears the selection and makes the dropdown to go default.
	*/
	function clearFilters(){
		event.preventDefault();
		document.getElementById("gender").selectedIndex = "0";
		document.getElementById("role").selectedIndex = "0";
		document.getElementById("alphabetical").selectedIndex = "0";
		document.getElementById("searchEmployee").value = "";
		display();
	}

</script>
</body>
</html>
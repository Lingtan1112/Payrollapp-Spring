<!DOCTYPE html>
<html lang="en">
<head>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<meta charset="ISO-8859-1">
<title></title>
</head>
<style>
#paySlipTable{
background-color:#AAB7B8 ;
font-weight:bold;
border:none;
}

#grossCompensation,#grossCompensationLabel, #ctcLabel, #ctc{
background-color:#34495E;
color:white;
}

#heading1, #heading2{
color:black;
text-align: center;
font-size:18px;
}
p	{
background-color:pink;
font-weight:bolder;
padding:5px;
text-align: center;
font-size:15px;
}
#name,#role,#employeeId,#nameLabel,#employeeIdLabel,#roleLabel{
text-align: center;
}
#paySlipTitle{
text-align: center;
padding:20px;
}

</style>

<body onload="onLoadGetId()">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3 id="paySlipTitle"></h3>
<br/>
<p id="nameLabel">Name</p><h5 id="name"></h5>
<p id="employeeIdLabel">Employee-ID</p><h5 id="employeeId"></h5>
<p id="roleLabel">Role</p><h5 id="role"></h5>
	<table border="1"  id="paySlipTable" class="table" id="paySlipTable">	
	<caption>PaySlip Of an Employee</caption>
			
		<thead class="thead-dark">
			<tr>
				<th scope="col">Salary Components</th>
				<th scope="col">Monthly (Rs)</th>
		
			</tr>
			
		</thead>
	
		<tbody>
			<tr>
				<td id="heading1">Gross Compensation</td>
			</tr>
			<tr>
				<td>Basic Pay</td>
				<td id="basicPay"></td>
			</tr>
			<tr>
				<td>HRA</td>
				<td id="hra"></td>
			</tr>
			<tr>
				<td>Food Allowance</td>
				<td id="food"></td>
			</tr>
			<tr>
				<td>Medical Allowance</td>
				<td id="medical"></td>
			</tr>
				<tr>
				<td>Travel Allowance</td>
				<td id="travel"></td>
			</tr>
			<tr>
	
				<td id="grossCompensationLabel"><h5>Gross Compensation (A)</h5></td>
				<td id="grossCompensation"></td>
			</tr>
			<tr>
				<td id="heading2">Retiral Benefits</td>
			</tr>
			
			<tr>
				<td>Provident Fund</td>
				<td id="pf"></td>
			</tr>
			<tr>
				<td id="ctcLabel" >Cost To the Company (CTC=A+B)</td>
				<td id="ctc"></td>
			</tr>		
		</tbody>
	</table>


</main>

<script>

/**
 *This method fetches the payroll data for a specifice employee from the servlet 
 *and gets a json data from the servlet, and writes those json data to the html. 
 */
function getPaySlipFromController(employeeId){
	
	let url ="employee/v1/GetEmployeePaySlip?employeeId="+employeeId;
	
	
	//fetch(url,{method:'post'}).then(res=> res.json()).then(res=>{
	//let data = res;
	axios.get(url).then(res=>{
		
		console.log(res);
		
		for(let payData of data){
			document.getElementById('name').innerHTML = (payData.employee.name);
			document.getElementById('employeeId').innerHTML = (payData.employee.employeeID);
			document.getElementById('role').innerHTML = (payData.employee.role);
			document.getElementById('basicPay').innerHTML = (payData.basicPay);
			document.getElementById('hra').innerHTML = (payData.hraAllowance);
			document.getElementById('pf').innerHTML = (payData.pfAllowance);
			document.getElementById('food').innerHTML = (payData.foodAllowance);
			document.getElementById('travel').innerHTML = (payData.travelAllowance);
			document.getElementById('medical').innerHTML = (payData.medicalAllowance);
			document.getElementById('grossCompensation').innerHTML = (payData.salary);
			document.getElementById('pf').innerHTML = (payData.pfAllowance);
			document.getElementById('ctc').innerHTML = (payData.ctc);
			document.getElementById('paySlipTitle').innerHTML = "Pay Slip of "+(payData.employee.employeeID);
		}
		console.log("pay slip data");
		console.log(data);
	});
}

/**
 * This method gets the parameter from the url and calls the fetch function as parameter.
 */
function onLoadGetId(){
	
	let params = new URLSearchParams(window.location.search);
	let employeeId = params.get('employeeId');
	
	getPaySlipFromController(employeeId);
	
}
</script>

<body>

</body>
</html>
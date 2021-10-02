<!DOCTYPE html>

<%@page import="java.util.List"%>

<%@page import="java.time.LocalDate"%>
<%@page import="java.util.HashMap"%>

<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Salary Modification</title>
</head>

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
<body onload="dropDownDisplay()">

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<div class="d-flex justify-content-center">
		<h3>Pay Roll - Portal</h3>
	</div>
	

	
	
<form action="AddPayServlet" id="AddPayServlet" method="post">
	
	<%String infoMessage = request.getParameter("infoMessage");
	  String errorMessage = request.getParameter("errorMessage");
	  if(infoMessage!=null){
		  out.println("<font color='green'>"+infoMessage+"</font>");
	  }else if(errorMessage!=null){
		  out.println("<font color='red'>"+errorMessage+"</font>");
	  }
	
	%>
	<div class="row">
		<div class="col">
			<label>Role </label>
			<select name = "Role" id = "Role" onchange="displayRoleBasedPay()" class="form-control form-control-sm" style="width:180px;"  >
				<option value="Technical Consultant" >Technical Consultant </option>
				<option value="HR" >HR </option>
				<option value="System Administration" >System Administration</option>
				<option value="PL SQL" >PL SQL </option>
				<option value="Software Developer" >Software Developer </option>
				<option value="UI-Designer" >Ui-Designer</option>
			</select>
		</div>
		</div>
		
	<div class="row-xs-2">
	 	<div class="col-xs-2">
	 		<input type="hidden" id="roleForOnLoad" name = "roleForOnLoad" value="" ></input>
			<label>Basic pay</label> <a href="#" onclick ="activate('basicPay')">Edit</a>
			<input type="number" name="basicPay" id="basicPay" class="form-control form-control-sm" style="width:180px;"   placeholder="Basic pay" readonly value="">
	  </div>
	</div>
	
	 <div class="col-xs-2">
	 
			<label>HRA </label> <a href="#" onclick ="activate('hra')">Edit</a>
			<input type="number" name="hra"  id="hra"   class="form-control form-control-sm" style="width:180px;"  value="" readonly placeholder="HRA" >
	  </div>
	  
	  <div class="col-xs-2">
	 
				<label>PF Percentage </label> <a href="#" onclick ="activate('pfPercentage')">Edit</a>
				<input type="number" name="pfPercentage"  id="pfPercentage"  class="form-control form-control-sm" style="width:180px;"   value="" readonly placeholder="PF Percentage" >
	  </div>
	  <div class="row-xs-2">
	 
				<label>PF </label>
				<input type="number" name="pf"  id="pf"  class="form-control form-control-sm" style="width:180px;"   value="" readonly placeholder="PF" >
	 
	  </div>
	  <div class="col-xs-2">
			<label>Food Allowance </label> <a href="#" onclick ="activate('foodAllowance')">Edit</a>
			<input type="number" name="foodAllowance"  id="foodAllowance" class="form-control form-control-sm" style="width:180px;"  value="" readonly placeholder="Food allowance" >
	  </div>
	   <div class="col-xs-2">
			<label>Medical Allowance </label> <a href="#" onclick ="activate('medicalAllowance')">Edit</a>
			<input type="number" name="medicalAllowance"  id="medicalAllowance" class="form-control form-control-sm" style="width:180px;"  value="" readonly placeholder="Medical Allowance" >
	  </div>
	  
	   <div class="col-xs-2">
			<label>Travel Allowance </label> <a href="#" onclick ="activate('travelAllowance')">Edit</a>
			<input type="number" name="travelAllowance" id="travelAllowance" class="form-control form-control-sm" style="width:180px;"  value="" readonly placeholder="Travel Allowance" >
	  </div>
	  
	   <div class="col-xs-2">
			<label id="estimatedSalaryLabel">Gross Compensation</label> 
			<input type="number" name="estimatedSalary" id="estimatedSalary" class="form-control form-control-lg" style="width:180px;"  value="" readonly placeholder="Gross compensation" >
	  </div>
	  
	  <div class="col-xs-2">
			<label id="ctcLabel">CTC</label> 
			<input type="number" name="ctc" id="ctc" class="form-control form-control-lg" style="width:180px;"  value="" readonly placeholder="CTC" >
	  </div>
	 
	  <br/>
	  
	<div class="row">
		<div class="form-group col-md-2">
			<button class="btn btn-success" id="saveButton" onclick="saveRole()" style="visibility: hidden;width:180px;">Save Changes</button><br>
		</div>
	</div>
	<div class="row">
		<div class="form-group col-md-2">
			<a href="adminPortal.jsp" >Admin portal</a><br>
		</div>
	</div>
	
	
	
	<br/>

</form>
</main>



<script type="text/javascript" >
/**
 * This Method uses json strings to assign values to the textboxes which are recieved from the servlet.
 */
function getSalaryDataForRole(roleToDisplay){
	
	console.log("Fetching PayRoll Data");
	let url = "AddPayServlet?roleToDisplay="+roleToDisplay;
	fetch(url).then(res=> res.json()).then(res=>{
		console.log(res);
		let payRollData = res;
		for(let data of payRollData){
	
			document.getElementById('Role').value = (data.role);
			document.getElementById('basicPay').value = (data.basicPay);
			document.getElementById('hra').value = (data.hraAllowance);
			document.getElementById('pfPercentage').value = (data.pfPercentage);
			document.getElementById('pf').value = (data.pfAllowance);
			document.getElementById('foodAllowance').value = (data.foodAllowance);
			document.getElementById('medicalAllowance').value = (data.medicalAllowance);
			document.getElementById('travelAllowance').value = (data.travelAllowance);
			document.getElementById('estimatedSalary').value = (data.salary);
			document.getElementById('ctc').value = (data.ctc);
			
		}
	})
}
/**
 * This method is used to make a button visible when a edit link is clicked
 * This method also changes a text box from readmode to write mode on a click on edit link
 */
function activate(id){

	document.getElementById(id).readOnly=false;
	document.getElementById("saveButton").style.visibility="visible";
}
/**
 * This method loads when the jsp file is executed to run which initializes the first time values into the textboxes.
 */
function dropDownDisplay(){
	let roleOnSubmit = localStorage.getItem("ROLE_ON_SUBMIT");
	if(roleOnSubmit==null){
		getSalaryDataForRole("Technical Consultant");
	}
	else{
		getSalaryDataForRole(roleOnSubmit);
	}

}

/**
 * This method calls a method which displays the selected role's data.
 */
function displayRoleBasedPay(){
	let roleToDisplay = document.getElementById('Role').value;
	getSalaryDataForRole(roleToDisplay);
}
/**
 * This method saves the last edit payroll data so next time when the portal opens it displays the data of the recently changed role.
 */
function saveRole(){
	let roleOnSubmit = document.getElementById('Role').value;
	localStorage.setItem("ROLE_ON_SUBMIT",roleOnSubmit);
}
</script>

</body>
</html>
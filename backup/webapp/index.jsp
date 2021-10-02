<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE>
<html lang="en">
<head>
<link rel="stylesheet" href="assets/css/index.css">
<title>Employee Payroll</title>
</head>
<style>


.page-title{
font-weight:bold;
font-size:20px;
position: absolute;
left: auto;
top: 500px;
}

.companyLogo{
width:500;
height:500;
display: block;
position:absolute;
top:-30px;
left:31%;

}
.productName{
font-weight:bold;
font-size:50px;
border:5px solid orange;
border-radius:50px;
padding:30px;
position: absolute;
left: auto;
top: 350px;
}


</style>
<body>
<%session.invalidate(); %>
	<jsp:include page="header.jsp"></jsp:include>
	<br/>
	<main class="container-fluid">
	<div class="d-flex justify-content-center">
		<img class="companyLogo" alt="Company LOGO" src="assets/images/logo-l10.png" >
	</div>
	<div class="d-flex justify-content-center">
			<h3 class="productName" class="gradient-border">L10-PAYROLL</h3>
		</div>
	<div class="d-flex justify-content-center">
			<h3 class="page-title">Payroll and Employee Management corner</h3>
		</div>
	</main>


<script type="text/javascript">
const [entry] = performance.getEntriesByType("navigation");

if (entry["type"] === "back_forward"){
 location.reload();
 }
</script>
</body>
</html>

<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css" integrity="sha256-mmgLkCYLUQbXn0B1SRqzHar6dCnv9oZFPEC1g1cwlkk=" crossorigin="anonymous" />
<link rel="stylesheet" href="assets/css/adminPortal.css">


<title>Admin portal</title>
</head>
<body>


<jsp:include page="header.jsp"></jsp:include>
	<div class="pageTitle" class="d-flex justify-content-center">
	 	<h4 class="pageTitleText">Admin Portal</h4>
	 </div>
	

	<main class="container-fluid">
	

<div class="d-flex justify-content-center">
	<div class="col-md-10 ">
    <div class="row ">
        <div class="col-xl-4 col-lg-6">
            <div class="card l-bg-cherry">
                <div class="card-statistic-3 p-4">
                     <div class="card-icon card-icon-large"><em class="fas fa-user-plus"></em></div>
                    	<div class="mb-4">
                    	<a class="card-block stretched-link text-decoration-none" href="registerEmployee.jsp"></a>
                    	 	<h5 class="cardTitle">Register Employee</h5>
                   		</div>
                	 </div>
           	 	</div>
        	</div>
        <div class="col-xl-4 col-lg-6">
            <div class="card l-bg-blue-dark" >
                <div class="card-statistic-3 p-4" >
                      <div class="card-icon card-icon-large"><em class="fas fa-users"></em></div>
                      <div class="mb-4">
                   	<a class="card-block stretched-link text-decoration-none" href="displayAllEmployees.jsp"></a>
                    	 	<h5 class="cardTitle">Display Employees</h5>
                   	</div>
                   
                </div>
            </div>
        </div>
        
        <div class="col-xl-4 col-lg-6">
            <div class="card l-bg-green-dark">
                <div class="card-statistic-3 p-4">
                       <div class="card-icon card-icon-large"><em class="fas fa-hand-holding-usd"></em></div>
                    	<div class="mb-4">
                   		<a class="card-block stretched-link text-decoration-none" href="addSalary.jsp"></a>
                    	 	<h5 class="cardTitle">Pay-Roll Portal</h5>
                   		</div>
                    </div>
                </div>
            </div>
        </div>
     </div>
</div>


</main>


<script>

/**
 * This method gets the parameter from the url and calls the fetch function as parameter.
 */

localStorage.setItem("ADMIN","Admin");
if(localStorage.getItem("ADMIN")==null){
	window.location.href="index.jsp";
}
/**
 * This block of code automatically makes the page to reload whenever navigated
 */ 
const [entry] = performance.getEntriesByType("navigation");
if (entry["type"] === "back_forward")
location.reload();
</script>

</body>
</html>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>


<style>
#userId{
font-size:16px;
color:black;
font-weight:bold;
border:1px solid white;
background-color:white;
border-radius:10%;
margin-top:3px;
margin-left:3px;
opacity:0.8;
padding:5px;
}
</style>
<link rel="icon" type="image/png" href="/assets/images/logo-l10.png"/>
<header>


<nav class="navbar navbar-expand-sm navbar-dark bg-dark">

<c:if test="${ADMIN==null}">

  <a class="navbar-brand" href="index.jsp">L10-PayRoll</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
    
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
    </ul>
   </c:if>
   
   <c:if test="${ADMIN!=null}">
    <a class="navbar-brand" href="adminPortal.jsp">PayRoll-App</a>
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="adminPortal.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
    </ul>
   </c:if>

     <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
    <c:if test="${ADMIN==null}">
      <li class="nav-item active">
        <a class="nav-link" href="adminLogin.jsp">Login</a>
      </li>
    </c:if>
  	<c:if test="${ADMIN!=null}">
      <li class="nav-item">
        <a class="nav-link" href="" onclick="confirmLogout()">Logout</a>
       </li>
       <li>
       	<a class="nav-link" href="registerEmployee.jsp">Register Employee</a>
      </li>
       <label id="userId"><c:out value="${ADMIN}"/></label>
      </c:if>
      </ul>
      
   
<script>
function confirmLogout(){
	if(confirm("Are you sure want to Logout")){
		event.preventDefault();
		let url = "user/v1/LogoutUser";
		axios.get(url).then(res=>{
			if(res.data){
				window.localStorage.clear();
				window.location.href="index.jsp";
			}
		});
		
	}else{
		event.preventDefault();
	} 	
}
</script>
   

 
</nav>
</header>

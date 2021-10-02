<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">


<style>
#userId{
font-size:16px;
color:white;
border:1px solid white;
border-radius:10%;
margin-top:10px;
padding:5px;

}
</style>
<%
String employeeLoginId = (String)session.getAttribute("EMPLOYEE_LOGIN_USERNAME");
%>

<header>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="employeePortal.jsp">L10-Payroll</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavId">
    <%if(employeeLoginId != null){ %>
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="employeePortal.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
    </ul>
   <%}%>

     <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
  
    
  	<%if(employeeLoginId!=null){ %>
      <li class="nav-item">
        <a class="nav-link" onclick="confirmLogout()" href="LogoutServlet">Logout</a>
       </li>
      </ul>
       <label id="userId"><%=employeeLoginId %></label>
   <%} %>

   
  </div>
</nav>
<script>
function confirmLogout(){
	if(confirm("Are you sure want to Logout")){
		window.localStorage.clear();
	}else{
		event.preventDefault();
	} 	
}
</script>
</header>

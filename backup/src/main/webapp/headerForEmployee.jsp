<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">

<%
String employeeLoginId = (String)session.getAttribute("EMPLOYEE_LOGIN_USERNAME");
%>

<header>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="index.jsp">PayRoll-App</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavId">
    <%if(employeeLoginId == null){ %>
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
    </ul>
   <%}%>

     <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
  
    
  	<%if(employeeLoginId!=null){ %>
      <li class="nav-item">
        <a class="nav-link" href="LogoutServlet">Logout</a>
       </li>
      </ul>
   <%} %>

   
  </div>
</nav>
</header>

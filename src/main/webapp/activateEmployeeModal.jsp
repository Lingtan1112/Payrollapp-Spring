<!DOCTYPE html>
<html lang="en">
<head>
  <title>Activate Employee</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.css">
  <script src="https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.js"></script>	
</head>
<body>
<button type="button" class="btn btn-info btn-lg" id="activateBtn">Open Modal</button>
<div class="container">
  
  <div class="modal fade" id="activateEmployee" role="dialog">
    <div class="modal-dialog modal-sm">
    
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Activate Employee</h4>
        </div>
        <div class="modal-body">
          <input type="text" name="employeeId" class="form-control form-control-sm" id="employeeId" placeholder="Enter an Employee-ID"  autofocus>
        </div>
        <div class="modal-footer">
        <button type="button" class="btn btn-success" onclick="activateEmployee()" data-dismiss="modal">Activate</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</div>
<script>

$(document).ready(function(){
	console.log("hello");
	  $("#activateBtn").click(function(){
		  console.log("helloy");
	    $("#activateEmployee").modal();
	  });
});
/*function activateEmployee(){
	event.preventDefault();
	let employeeId = $("#employeeId").val();
	let url = "employee/v1/ActivateEmployee?employeeID="+employeeId;	
	axios.put(url).then(res=>{
		if(res){
			let notyf = new Notyf({
				ripple:false,
				duration:3000,
				dismissible:true,
				position:{x:'right',y:'top'}
			});notyf.success("Successfully Activated");
		}
		console.log(res);
	}).catch(err=>{
		let error = err.response.data;
		console.log(err.response.data);
		let notyf = new Notyf({
			ripple:false,
			duration:3000,
			dismissible:true,
			position:{x:'right',y:'top'}
		});notyf.error(error.errorMessage);
	});
}*/
</script>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="resources/index.js"></script>
  <link rel="stylesheet" href="resources/style.css">
<title>Manage Employees</title>

</head>
<body>

	<h1 class="emp-header-title">Manage Employees</h1>
	
	<h3 class="emp-section-title">Add new employee</h3>
	<div class="mx-10 my-5">
		<form action="register-employee" method="POST" class="emp-add-new-employee-table">
			<div class="emp-add-new-employee-table-container">
				<div class=" emp-table-inner-container">
					<label class="emp-table-inner-container-label" for="nic">NIC</label>
					<input class="  emp-table-inner-container-input" id="nic" name="nic"  type="text"/>
				</div>
				<div class=" emp-table-inner-container">
					<label class="emp-table-inner-container-label" for="name">Name</label>
					<input class="  emp-table-inner-container-input" id="name" name="name"  type="text"/>
				</div>
				<div class=" emp-table-inner-container" ">
					<label class="emp-table-inner-container-label" for="department">Department</label>
					<input class="  emp-table-inner-container-input" id="department" name="department"  type="text"/>
				</div>
				<div class=" emp-table-inner-container">
					<label class="emp-table-inner-container-label"  for="designation">Designation</label>
					<input class="  emp-table-inner-container-input" id="designation" name="designation"  type="text"/>
				</div>
			</div>
			<div class="emp-table-container-button-div">
				<button class="emp-button">Add new employee</button>
			</div>
		</form>
		
		
	</div>
	
	<form class="mx-10" action="load-employees" method="GET">
		<button class="emp-button"> See all Employees</button>
	</form>

</body>
</html>
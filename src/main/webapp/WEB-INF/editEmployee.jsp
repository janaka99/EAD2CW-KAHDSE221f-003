<%@page import="manageEmployee1.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="resources/index.js"></script>
  <link rel="stylesheet" href="../resources/style.css">
<title>Edit Employee</title>

</head>
<body>
<% 
	ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("userList");

		String nic = list.get(0).getNic();
		int id = list.get(0).getId();
		String name = list.get(0).getName();
		String department = list.get(0).getDepartment();
		String designation = list.get(0).getDesignation();

%>

	<h1 class="emp-section-title">Edit Employee</h1>
	<div class="mx-10 my-5">
		<form action="/manageEmployee1/employee/update-employee/?id=<%= id %>" method="POST" class="emp-add-new-employee-table">
			<div class="emp-add-new-employee-table-container">
				<div class=" emp-table-inner-container">
					<label class="emp-table-inner-container-label" for="nic">NIC</label>
					<input class="  emp-table-inner-container-input" id="nic" name="nic" value="<%= nic %>" type="text"/>
				</div>
				<div class=" emp-table-inner-container">
					<label class="emp-table-inner-container-label" for="name">Name</label>
					<input class="  emp-table-inner-container-input" id="name" name="name" value="<%= name %>" type="text"/>
				</div>
				<div class=" emp-table-inner-container">
					<label class="emp-table-inner-container-label" for="department">Department</label>
					<input class="  emp-table-inner-container-input" id="department" name="department" value="<%= department %>"  type="text"/>
				</div>
				<div class=" emp-table-inner-container">
					<label class="emp-table-inner-container-label" for="designation">Designation</label>
					<input class="  emp-table-inner-container-input" id="designation" name="designation" value="<%= designation %>"  type="text"/>
				</div>
			</div>
			<div class="emp-table-container-button-div">
				<button class="emp-button">Update</button>
			</div>
		</form>
		
		
	</div>
	<div class="mx-10 my-10">
		<a class="link" style="margin-right: 40px" href="http://localhost:8080/manageEmployee1/">Home</a>
		<a class="link"  href="http://localhost:8080/manageEmployee1/load-employees?">All Employees</a>
	</div>

</body>
</html>
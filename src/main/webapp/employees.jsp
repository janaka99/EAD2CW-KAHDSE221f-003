<%@page import="manageEmployee1.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../resources/index.js"></script>
  <link rel="stylesheet" href="resources/style.css">
<title>Manage Employees</title>

</head>
<body>


	<h3 class="emp-section-title my-10">All Employees</h3>
	<div class="emp-list-table-container">
		<table class="emp-list-table">
		  <thead class="">
		    <tr>
		      <th scope="col" class="emp-table-list-head">NIC</th>
		      <th scope="col" class="emp-table-list-head">Name</th>
		      <th scope="col" class="emp-table-list-head">Department</th>
		      <th scope="col" class="emp-table-list-head">Designation</th>
		      <th scope="col" class="emp-table-list-head">Joined</th>
		      <th scope="col" class="emp-table-list-head">Take Action</th>
		    </tr>
		  </thead>
		  <tbody>
		  
<% 
	ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("userList");
	for(int i=0; i <list.size() ; i++){	
		int id = list.get(i).getId();
		String nic = list.get(i).getNic();
		String name = list.get(i).getName();
		String department = list.get(i).getDepartment();
		String designation = list.get(i).getDesignation();
		String joinedDate = list.get(i).getJoinedDate();
%>
		    <tr>
		      <th style="font-weight: 500" class="emp-table-list-row"><%= nic %></th>
		      <td class="emp-table-list-row"><%= name %></td>
		      <td class="emp-table-list-row"><%= department %></td>
		      <td class="emp-table-list-row"><%= designation %></td>
		      <td class="emp-table-list-row"><%= joinedDate %></td>
		      <td class="emp-table-list-row " style="display: grid; padding:0; grid-template-columns: 1fr 1fr">
		 
		      <form style="width:100%; " action="employee/update-employee-page" method="GET">
		      <input type="hidden" name="id" value="<%= id %>">
		      	<button class="emp-button-list">Edit</button>
		      
		      </form>
		      	<button onClick="handleDelete('<%= id %>')" class="emp-button-list-red" >Delete</button>

		      </td>
		    </tr>
<%	
	}
%>

		  </tbody>
	</table>
	
	</div>
	<div class="mx-10 my-10">
		<a class="link" href="http://localhost:8080/manageEmployee1/">Home / Add new employee</a>
	</div>
	
	<script >
	
	async function handleDelete(id){
		if(confirm("Are you sure you want to delete this employee!")){
			const result = await fetch("http://localhost:8080/manageEmployee1/employee/delete-employee/?id="+id , {method: 'delete'} )

			window.location.reload();
		}

	}

	</script>
</body>
</html>
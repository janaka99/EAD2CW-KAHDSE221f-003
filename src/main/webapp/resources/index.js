async function fetchEmployees(){
	const users = await fetch("http://localhost:8080/manageEmployee1/load-employees", {method: 'get'} );
	const employees =await users.json();
	console.log(employees)
}


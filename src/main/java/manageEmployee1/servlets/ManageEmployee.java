package manageEmployee1.servlets;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import manageEmployee1.entity.Employee;
import com.db.utils.DbConnection;

@WebServlet(urlPatterns ={"/employee/delete-employee/*","/employee/update-employee-page" ,"/employee/update-employee/*"})
public class ManageEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManageEmployee() {
        super();
        // TODO Auto-generated constructor stub

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	//loading edit employee window
    	String id = req.getParameter("id").toString();
		try {
			Connection con = DbConnection.connectDB();
			String sqlQuery = "select * from employees where id='"+req.getParameter("id").toString()+"'";
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sqlQuery);
			ArrayList<Employee> employees = new ArrayList<>();
            while (result.next()) {
            	 Employee emp = new Employee();
            		emp.setNic( result.getString("emp_nic"));
            		emp.setId( result.getInt("id"));
            		emp.setName( result.getString("emp_name"));
            		emp.setDepartment( result.getString("emp_department"));
            		emp.setDesignation( result.getString("emp_designation"));
            		employees.add(emp);

            }
			req.setAttribute("userList",employees);
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/editEmployee.jsp");
			disp.forward(req, res);

		} catch (Exception e) {
			System.out.println("Something went wrong " + e);
			res.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// Update the existing Employee
		int id = Integer.parseInt(req.getParameter("id"));

		String name = req.getParameter("name");
		String nic = req.getParameter("nic");
		String designation = req.getParameter("designation");
		String department = req.getParameter("department");
		if(nic.isEmpty() == true || name.isEmpty() == true || designation.isEmpty() == true || department.isEmpty() == true) {
			System.out.println("All fields must be Fill");
			res.sendRedirect("index.jsp");
		}else {			
		//DB operation
			try {
				Connection con = DbConnection.connectDB();
		
				String sqlQuery = "update employees set emp_nic='"+ nic +"' , emp_name='"+name+"' ,emp_department='"+ department +
						 "', emp_designation='"+designation+"' where id="+id+"";
				Statement stmt = con.createStatement();
				stmt.executeUpdate(sqlQuery);
		
				res.sendRedirect("/manageEmployee1/load-employees?");
			} catch (Exception e) {
				System.out.println("Something went wrong " + e);
				res.sendRedirect("index.jsp");
			}
			
		}
	}

	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Delete a employee
		String id = req.getParameter("id").toString();

		try {
			Connection cons = DbConnection.connectDB();
	
			String sqlQuerys = "delete from employees where id='"+id+"';";
			Statement stmts = cons.createStatement();
			stmts.executeUpdate(sqlQuerys);
			res.setStatus(200);
		} catch (Exception e) {
			System.out.println("Something went wrong " + e);
			res.sendRedirect("index.jsp");
		}
	}

}

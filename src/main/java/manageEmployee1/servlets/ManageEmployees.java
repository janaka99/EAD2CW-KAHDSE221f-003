package manageEmployee1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(urlPatterns = {"/register-employee" ,"/load-employees"})
public class ManageEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManageEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		try {
			//Create database Connection
			Connection con = DbConnection.connectDB();
			String sqlQuery = "select * ,day(emp_joinedDate) as day,month(emp_joinedDate) as month ,year(emp_joinedDate) as year  from employees";
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sqlQuery);
			ArrayList<Employee> employees = new ArrayList<>();
			// Map the result to Array
            while (result.next()) {
            	 Employee emp = new Employee();
            		emp.setId( result.getInt("id"));
            		emp.setNic( result.getString("emp_nic"));
            		emp.setName( result.getString("emp_name"));
            		emp.setDepartment( result.getString("emp_department"));
            		emp.setDesignation( result.getString("emp_designation"));
            		emp.setJoinedDate(result.getString("year")+"."+result.getString("month")+"."+result.getString("day"));
            		employees.add(emp);

            }
			req.setAttribute("userList",employees);
			
			RequestDispatcher disp = req.getRequestDispatcher("employees.jsp");
			disp.forward(req, res);
		
		} catch (Exception e) {
			System.out.println("Something went wrong " + e);
			res.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
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
			
					String sqlQuery = "insert into employees(emp_nic, emp_name, emp_department, emp_designation) "
								+ "values('"+nic+"','"+name+"','"+department+"','"+designation+"')";
					Statement stmt = con.createStatement();
					stmt.executeUpdate(sqlQuery);
					doGet(req, res);
				} catch (Exception e) {
					System.out.println("Something went wrong " + e);
					res.sendRedirect("index.jsp");
				}
				
			}

	}

}

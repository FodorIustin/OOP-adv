package ro.library.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.library.helpers.DBhelper;
import ro.library.pojo.Employee;

public class EmployeeDao {

	//getById c,returneaza un watch 
			public static Employee getById(int id) throws SQLException,IOException  {
				Connection conn=DBhelper.getConnection();
				String query="select * from  employees where employee_id=?";
				PreparedStatement ps=conn.prepareStatement(query);
				ps.setInt(1, id);
				
				ResultSet rs=ps.executeQuery();		
				while(rs.next()) {
					Employee employee=new Employee(
							rs.getString("first_name"),
							rs.getString("last_name"),							
							rs.getInt("age"),
							rs.getInt("employee_id"));
					DBhelper.closeConnection();
					return employee;
				}
				DBhelper.closeConnection();
				return null;
					
			}
			
			public static ArrayList<Employee> getAllEmployees() throws SQLException {
				
				Connection conn=DBhelper.getConnection();
				String query="select * from employees";
				PreparedStatement ps=conn.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				ArrayList<Employee>employees=new ArrayList<>();
				while(rs.next()) {
					Employee employee=new Employee(
							rs.getString("first_name"),
							rs.getString("last_name"),							
							rs.getInt("age"),
							rs.getInt("employee_id"));
					employees.add(employee);		}
				conn.close();
				return employees;		
			}
			
		public static void create(Employee e) throws SQLException {
				EmployeeDao.create(e.getFirstName(),e.getLastName(), e.getAge(), e.getEmployeeID());
			}
			
			
			public static void create(String firstName,String lastName, int age, int employeeID) throws SQLException {
				// instructiunea sql
				String insert = "insert into employees (first_name,last_name,age,employee_id)" + "value(?,?,?,?)";

				// conexiune
				Connection con = DBhelper.getConnection();

				// prepared statement
				PreparedStatement stmt = con.prepareStatement(insert);
				stmt.setString(1, firstName);
				stmt.setString(2, lastName);
				stmt.setInt(3, age);
				stmt.setInt(4, employeeID);

				// executie stmt
				stmt.executeUpdate();

				DBhelper.closeConnection();
			}

			public static void update(Employee e) throws SQLException {

				String update = "update employees set first_name=?,last_name=?, age=? where employee_id=?";

				// conexiune
				Connection con = DBhelper.getConnection();

				// prepared statement
				PreparedStatement stmt = con.prepareStatement(update);
				stmt.setString(1, e.getFirstName());
				stmt.setString(2, e.getLastName());
				stmt.setInt(3, e.getAge());
				stmt.setInt(4, e.getEmployeeID());

				// executie stmt
				stmt.executeUpdate();

				DBhelper.closeConnection();
			}

			public static void delete(Employee e) throws SQLException {
				EmployeeDao.delete(e.getEmployeeID());
			}

			public static void delete(int id) throws SQLException {
				String delete = "delete from employees where employee_id=?";
				// conexiune
				Connection con = DBhelper.getConnection();

				// prepared statement
				PreparedStatement stmt = con.prepareStatement(delete);
				stmt.setInt(1, id);

				// executie stmt
				stmt.executeUpdate();

				DBhelper.closeConnection();
			}
}

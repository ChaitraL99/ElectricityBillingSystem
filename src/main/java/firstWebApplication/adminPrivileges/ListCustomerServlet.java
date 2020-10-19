package firstWebApplication.adminPrivileges;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstWebApplication.adminPrivileges.CustomerService;

@WebServlet(urlPatterns = "/list-customers.do")

public class ListCustomerServlet extends HttpServlet {

	private String jdbcURL = "jdbc:mysql://localhost:3306/electricity?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	
	private static final String SELECT_ALL_USERS = "select * from customers";
	
	private CustomerService customerService = new CustomerService();

	protected Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Customer> users = new ArrayList<>();
				
				try {
					Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
					System.out.println(preparedStatement);
					ResultSet rs = preparedStatement.executeQuery();

					while (rs.next()) {
						String name = rs.getString("name");
						String state = rs.getString("state");
						int meterNo = rs.getInt("meter_no");
						
						users.add(new Customer(name,state,meterNo));
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				request.setAttribute("customers", customerService.retrieveCustomers(users));
				
		request.getRequestDispatcher("/WEB-INF/views/list-customers.jsp").forward(request, response);
	}
}

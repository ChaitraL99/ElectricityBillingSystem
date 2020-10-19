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

@WebServlet(urlPatterns = "/add-customer.do")

public class AddCustomerServlet extends HttpServlet {

	private String jdbcURL = "jdbc:mysql://localhost:3306/electricity?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_USERS = "INSERT INTO customers" + "  (name, password, state) VALUES" + "(?, ?, ?);";
	private static final String GET_CUST_ID = "SELECT cust_id from customers where name=?";
	private static final String LIST_STATES = "select state from price";
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	
	Connection connection = getConnection();
	PreparedStatement preparedStatement;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> states = new ArrayList<String>();
		
		try {
			preparedStatement = connection.prepareStatement(LIST_STATES);
			ResultSet rs = preparedStatement.executeQuery();
	
			while (rs.next()) {
				String state = rs.getString("state");
				states.add(state);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("states", states);
		request.getRequestDispatcher("/WEB-INF/views/add-customer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String state = request.getParameter("state");
		
		int custId=0;

			
			try {
				
				preparedStatement = connection.prepareStatement(INSERT_USERS);
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, password);
				preparedStatement.setString(3, state);
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
				
				preparedStatement = connection.prepareStatement(GET_CUST_ID);
				preparedStatement.setString(1, name);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					custId = rs.getInt("cust_id");
				}
				System.out.println(custId);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		response.sendRedirect("/list-customers.do");
	}
}

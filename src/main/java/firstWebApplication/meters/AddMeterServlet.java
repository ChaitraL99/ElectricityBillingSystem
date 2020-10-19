package firstWebApplication.meters;

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

@WebServlet(urlPatterns = "/add-meter.do")

public class AddMeterServlet extends HttpServlet {

	private String jdbcURL = "jdbc:mysql://localhost:3306/electricity?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_METERS = "INSERT INTO meters" + "  (meter_no, cust_id) VALUES" + "(?, ?);";
	private static final String UPDATE_CUSTOMER = "Update customers set meter_no=? where cust_id=?";
	private static final String LIST_CUSTOMERS = "select cust_id from customers";
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
		List<Integer> customerIds = new ArrayList<Integer>();
		
		try {
			
			preparedStatement = connection.prepareStatement(LIST_CUSTOMERS);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int custID = rs.getInt("cust_id");
				customerIds.add(custID);
			}
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		request.setAttribute("customerIds", customerIds);
		
		request.getRequestDispatcher("/WEB-INF/views/add-meter.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String meterNo = request.getParameter("meter_no");
		String custId = request.getParameter("cust_id");
		
			Connection connection = getConnection();
			PreparedStatement preparedStatement;
			
			try {
				
				preparedStatement = connection.prepareStatement(INSERT_METERS);
				preparedStatement.setString(1, meterNo);
				preparedStatement.setString(2, custId);
				preparedStatement.executeUpdate();
				
				preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
				preparedStatement.setString(1, meterNo);
				preparedStatement.setString(2, custId);
				preparedStatement.executeUpdate();
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		response.sendRedirect("/list-meters.do");
	}
}

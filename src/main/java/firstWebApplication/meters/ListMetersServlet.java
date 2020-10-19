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

@WebServlet(urlPatterns = "/list-meters.do")
public class ListMetersServlet extends HttpServlet {

	private String jdbcURL = "jdbc:mysql://localhost:3306/electricity?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	
	private static final String SELECT_ALL_METERS = "select * from meters";
	
	
	private MeterService meterService = new MeterService();

	protected Connection getConnection() {
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Meters> meters = new ArrayList<>();

				
				try {
					Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_METERS);
					System.out.println(preparedStatement);
					ResultSet rs = preparedStatement.executeQuery();

					while (rs.next()) {
						int meterNo = rs.getInt("meter_no");
						int custId = rs.getInt("cust_id");
						meters.add(new Meters(meterNo,custId));
					}
				
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				request.setAttribute("meters", meterService.retrieveMeters(meters));
		
				
		request.getRequestDispatcher("/WEB-INF/views/list-meters.jsp").forward(request, response);
	}
}


package firstWebApplication.customerLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerValidation {

	private String jdbcURL = "jdbc:mysql://localhost:3306/electricity?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String SELECT_USER = "select name,password from customers";

	Connection getConnection() {
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
	
	public boolean isUserValid(String user, String password) {
		String name="";
		String pass="";
		boolean flag=false;
		Connection connection = getConnection();
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					name = rs.getString("name");
					pass = rs.getString("password");
					if(user.equals(name) && password.equals(pass)) {
						flag=true;
						break;
					}
				}
			} catch (SQLException e) {
					e.printStackTrace();
			}
		
		return flag;
	}
}
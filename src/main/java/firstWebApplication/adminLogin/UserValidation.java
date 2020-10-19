package firstWebApplication.adminLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserValidation {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/electricity?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String SELECT_USER_BY_ID = "select name,password from admin where id =?";

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
		Connection connection = getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1, 1);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					name = rs.getString("name");
					pass = rs.getString("password");
				}
			} catch (SQLException e) {
					e.printStackTrace();
			}
		if(user.equals(name) && password.equals(pass)) 
			return true;
		return false;
	}
}
	


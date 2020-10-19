package firstWebApplication.customerPrivileges;

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

@WebServlet(urlPatterns = "/generate-bill.do")

public class GenerateBillServlet extends HttpServlet {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/electricity?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String GET_CUST_ID = "SELECT cust_id, state from customers where meter_no=?;";
	private static final String GET_PRICE = "SELECT pricePerUnit from price where state=?;";
	private static final String INSERT_INVOICE = "INSERT INTO invoice(cust_id,name,state,meter_no,units,pricePerUnit,total_amount)" + " VALUES(?,?,?,?,?,?,?)";
	
	InvoiceService invoiceservice = new InvoiceService();
	
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
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/generate-bill.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String meterNo = request.getParameter("meter_no");
		String units = request.getParameter("units");
		String name = (String) request.getSession().getAttribute("name");
		int custId=0;
		String state="";
		int price=0;
		
		List<Invoice> invoice = new ArrayList<Invoice>();
		
			Connection connection = getConnection();
			PreparedStatement preparedStatement;
			
			try {
				
				preparedStatement = connection.prepareStatement(GET_CUST_ID);
				preparedStatement.setString(1, meterNo);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					custId = rs.getInt("cust_id");
					state = rs.getString("state");
				}
				System.out.println(custId);
				
				preparedStatement = connection.prepareStatement(GET_PRICE);
				preparedStatement.setString(1, state);
				rs = preparedStatement.executeQuery();
				
				while (rs.next()) {
					price = rs.getInt("pricePerUnit");
				}
				
				double totalAmount = Integer.parseInt(units) * price;
				
				request.setAttribute("totalAmount", totalAmount);
				
				preparedStatement = connection.prepareStatement(INSERT_INVOICE);
				preparedStatement.setInt(1, custId);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, state);
				preparedStatement.setString(4, meterNo);
				preparedStatement.setString(5, units);
				preparedStatement.setInt(6, price);
				preparedStatement.setInt(7, (int) totalAmount);
				
				preparedStatement.executeUpdate();
				
				invoice.add(new Invoice(custId,name,state,Integer.valueOf(meterNo),Integer.valueOf(units),Integer.valueOf(price),(int)totalAmount));
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("invoice", invoiceservice.retrieveInvoice(invoice));
			
			request.getRequestDispatcher("/WEB-INF/views/create-invoice.jsp").forward(request, response);
	}
}


package firstWebApplication.adminLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstWebApplication.adminPrivileges.CustomerService;

@WebServlet(urlPatterns="/login.do")

public class LoginServlet extends HttpServlet{

	private UserValidation check = new UserValidation(); 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/mainpage.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		String name = request.getParameter("name");
		String password = request.getParameter("password");
			
			boolean isUserValid = check.isUserValid(name, password);
			
			if(isUserValid) {
				request.getSession().setAttribute("name", name);
				response.sendRedirect("/list-customers.do");
			}
			else {
				request.setAttribute("errorMessage", "Invalid Credentials");
				request.getRequestDispatcher("/WEB-INF/views/mainpage.jsp").forward(request, response);
			}
		
		}
}

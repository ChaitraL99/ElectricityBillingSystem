package firstWebApplication.customerLogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/customer-login.do")
public class CustomerLoginServlet extends HttpServlet {

private CustomerValidation check = new CustomerValidation(); 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/mainpage.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			
		String name = request.getParameter("name");
		String password = request.getParameter("password");
			
			boolean isUserValid = check.isUserValid(name, password);
			
			if(isUserValid) {
				request.getSession().setAttribute("name", name);
				response.sendRedirect("/generate-bill.do");
			}
			else {
				request.setAttribute("errorMessage", "Invalid Credentials");
				request.getRequestDispatcher("/WEB-INF/views/mainpage.jsp").forward(request, response);
			}
		
		}
}


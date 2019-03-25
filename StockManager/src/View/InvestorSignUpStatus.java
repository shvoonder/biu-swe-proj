package View;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.Controller;



/**
 * Servlet implementation class SignupStatus
 */
@WebServlet("/InvestorSignUpStatus")
public class InvestorSignUpStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvestorSignUpStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/InvestorSignUpError.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//UserController.users.put(request.getParameter("user_name"), request.getParameter("password"));
			String email = request.getParameter("user_name");
			String password = request.getParameter("password");
			int risk = Controller.RiskCalc(request);
			int type = 1;
			if (!Controller.createUser(email,password,type,risk))
			{
				doGet(request, response);
			}
			else {
				response.sendRedirect("/StockManager/LoginPage");
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

}

package View;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.Controller;
import Data.dbConnection;
import Model.User;


/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		User user;
		String email = request.getParameter("user_name");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("name",email); 
		try {
			if (Controller.checkExistingUser(email, password))
			{
				user = Controller.getUserByEmail(email);
				session.setAttribute("type",user.getType());
				session.setAttribute("risk",user.getRisk());
				if (user.getType()==0)
				{
					response.sendRedirect("/StockManager/Admin");
				}
				else
				{
					String dash = ((user.getType() == 1) ? "InvestorDash" : "ManagerDash");
					response.sendRedirect("/StockManager/" + dash);
				}
			}
			else
			{
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LoginError.jsp");
				dispatcher.include(request, response);
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		}
}


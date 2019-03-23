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
 * Servlet implementation class NewManager
 */
@WebServlet("/NewManager")
public class NewManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewManager.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//			String email = request.getParameter("user_name");
//			String password = request.getParameter("password");
//			String type = request.getParameter("type");
//			int risk = 0;
//			userService.registerManager(email, password,Integer.parseInt(type),risk);

	}

}

package View;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.Controller;
import Model.Portfolio;
import Model.Stock;

/**
 * Servlet implementation class UserMain
 */
@WebServlet("/InvestorDash")
public class InvestorDash extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvestorDash() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response, int risk) throws ServletException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{ 
		response.setContentType("text/html;charset=UTF-8"); 
		try (PrintWriter out = response.getWriter()) { 

		// List to hold Student objects 
		List<Portfolio> investorPortfolios = new ArrayList<Portfolio>();
		investorPortfolios = Controller.getPortfolioByRisk(risk);
		if (investorPortfolios.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/InvestorDashError.jsp");  
			rd.include(request, response); 
		}
		// Setting the attribute of the request object which will be later fetched by a JSP page 
		request.setAttribute("portfolio", investorPortfolios);
		// Creating a RequestDispatcher object to dispatch 
		// the request the request to another resource 
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/InvestorDash.jsp");  
		rd.include(request, response); 
		} 
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);  
		PrintWriter out = response.getWriter();
		int risk = (int) session.getAttribute("risk");
		int type = (int) session.getAttribute("type");
		if (type == 1)
		{
			try {
				processRequest(request, response, risk);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			out.println("Error!");
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int risk = Integer.parseInt(request.getParameter("risk"));
		try {
			processRequest(request, response, risk);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

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
import Model.StockCalc;
import java.lang.Math;

/**
 * Servlet implementation class ManagerDash
 */
@WebServlet("/ManagerDash")
public class ManagerDash extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerDash() {
        super();
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String userName) throws ServletException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{ 
		response.setContentType("text/html;charset=UTF-8"); 
		try (PrintWriter out = response.getWriter()) { 

		// List to hold Student objects 
		List<Stock> stocks = new ArrayList<Stock>(); 
		stocks = Controller.getAllStocks();
		List<Portfolio> managerPortfolios = new ArrayList<Portfolio>();
		managerPortfolios = Controller.getPortfolioByName(userName);
		// Setting the attribute of the request object which will be later fetched by a JSP page 
		request.setAttribute("data", stocks); 
		request.setAttribute("portfolio", managerPortfolios);
		// Creating a RequestDispatcher object to dispatch 
		// the request the request to another resource 
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ManagerDash.jsp");  
		rd.include(request, response); 
		} 
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);  
		PrintWriter out = response.getWriter();
		String userName = (String) session.getAttribute("name");
		int type = (int) session.getAttribute("type");
		if (type == 2)
		{
			try {
				processRequest(request, response, userName);
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
		String[] stockNameFromForm = request.getParameterValues("allStocks"); // The stocks from manager
		int chosenRisk = Integer.parseInt(request.getParameter("risk")); // The risk from manager
		HttpSession session=request.getSession(true);  
		String userName = (String) session.getAttribute("name");
		List<Stock> stockList = new ArrayList<Stock>(); // List of manager chosen stocks
		List<StockCalc> stockCalcList = new ArrayList<StockCalc>(); // data for chosen stock (for E,V calc)
		if (stockNameFromForm.length==2) {
			for (int i=0; i < stockNameFromForm.length ; i++) // Init lists from DB stocks
			{
					try {
						stockList.add(Controller.getStock(stockNameFromForm[i])); 
						stockCalcList.add(Controller.getStockFromCalc(stockNameFromForm[i]));
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			try {
				stockList.add(Controller.getStock("risklessStock")); // Adds the riskless stock to the list for later calculation
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double per1,per2,per3,calcReturns,sharpVal; 
			String stock1,stock2,stock3;
			stock1 = stockList.get(0).getName();
			stock2 = stockList.get(1).getName();
			stock3 = stockList.get(2).getName();
			if (stockList.get(2).getReturns() > stockList.get(0).getReturns() && (stockList.get(2).getReturns() > stockList.get(1).getReturns())) // If the riskless stock returns is better, choose her
			{
				try {
					Controller.createPortfolio(userName , chosenRisk, stockList.get(2).getReturns(), 0, stock1, stock2, stock3, 0, 0, 100);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else if (stockList.get(0).getReturns() < 0) // If the riskless stock returns is better, choose her
			{
				per1 = 0;
				per2 = (chosenRisk*20);
				per3 = (1 - ((double)chosenRisk*20)/100)*100;
				calcReturns = per2*stockList.get(1).getReturns() + per3*stockList.get(2).getReturns();
				sharpVal = (stockList.get(1).getReturns() - stockList.get(2).getReturns())/stockList.get(1).getRisk();
				try {
					Controller.createPortfolio(userName , chosenRisk, calcReturns , sharpVal, stock1, stock2, stock3, per1, per2, per3);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else if (stockList.get(1).getReturns() < 0) // If the riskless stock returns is better, choose her
			{
				per1 = (chosenRisk*20);
				per2 = 0;
				per3 = (1 - ((double)chosenRisk*20)/100)*100;
				calcReturns = per1*stockList.get(0).getReturns() + per3*stockList.get(2).getReturns();
				sharpVal = (stockList.get(0).getReturns() - stockList.get(2).getReturns())/stockList.get(0).getRisk();
				try {
					Controller.createPortfolio(userName , chosenRisk, calcReturns , sharpVal, stock1, stock2, stock3, per1, per2, per3);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else if (Double.compare(stockList.get(0).getRisk(),stockList.get(1).getRisk()) == 0)
			{
				if (stockList.get(0).getReturns() > stockList.get(1).getReturns())
				{
					per1 = (chosenRisk*20);
					per2 = 0;
					per3 = (1 - ((double)chosenRisk*20)/100)*100;
					calcReturns = per1*stockList.get(0).getReturns() + per3*stockList.get(2).getReturns();
					sharpVal = (stockList.get(0).getReturns() - stockList.get(2).getReturns())/stockList.get(0).getRisk();
					try {
						Controller.createPortfolio(userName , chosenRisk, calcReturns , sharpVal, stock1, stock2, stock3, per1, per2, per3);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					per1 = 0;
					per2 = (chosenRisk*20);
					per3 = (1 - ((double)chosenRisk*20)/100)*100;
					calcReturns = per2*stockList.get(1).getReturns() + per3*stockList.get(2).getReturns();
					sharpVal = (stockList.get(1).getReturns() - stockList.get(2).getReturns())/stockList.get(1).getRisk();
					try {
						Controller.createPortfolio(userName , chosenRisk, calcReturns , sharpVal, stock1, stock2, stock3, per1, per2, per3);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			else if (Double.compare(stockList.get(0).getReturns(),stockList.get(1).getReturns()) == 0)
			{
				if (stockList.get(0).getRisk() > stockList.get(1).getRisk())
				{
					per1 = 0;
					per2 = (chosenRisk*20);
					per3 = (1 - ((double)chosenRisk*20)/100)*100;
					calcReturns = per2*stockList.get(1).getReturns() + per3*stockList.get(2).getReturns();
					sharpVal = (stockList.get(1).getReturns() - stockList.get(2).getReturns())/stockList.get(1).getRisk();
					try {
						Controller.createPortfolio(userName , chosenRisk, calcReturns , sharpVal, stock1, stock2, stock3, per1, per2, per3);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					per1 = (chosenRisk*20);
					per2 = 0;
					per3 = (1 - ((double)chosenRisk*20)/100)*100;
					calcReturns = per1*stockList.get(0).getReturns() + per3*stockList.get(2).getReturns();
					sharpVal = (stockList.get(0).getReturns() - stockList.get(2).getReturns())/stockList.get(0).getRisk();
					try {
						Controller.createPortfolio(userName , chosenRisk, calcReturns , sharpVal, stock1, stock2, stock3, per1, per2, per3);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			else // Else, one or both stocks returns are better then the riskless stock.
			{
				double cov = 0;
				for (int q=0;q<11;q++) // Cov calculation
				{
					cov += ((stockCalcList.get(0).getValues(q))*(stockCalcList.get(1).getValues(q))); // E[XY]
				}
				cov = cov/11 -((stockList.get(0).getReturns())*(stockList.get(1).getReturns()));
				double[][] arr = new double[1001][4]; // Init points 2D array (choose which weights to calculation)
				int k=0;
				for (int j = 1000 ; j >= 0 ; j = j-1)
				{
					double d = (double)j/1000;
					arr[k][0] = d; // Stock A weight
					arr[k][1] = 1-d; // Stock B weight
					arr[k][2] = ((d)*(stockList.get(0).getReturns()))+((1-d)*(stockList.get(1).getReturns())); // Avg return
					double x = (Math.pow(d, 2))*stockList.get(0).getRisk(); //1st element of risk calculation
					double y = (Math.pow((1-d),2)*stockList.get(1).getRisk()); //2nd element of risk calculation
					double z = (2*d*(1-d)*cov); // 3rd element of risk calculation
					arr[k][3] = x+y+z; // Risk calculation
					k++;
				}
				double minRisk= 5000; // Choose only the upper values of the points
				int minRiskIndex = -1;
				for (int i=0;i<1001;i++) {
					if (arr[i][3] < minRisk)
					{
						minRisk = arr[i][3];
						minRiskIndex = i; // Gets the index of the minimum risk
					}	
				}
				System.out.println("min risk :" + minRiskIndex);
				System.out.println("the cov is: " + cov);
				double[] slope = new double[2]; // Find the best weights for the stocks
				slope[0]=400; // slope
				slope[1]=-1; // weights index (percentage of each stock)
				double newSlope;
				double sharpValue = 0;
				if (minRiskIndex!=1000) {
					for (int i=0 ;i<1000;i++) { // Find the best slope with the non-risk stock
						newSlope = Math.abs((arr[i][2]-arr[i+1][2])/(arr[i][3]-arr[i+1][3])-(arr[i][2]- stockList.get(2).getReturns() )/arr[i][3]);
						if (slope[0] > newSlope && (arr[i][2] >= arr[minRiskIndex][2]) && (arr[i][2] > stockList.get(2).getReturns() ))
						{
							slope[0] = newSlope;
							slope[1] = i;
							sharpValue = (arr[i][2]-arr[i+1][2])/(arr[i][3]-arr[i+1][3]);
						}
					}
				}
				else
				{
					slope[1] = minRiskIndex;
					sharpValue = (arr[minRiskIndex][2]-stockList.get(2).getReturns())/(arr[minRiskIndex][3]);
				}
				System.out.println("slope: " + slope[0] + " i: " + slope[1]);
	
				per1 = (arr[(int)slope[1]][0])*(chosenRisk*20);
				per2 = (arr[(int)slope[1]][1])*(chosenRisk*20);
				per3 = (1 - ((double)chosenRisk*20)/100)*100;
	
				try {
					Controller.createPortfolio(userName , chosenRisk, (arr[(int)slope[1]][2]), sharpValue, stock1, stock2, stock3, per1, per2, per3);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("the cov is: " + cov);
				System.out.println("slope: " + slope[0] + " i: " + slope[1]);
				for (int t=0;t<1001;t++) {
					for (int s=0;s<4;s++)
					{
						System.out.print(arr[t][s] + " ");	
					}
					System.out.println();
				}
			}		
			doGet(request, response);
		}
		doGet(request, response);
	}
	
}

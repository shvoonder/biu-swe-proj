package Controller;

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

import DB.DBconnection;
import Model.Task;

@WebServlet("/ManagerPage")
public class Admin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Admin() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            // List to hold Student objects
            List<Task> stocks = new ArrayList<Stock>();
            stocks = Controller.getAllStocks();

            // Setting the attribute of the request object which will be later fetched by a JSP page
            request.setAttribute("data", stocks);

            // Creating a RequestDispatcher object to dispatch
            // the request the request to another resource
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Admin.jsp");
            rd.include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(true);
        PrintWriter out = response.getWriter();
        int type = (int) session.getAttribute("type");
        if (type == 0)
        {
            try {
                processRequest(request, response);
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


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            String name = request.getParameter("name");
            double[] values = new double[12]; // Stock 12 values for every stock month
            double returns = 0;
            double risk = 0;
            double t=11;
            values[0] = Double.parseDouble(request.getParameter("first"));
            values[1] = Double.parseDouble(request.getParameter("second"));
            values[2] = Double.parseDouble(request.getParameter("third"));
            values[3] = Double.parseDouble(request.getParameter("fourth"));
            values[4] = Double.parseDouble(request.getParameter("fifth"));
            values[5] = Double.parseDouble(request.getParameter("sixth"));
            values[6] = Double.parseDouble(request.getParameter("seventh"));
            values[7] = Double.parseDouble(request.getParameter("eighth"));
            values[8] = Double.parseDouble(request.getParameter("nineth"));
            values[9] = Double.parseDouble(request.getParameter("tenth"));
            values[10] = Double.parseDouble(request.getParameter("eleventh"));
            values[11] = Double.parseDouble(request.getParameter("twelvth"));

            for (int i=0 ;i<11;i++) // Find stock risk and returns
            {
                returns += (Math.log(values[(i+1)]/values[i]))/t; // E[X]
                risk += Math.pow(Math.log(values[(i+1)]/values[i]),2)/t; // E[X^2]
            }

            for (int i=0 ;i<11;i++) // Init values in DB for later use in finding the best slope
            {
                values[i] = (Math.log(values[(i+1)]/values[i]));
            }

            try {
                Controller.addValuesToStock(name, values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10]); // DB store
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            risk = risk - Math.pow(returns, 2); // VAR[X] (E[X^2]-E^2[X])

            try {
                Controller.addStock(name, risk, returns); // Add stock risk and returns to DB
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            doGet(request, response);
        }
    }
}

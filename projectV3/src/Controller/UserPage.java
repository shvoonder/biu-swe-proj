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
import DB.DBconnection.*;
import Model.Task;
import Model.User;

@WebServlet("/UserPage")
public class UserPage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserPage() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
    {
        HttpSession session=request.getSession(true);
        User user = DBconnection.getUserByUserName(session.getAttribute("username").toString());
        List<Task> tasks = DBconnection.getTasksByUser(user.getId());
        request.setAttribute("tasks", tasks);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/homeScreen.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        }
        catch (ServletException | IOException | InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        }
        catch (ServletException | IOException | InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
}

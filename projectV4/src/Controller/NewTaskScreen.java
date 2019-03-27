package Controller;

import DB.DBconnection;
import Model.PriorityType;
import Model.Project;
import Model.Task;
import Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/NewTaskScreen")
public class NewTaskScreen extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public NewTaskScreen() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(true);
        if (session.getAttribute("username") == null){
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/LoginError.jsp");
            rd.forward(request,response);
        }
        try {
            request.setAttribute("users", DBconnection.getUserListArr());
            User MostAvalible = DBconnection.getMostAvailableUser();
            System.out.println(MostAvalible);
            request.setAttribute("most_available", DBconnection.getMostAvailableUser());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NewTaskScreen.jsp");
        rd.forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(true);
        String task = (String)request.getParameter("taskName");
        String priority = (String)request.getParameter("priority");
        String user_string = (String)request.getParameter("user");
        try {
            User user = DBconnection.getUserById(Integer.parseInt(user_string));
            PriorityType priorityType = DBconnection.getPriorityTypeById(Integer.parseInt(priority));
            String project = (String)session.getAttribute("project");
            DBconnection.addTask(user.getId(), task, Integer.parseInt(priority), Integer.parseInt(project));
            response.sendRedirect("ProjectScreen" + "?project=" + Integer.parseInt(project));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

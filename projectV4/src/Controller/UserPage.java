package Controller;

import DB.DBconnection;
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
import java.util.List;

@WebServlet("/UserPage")
public class UserPage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserPage() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(true);
        if (session.getAttribute("username") == null){
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/LoginError.jsp");
            rd.forward(request,response);
        }
        User user = null;
        try {
            user = DBconnection.getUserByUserName(session.getAttribute("username").toString());
            System.out.println(user.getId());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Task> tasks = null;
        try {
            tasks = DBconnection.getTasksByUser(user.getId());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        request.setAttribute("tasks", tasks);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/UserPage.jsp");
        rd.forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int task = Integer.parseInt(request.getParameter("task"));
        int newStatus = Integer.parseInt(request.getParameter("new_status"));
        try {
            DBconnection.updateTaskStatus(task, newStatus);
            response.sendRedirect("UserPage");
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

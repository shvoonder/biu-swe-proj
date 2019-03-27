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
import java.util.List;

@WebServlet("/TaskScreen")
public class TaskScreen extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TaskScreen() {
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Task task = null;
        try {
            task = DBconnection.getTaskById(Integer.parseInt(request.getParameter("task")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        request.setAttribute("task", task);
        try {
            request.setAttribute("users", DBconnection.getUserListArr());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session.setAttribute("project", task.getProject());
        session.setAttribute("task", task.getId());
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/TaskScreen.jsp");
        rd.forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession(true);
        int task_id = (int)session.getAttribute("task");
        String task = (String)request.getParameter("taskName");
        String priority = (String)request.getParameter("priority");
        String user_string = (String)request.getParameter("user");
        try {
            User user = DBconnection.getUserById(Integer.parseInt(user_string));
            PriorityType priorityType = DBconnection.getPriorityTypeById(Integer.parseInt(priority));
            DBconnection.updateTask(task_id, task, priorityType, user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Project project = (Project)session.getAttribute("project");
        response.sendRedirect("ProjectScreen" + "?project=" + project.getId());
    }
}

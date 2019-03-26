package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.DBconnection;
import Model.PriorityType;
import Model.Project;
import Model.User;

@WebServlet("/NewProjectName")
public class NewProjectName extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public NewProjectName() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(true);
        if (session.getAttribute("username") == null){
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/LoginError.jsp");
            rd.forward(request,response);
        }
        User user = (User)session.getAttribute("user");
        List<Project> projects = null;
        try {
            projects = DBconnection.getProjectsByUserID(user.getId());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        request.setAttribute("projects", projects);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/NewProjectName.jsp");
        rd.include(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            DBconnection.createProject(request.getParameter("projectName"), DBconnection.getPriorityTypeById(Integer.parseInt(request.getParameter("priority"))), (User) session.getAttribute("user"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("ManagerPage");
    }
}
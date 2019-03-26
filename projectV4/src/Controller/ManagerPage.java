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
import Model.Project;

@WebServlet("/ManagerPage")
public class ManagerPage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ManagerPage() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
    {
        HttpSession session=request.getSession(true);
        User user = DBconnection.getUserByUserName(session.getAttribute("username").toString());
        List<Project> projects = DBconnection.getProjectsByUserID(user.getId());
        request.setAttribute("projects",projects );
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/MainManager.jsp");
      rd.forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

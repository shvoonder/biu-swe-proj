package Controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;
import DB.DBconnection;

@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginPage() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("web/WEB-INF/Login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        User user;
        String userName = request.getParameter("user");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("userName",userName);
        try {
            if (DBconnection.checkLogin(userName, password))
            {
                user = DBconnection.getUserByUserName(userName);
                session.setAttribute("isAdmin",user.isIs_admin());
                if (user.isIs_admin() == true) {
                    response.sendRedirect("projV2/ManagerPage");
                }
                else
                    response.sendRedirect("projV2/UserPage");
            }
            else
            {
                dispatcher = request.getRequestDispatcher("/WEB-INF/LoginError.jsp");
                dispatcher.include(request, response);
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
package Controller;

import  java.io.IOException;
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

        try {
            DBconnection.CreateAndConnect();
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        User user;
        String userName = request.getParameter("user");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        try {
            if (DBconnection.checkLogin(userName, password))
            {
                System.out.println("User OK");
                user = DBconnection.getUserByUserName(userName);
                session.setAttribute("username",userName);
                session.setAttribute("isAdmin", user.isisAdmin());
                session.setAttribute("user", user);
                if (user.isisAdmin() == true) {
                    dispatcher = request.getRequestDispatcher("UserPage");
                    dispatcher.forward(request, response);
                }
                else
                    dispatcher = request.getRequestDispatcher("UserPage");
                    dispatcher.forward(request, response);
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
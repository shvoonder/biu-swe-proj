package Controller;

import DB.DBconnection;
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

@WebServlet("/SignupPage")
public class SignupPage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SignupPage() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/signup.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DBconnection.CreateAndConnect();
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        User user;
        Boolean isAdminBool = true;
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String userName = request.getParameter("user_name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String isAdmin = request.getParameter("is_admin");
        if (isAdmin == "null"){
            isAdminBool = false;
            System.out.println("got not admin");
        }
        try {
            if (!DBconnection.createUser(userName, password, isAdminBool, firstName, lastName, email)){
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/signup.jsp");
                request.setAttribute("error", true);
                dispatcher.forward(request, response);
            }
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e){
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
        dispatcher.forward(request, response);

    }
}

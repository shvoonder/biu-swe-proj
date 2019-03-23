package DB;

import java.sql.*;

public class DBconnection {

    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String CONN = "jdbc:mysql://localhost:3306/SE_proj";

    public static Connection getConnection () throws SQLException {
       return DriverManager.getConnection(CONN, USERNAME, PASSWORD);
    }

    public static void CreateAndConnect () throws SQLException {
            try (
                    Connection con = getConnection();
                    Statement stmt = con.createStatement();
                    ResultSet rs = null;
            )
            {}
        }

    public static void main()
    }
}

}

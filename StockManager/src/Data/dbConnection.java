package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.mysql.jdbc.PreparedStatement;

import Model.User;
import Model.Stock;

public class dbConnection {
	
	public static void createDB() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		ResultSet rs = null;
		int flag=0;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn1=null;
		Connection conn2=null;
	    String db = "jdbc:mysql://localhost:3306";
	    String dbUrl = "jdbc:mysql://localhost:3306/users_data";
	    String sqlCreateUsers = "CREATE TABLE users (ID INT NOT NULL AUTO_INCREMENT, username VARCHAR(30) NOT NULL, password VARCHAR(30) NOT NULL, type VARCHAR(20) NOT NULL, risk INT(11) NOT NULL, PRIMARY KEY (ID))";
	    String sqlCreateStocks = "CREATE TABLE stocks (ID int NOT NULL AUTO_INCREMENT, stockname VARCHAR(30) NOT NULL, risk DOUBLE NOT NULL,"
	    		+ " returns DOUBLE NOT NULL, PRIMARY KEY ( ID ))";
	    String sqlCreateStockCalc = "CREATE TABLE stockcalc (name VARCHAR(30) NOT NULL, first DOUBLE NOT NULL, second DOUBLE NOT NULL, third DOUBLE NOT NULL, fourth DOUBLE NOT NULL, fifth DOUBLE NOT NULL,"
	    		+ " sixth DOUBLE NOT NULL, seventh DOUBLE NOT NULL, eighth DOUBLE NOT NULL, ninth DOUBLE NOT NULL, tenth DOUBLE NOT NULL, eleventh DOUBLE NOT NULL)";
	    String sqlCreatePortfolio = "CREATE TABLE portfolio (ID int NOT NULL AUTO_INCREMENT, managerName VARCHAR(30) NOT NULL, risk int(11) NOT NULL, returns DOUBLE NOT NULL,sharp DOUBLE NOT NULL,"
	    		+ " stock1 VARCHAR(30) NOT NULL, percentage1 DOUBLE NOT NULL, stock2 VARCHAR(30) NOT NULL, percentage2 DOUBLE NOT NULL, stock3 VARCHAR(30) NOT NULL, percentage3 INT(11) NOT NULL, PRIMARY KEY (ID))";
	    conn1 = DriverManager.getConnection(db, "root", "");
		String dbName = "users_data";
		rs = conn1.getMetaData().getCatalogs();
		while (rs.next())
		{
			String catalog = rs.getString(1);
			if (dbName.equals(catalog))
			{
				flag = 1;
			}
		}
		if (flag == 0)
		{
			Statement state = conn1.createStatement();
			state.executeUpdate("CREATE DATABASE " + dbName);
			conn2 = DriverManager.getConnection(dbUrl, "root", "");
			Statement state2 = conn2.createStatement();
			state2.executeUpdate(sqlCreateUsers);
			state2.executeUpdate(sqlCreateStocks);
			state2.executeUpdate(sqlCreateStockCalc);
			state2.executeUpdate(sqlCreatePortfolio);
			createUser("admin","123",0,-1);
			initStockDB();
		}
	}
	
	public static void initStockDB() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	    String dbUrl = "jdbc:mysql://localhost:3306/users_data";
	    Connection conn = DriverManager.getConnection(dbUrl, "root", "");
		Statement state = conn.createStatement();
		// All stocks relevant to January 2018 - December 2018, data taken from "Israeli Stock Exchange website"
		String addStockCalc1 = "INSERT INTO `stockcalc`(`name`, `first`, `second`, `third`, `fourth`, `fifth`, `sixth`, `seventh`, `eighth`, `ninth`, `tenth`, `eleventh`)"
		  		+ " VALUES ('Leumi',-0.077453,0.05039,-0.032623,-0.009954,0.05209732,0.0628009,-0.02874941,0.04273566,0.00896021,0.00142214,0.00237473)";
		String addStockCalc2 = "INSERT INTO `stockcalc`(`name`, `first`, `second`, `third`, `fourth`, `fifth`, `sixth`, `seventh`, `eighth`, `ninth`, `tenth`, `eleventh`)"
		  		+ " VALUES ('Poalim',-0.07531534,0.01183446,-0.05556985,-0.01416349,0.04040572,0.04734612,0.00567262,-0.00202963,0.02546339,-0.03514869,-0.02772455)";
		String addStockCalc3 = "INSERT INTO `stockcalc`(`name`, `first`, `second`, `third`, `fourth`, `fifth`, `sixth`, `seventh`, `eighth`, `ninth`, `tenth`, `eleventh`)"
		  		+ " VALUES ('Nice',-0.0621737,0.0817576,-0.0424434,-0.0089513,0.0365461,0.0583788,0.0093123,0.0914683,0.0470781,-0.0400234,0.0823561)";
		String addStockCalc4 = "INSERT INTO `stockcalc`(`name`, `first`, `second`, `third`, `fourth`, `fifth`, `sixth`, `seventh`, `eighth`, `ninth`, `tenth`, `eleventh`)"
		  		+ " VALUES ('Perrigo',0.483289,0.093231,0.004997,0.079925,0.035128,-0.08819,-0.00337,0.066643,0.015299,-0.00762,0.068204)";
		String addStockCalc5 = "INSERT INTO `stockcalc`(`name`, `first`, `second`, `third`, `fourth`, `fifth`, `sixth`, `seventh`, `eighth`, `ninth`, `tenth`, `eleventh`)"
		  		+ " VALUES ('Teva',0.31791107,-0.0819262,0.07107349,0.05644743,0.03654544,-0.00768661,-0.1149654,-0.16388786,-0.09811472,0.11051845,0.06277999)";
		String addStockCalc6 = "INSERT INTO `stockcalc`(`name`, `first`, `second`, `third`, `fourth`, `fifth`, `sixth`, `seventh`, `eighth`, `ninth`, `tenth`, `eleventh`)"
		  		+ " VALUES ('Discount',-0.1057929,0.0543699,0.0032922,-0.0380151,0.0826917,0.083569,-0.0074697,0.0733212,-0.0069826,0.0059821,-0.0237165)";
		String addStockCalc7 = "INSERT INTO `stockcalc`(`name`, `first`, `second`, `third`, `fourth`, `fifth`, `sixth`, `seventh`, `eighth`, `ninth`, `tenth`, `eleventh`)"
		  		+ " VALUES ('ICL',-0.0251527,0.01296314,-0.0339016,0.05224206,0.18279628,0.04964523,0.01023181,0.021401,0.08914873,-0.0080754,0.03478018)";
		String addStockCalc8 = "INSERT INTO `stockcalc`(`name`, `first`, `second`, `third`, `fourth`, `fifth`, `sixth`, `seventh`, `eighth`, `ninth`, `tenth`, `eleventh`)"
		  		+ " VALUES ('Elbit',-0.05930681,0.022223137,-0.03575751,-0.00863563,0.055692694,0.024618752,0.00303278,0.027236734,-0.01074637,-0.1655547,-0.03869413)";
		String addStockCalc9 = "INSERT INTO `stockcalc`(`name`, `first`, `second`, `third`, `fourth`, `fifth`, `sixth`, `seventh`, `eighth`, `ninth`, `tenth`, `eleventh`)"
		  		+ " VALUES ('Mizrahi',-0.0675136,0.07482565,-0.0164561,-0.0212724,-0.0915461,0.06009028,-0.0140441,0.03298068,-0.0168501,0.03971614,-0.0337308)";
		String addStockCalc10 = "INSERT INTO `stockcalc`(`name`, `first`, `second`, `third`, `fourth`, `fifth`, `sixth`, `seventh`, `eighth`, `ninth`, `tenth`, `eleventh`)"
		  		+ " VALUES ('Bezeq',-0.159226,0.0004674,0.0224569,-0.029909,0.1027858,-0.05673,-0.05759,-0.040895,0.0137444,-0.173728,-0.057419)";
		state.executeUpdate(addStockCalc1);
		state.executeUpdate(addStockCalc2);
		state.executeUpdate(addStockCalc3);
		state.executeUpdate(addStockCalc4);
		state.executeUpdate(addStockCalc5);
		state.executeUpdate(addStockCalc6);
		state.executeUpdate(addStockCalc7);
		state.executeUpdate(addStockCalc8);
		state.executeUpdate(addStockCalc9);
		state.executeUpdate(addStockCalc10);
		String addStock1 = "INSERT INTO `stocks`(`stockname`, `risk`, `returns`) VALUES ('Leumi',0.00169353,0.00654545)";
		String addStock2 = "INSERT INTO `stocks`(`stockname`, `risk`, `returns`) VALUES ('Poalim',0.00137213,-0.00720266)";
		String addStock3 = "INSERT INTO `stocks`(`stockname`, `risk`, `returns`) VALUES ('Nice',0.0027633,0.0230278)";
		String addStock4 = "INSERT INTO `stocks`(`stockname`, `risk`, `returns`) VALUES ('Perrigo',0.019662,-0.06796)";
		String addStock5 = "INSERT INTO `stocks`(`stockname`, `risk`, `returns`) VALUES ('Teva',0.01636666,-0.0171541)";
		String addStock6 = "INSERT INTO `stocks`(`stockname`, `risk`, `returns`) VALUES ('Discount',0.0031062,0.0110227)";
		String addStock7 = "INSERT INTO `stocks`(`stockname`, `risk`, `returns`) VALUES ('ICL',0.0033448,0.03509807)";
		String addStock8 = "INSERT INTO `stocks`(`stockname`, `risk`, `returns`) VALUES ('Elbit',0.00324571,-0.01689919)";
		String addStock9 = "INSERT INTO `stocks`(`stockname`, `risk`, `returns`) VALUES ('Mizrahi',0.00244479,-0.0048909)";
		String addStock10 = "INSERT INTO `stocks`(`stockname`, `risk`, `returns`) VALUES ('Bezeq',0.0056279,-0.03964)";
		String addStock11 = "INSERT INTO `stocks`(`stockname`, `risk`, `returns`) VALUES ('risklessStock',0,0.0005)";
		state.executeUpdate(addStock1);
		state.executeUpdate(addStock2);
		state.executeUpdate(addStock3);
		state.executeUpdate(addStock4);
		state.executeUpdate(addStock5);
		state.executeUpdate(addStock6);
		state.executeUpdate(addStock7);
		state.executeUpdate(addStock8);
		state.executeUpdate(addStock9);
		state.executeUpdate(addStock10);
		state.executeUpdate(addStock11);
	}
	
	public static boolean createUser (String username,String password, int type, int risk) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
	      String dbUrl = "jdbc:mysql://localhost:3306/users_data";
	      Connection conn = DriverManager.getConnection(dbUrl, "root", "");
		  Statement state = conn.createStatement();
		  if (!checkSignUpUser(username))
		  {
			  int rs = state.executeUpdate("INSERT INTO `users`(`username`, `password`,`type`, `risk`) VALUES (\""+username+"\",\""+password+"\",\""+type+"\",\""+risk+"\")");
		      if(rs!=0)
		    	  return true;
		  }
	      return false;
	}
	
	public static boolean checkSignUpUser (String username) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		ResultSet rs=dbConnection.getAllUsers();
		while(rs.next())
		{
			if(rs.getString("userName").equals(username))
				return true;
		}
		return false;
	}
	
	public static boolean checkExistingUser (String username, String password) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		ResultSet rs=dbConnection.getAllUsers();
		while(rs.next())
		{
			if(rs.getString("userName").equals(username) && rs.getString("password").equals(password))
				return true; // If user exists and password doesn't match...
		}
		return false;
	}
	
	public static User getUserByEmail(String email) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		User user;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	    String myUrl = "jdbc:mysql://localhost:3306/users_data";
	    Connection conn = DriverManager.getConnection(myUrl, "root", "");
		Statement st = conn.createStatement();
	    ResultSet rs = st.executeQuery("SELECT * FROM users ");
	    while (rs.next())
	    {
	    	if (rs.getString("userName").equals(email))
	    	{
	    		if (Integer.parseInt(rs.getString("type")) == 2)
	    		{
	    			String pass = rs.getString("password");
	    			String type = rs.getString("type");
	    			int risk = 0;
	    			user = new User(email, pass,Integer.parseInt(type),risk);
	    		}
	    		else
	    		{
	    			String pass = rs.getString("password");
	    			String risk = rs.getString("risk");
	    			String type = rs.getString("type");
	    			user = new User(email,pass,Integer.parseInt(type),Integer.parseInt(risk));
	    		}
	    		return user;
	    	}
	    }
		return null;
	}
	
	public static ResultSet getAllUsers() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	      String myUrl = "jdbc:mysql://localhost:3306/users_data";
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
		  Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery("SELECT * FROM users ");
	      return rs;
	}
	
	public static ResultSet getAllStocks() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	      String myUrl = "jdbc:mysql://localhost:3306/users_data";
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
		  Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery("SELECT * FROM stocks ");
	      return rs;
	}
	
	public static ResultSet getStock(String name) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	      String myUrl = "jdbc:mysql://localhost:3306/users_data";
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
		  Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery("SELECT * FROM stocks WHERE stockname = \""+name+"\" ");
	      return rs;
	}
	
	public static boolean checkExistingStock (String name) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		ResultSet rs=dbConnection.getAllStocks();
		while(rs.next())
		{
			if(rs.getString("stockname").equals(name))
				return true;
		}
		return false;
	}
	
	public static boolean addStock (String name, double risk, double returns) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
	      String dbUrl = "jdbc:mysql://localhost:3306/users_data";
	      Connection conn = DriverManager.getConnection(dbUrl, "root", "");
		  Statement state = conn.createStatement();
		  if (!checkExistingStock(name))
		  {
			  int rs = state.executeUpdate("INSERT INTO `stocks`(`stockname`, `risk`,`returns`) VALUES (\""+name+"\",\""+risk+"\",\""+returns+"\")");
		      if(rs!=0)
		    	  return true;
		  }
		  else 
		  {
			  String update = "UPDATE stocks SET risk = \""+risk+"\" , returns = \""+returns+"\" WHERE stockname = \""+name+"\" ";
			  int rs = state.executeUpdate(update);
		      if(rs!=0)
		    	  return true;
		  }
	      return false;
	}
	
	public static ResultSet getAllStocksCalc() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	      String myUrl = "jdbc:mysql://localhost:3306/users_data";
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
		  Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery("SELECT * FROM stockcalc ");
	      return rs;
	}
	
	public static boolean createPortfolio (String managerName, int risk, double returns, double sharp, String stock1, String stock2, String stock3, double percentage1, double percentage2, double percentage3) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
	      String dbUrl = "jdbc:mysql://localhost:3306/users_data";
	      Connection conn = DriverManager.getConnection(dbUrl, "root", "");
		  Statement state = conn.createStatement();
		  int rs = state.executeUpdate("INSERT INTO `portfolio`(`managerName`, `risk`, `returns`, `sharp`, `stock1`, `stock2`, `stock3`, `percentage1`,`percentage2`, `percentage3`)"
		  		+ " VALUES (\""+managerName+"\",\""+risk+"\",\""+returns+"\",\""+sharp+"\",\""+stock1+"\",\""+stock2+"\",\""+stock3+"\",\""+percentage1+"\",\""+percentage2+"\",\""+percentage3+"\")");
		  if(rs!=0)
			  return true;
	      return false;
	}
	
	public static ResultSet getPortfolioByRisk (int risk) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
	      String dbUrl = "jdbc:mysql://localhost:3306/users_data";
	      Connection conn = DriverManager.getConnection(dbUrl, "root", "");
		  Statement state = conn.createStatement();
		  ResultSet rs = state.executeQuery("SELECT * FROM portfolio WHERE risk = \""+risk+"\" ");
		  return rs;
	}
	
	public static ResultSet getPortfolioByName (String managerName) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
	      String dbUrl = "jdbc:mysql://localhost:3306/users_data";
	      Connection conn = DriverManager.getConnection(dbUrl, "root", "");
		  Statement state = conn.createStatement();
		  ResultSet rs = state.executeQuery("SELECT * FROM portfolio WHERE managerName = \""+managerName+"\" ");
		  return rs;
	}
	
	public static boolean checkExistingStockCalc (String name) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		ResultSet rs=dbConnection.getAllStocksCalc();
		while(rs.next())
		{
			if(rs.getString("name").equals(name))
				return true;
		}
		return false;
	}
	
	public static boolean addValuesToStock (String name, double a, double b, double c,double d, double e,double f,double g,double h, double i,double j,double k) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
	      String dbUrl = "jdbc:mysql://localhost:3306/users_data";
	      Connection conn = DriverManager.getConnection(dbUrl, "root", "");
		  Statement state = conn.createStatement();
		  if (!checkExistingStockCalc(name))
		  {
			  int rs = state.executeUpdate("INSERT INTO `stockcalc`(`name`, `first`, `second`, `third`, `fourth`, `fifth`, `sixth`, `seventh`, `eighth`, `ninth`, `tenth`, `eleventh`)"
			  		+ " VALUES (\""+name+"\",\""+a+"\",\""+b+"\",\""+c+"\",\""+d+"\",\""+e+"\",\""+f+"\",\""+g+"\",\""+h+"\",\""+i+"\",\""+j+"\",\""+k+"\")");
		      if(rs!=0)
		    	  return true;
		  }
		  else 
		  {
			  String update = "UPDATE stockcalc SET first = \""+a+"\" , second = \""+b+"\", third = \""+c+"\", fourth = \""+d+"\", fifth = \""+e+"\", sixth = \""+f+"\", seventh = \""+g+"\", eighth = \""+h+"\","
			  		+ " ninth = \""+i+"\", tenth = \""+j+"\", eleventh = \""+k+"\" WHERE name = \""+name+"\" ";
			  int rs = state.executeUpdate(update);
		      if(rs!=0)
		    	  return true;
		  }
	      return false;
	}
	
	public static ResultSet getStockFromCalc (String name) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	      String myUrl = "jdbc:mysql://localhost:3306/users_data";
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
		  Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery("SELECT * FROM stockcalc WHERE name = \""+name+"\" ");
	      return rs;
	}

	public static boolean removeStock (String name) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		return false;
	// ADD
	}
	
	public static boolean addPortfolio (String managerName, List<String> name, List<Integer> weights) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		
		return false;
	// ADD
	}
	
	public static boolean checkExistingPortfolio (String name) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		
		return false;
	// ADD
	}
	
	public static boolean getAllPortfoliosByName (String name) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		
		return false;
	// ADD
	}
	
	public static boolean getAllPortfolios (String name) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		
		return false;
	// ADD
	}
	
}

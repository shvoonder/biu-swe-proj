package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Data.dbConnection;
import Model.User;
import Model.Stock;
import Model.StockCalc;
import Model.Portfolio;

public class Controller {
	
	public static void initDB () throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		dbConnection.createDB();
	}
	
	public static boolean createUser (String username,String password, int type, int risk) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		if (!dbConnection.createUser(username, password, type, risk))
			return false;
		return true;
	}
	
	public static boolean checkExistingUser (String username, String password) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		
		if (dbConnection.checkExistingUser(username, password))
			return true;
		return false;
	}
	
	public static User getUserByEmail(String email) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		return dbConnection.getUserByEmail(email);
	}
	
	public static int RiskCalc (HttpServletRequest request) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		int sum = 0;
		int risk = 0;
		Set<String> notNeeded = new HashSet(Arrays.asList("user_name","name","password"));
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String param = e.nextElement();
			if (notNeeded.contains(param)) continue;
			sum += Integer.parseInt(request.getParameter(param));
		}
		// Change if has time
		if (sum>=0 && sum <=20) {
			risk = 1;
		}
		if (sum>=21 && sum <=30) {
			risk = 2;
		}
		if (sum>=31 && sum <=40) {
			risk = 3;
		}
		if (sum>=41 && sum <=50) {
			risk = 4;
		}
		if (sum>=51 && sum <=60) {
			risk = 5;
		}
		return risk;	
	}
	
	public static boolean checkExistingStock (String name) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		if (dbConnection.checkExistingStock(name))
			return true;
		return false;
	}
	
	public static boolean addStock (String name, double risk, double returns) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		if (!dbConnection.addStock(name, risk, returns))
			return false;
		return true;
	}

	public static List<Stock> getAllStocks() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		ResultSet rs = dbConnection.getAllStocks();
		List<Stock> stockList = new ArrayList<Stock>();
		Stock temp;
		while (rs.next())
		{
			temp = new Stock(rs.getString("stockname"),Double.parseDouble(rs.getString("risk")),Double.parseDouble(rs.getString("returns")));
			stockList.add(temp);
		}
		return stockList;
	}
	
	public static Stock getStock(String name) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		ResultSet rs = dbConnection.getStock(name);
		Stock temp;
		rs.next();
		temp = new Stock(rs.getString("stockname"),Double.parseDouble(rs.getString("risk")),Double.parseDouble(rs.getString("returns")));
		return temp;
	}
	
	public static StockCalc getStockFromCalc (String name) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		ResultSet rs = dbConnection.getStockFromCalc(name);
		StockCalc temp;
		rs.next();
		temp = new StockCalc(rs.getString("name"),Double.parseDouble(rs.getString("first")),Double.parseDouble(rs.getString("second")), Double.parseDouble(rs.getString("third")), Double.parseDouble(rs.getString("fourth")), Double.parseDouble(rs.getString("fifth")), Double.parseDouble(rs.getString("sixth")), Double.parseDouble(rs.getString("seventh")),
				Double.parseDouble(rs.getString("eighth")), Double.parseDouble(rs.getString("ninth")), Double.parseDouble(rs.getString("tenth")), Double.parseDouble(rs.getString("eleventh")));
		return temp;
	}
	
	public static boolean addValuesToStock (String name, double a, double b, double c,double d, double e,double f,double g,double h, double i,double j,double k) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (!dbConnection.addValuesToStock(name,a,b,c,d,e,f,g,h,i,j,k))
			return false;
		return true;
	}
	
	public static boolean createPortfolio (String managerName, int risk, double returns, double sharp, String stock1, String stock2, String stock3, double percentage1, double percentage2, double percentage3) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		if (!dbConnection.createPortfolio(managerName, risk, returns, sharp,stock1,stock2,stock3,percentage1,percentage2,percentage3))
			return false;
		return true;
	}
	
	public static List<Portfolio> getPortfolioByRisk (int risk) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		ResultSet rs = dbConnection.getPortfolioByRisk(risk);
		List<Portfolio> portfolioList = new ArrayList<Portfolio>();
		Portfolio temp;
		while (rs.next())
		{
			temp = new Portfolio (rs.getString("managerName"),Integer.parseInt(rs.getString("risk")),Double.parseDouble(rs.getString("returns")), Double.parseDouble(rs.getString("sharp")), rs.getString("stock1"),rs.getString("stock2"), rs.getString("stock3"), Double.parseDouble(rs.getString("percentage1")),
					Double.parseDouble(rs.getString("percentage2")), Double.parseDouble(rs.getString("percentage3")));
			portfolioList.add(temp);
		}
		return portfolioList;
	}
	
	public static List<Portfolio> getPortfolioByName (String managerName) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		ResultSet rs = dbConnection.getPortfolioByName(managerName);
		List<Portfolio> portfolioList = new ArrayList<Portfolio>();
		Portfolio temp;
		while (rs.next())
		{
			temp = new Portfolio (rs.getString("managerName"),Integer.parseInt(rs.getString("risk")),Double.parseDouble(rs.getString("returns")), Double.parseDouble(rs.getString("sharp")), rs.getString("stock1"),rs.getString("stock2"), rs.getString("stock3"), Double.parseDouble(rs.getString("percentage1")),
					Double.parseDouble(rs.getString("percentage2")), Double.parseDouble(rs.getString("percentage3")));
			portfolioList.add(temp);
		}
		return portfolioList;
	}
	
	
}

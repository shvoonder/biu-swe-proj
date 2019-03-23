package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Stock;

public class Portfolio {
		private String managerName;
		private double returns;
		private int risk;
		private double sharp;
		String stock1, stock2, stock3;
		double percentage1, percentage2, percentage3;
				
	public Portfolio(String managerName, int risk, double returns, double sharp, String stock1, String stock2, String stock3, double percentage1, double percentage2, double percentage3) {
		this.managerName = managerName;
		this.returns = returns;
		this.risk = risk;
		this.sharp = sharp;
		this.stock1 = stock1;
		this.stock2 = stock2;
		this.stock3 = stock3;
		this.percentage1 = percentage1;
		this.percentage2 = percentage2;
		this.percentage3 = percentage3;
	}
	
	public String getManagerNamek() {  
	    return managerName;  
	}

	public int getRisk() {  
	    return risk;  
	}
	
	public double getReturns() {  
	    return returns;  
	}
	
	public void setReturns(double returns) {  
	    this.returns = returns;  
	}
	
	public double getSharp() {  
	    return sharp;  
	}
	
	public String getStock1() {  
	    return stock1;  
	}
	
	public String getStock2() {  
	    return stock2;  
	}
	
	public String getStock3() {  
	    return stock3;  
	}
	
	public double getPercentage1() {  
	    return percentage1;  
	}
	
	public double getPercentage2() {  
	    return percentage2;  
	}
	
	public double getPercentage3() {  
	    return percentage3;  
	}
	
}

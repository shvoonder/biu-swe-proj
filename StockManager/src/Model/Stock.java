package Model;

public class Stock {

	private String name;
	private double returns;
	private double risk;
	
	public Stock(String name, double risk, double returns) {
		this.name = name;
		this.risk = risk;
		this.returns = returns;	
	}
	
	public String getName() {  
	    return name;  
	}  
	
	public void setName(String name) {  
	    this.name = name;  
	}  
	
	public Double getRisk() {  
	    return risk;  
	}
	
	public void setRisk(Double risk) {  
	    this.risk = risk;  
	}
	
	public Double getReturns() {  
	    return returns;  
	}
	
	public void setReturns(Double returns) {  
	    this.returns = returns;  
	}
	
}

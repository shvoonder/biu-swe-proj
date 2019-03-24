package Model;

public class User {

	private String email;
	private String password;
	private int type;
	private int risk;
	  
	public User(String email, String password, int type, int risk) {
		// TODO Auto-generated constructor stub
		this.email = email;
		this.password = password;
		this.type = type;
		this.risk = risk;
	}
	
	public String getEmail() {  
	    return email;  
	}
	
	public String getPassword() {  
	    return password;  
	}
	
	public int getType() {  
	    return type;  
	}
	
	public int getRisk() {  
	    return risk;  
	}
	  
}  
	


package co.com.czuluaga.udemy.microservices.rs.model;

public class Ping {
	
	private String message;
	
	public Ping(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

package co.com.czuluaga.udemy.microservices.rs.model.users;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	
	private Long id;
	
	@Size(min = 5, message = "Name should have at least 2 charecters")
	private String name;
	
	@Past
	private Date birthdate;
	
	public User(Long id, String name, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	
}

package co.com.czuluaga.udemy.microservices.rs.service;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import co.com.czuluaga.udemy.microservices.rs.model.users.User;

@Component
public class UserService {
	
	public static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(14568687l, "Carlos Zuluaga", new Date()));
		users.add(new User(67040601l, "Jessica Garces", new Date()));
		users.add(new User(20080415l, "Simon Zuluaga2", new Date()));
	}
	
	
	public List<User> findAll(){
		List<User> u = new ArrayList<User>();
		u.addAll( users );
		return u;
	}
	
	public Optional<User> find(final Long id) {
		return this.users.stream().filter(user -> user.getId().equals(id)).findFirst();
	}
	
	public User save(User user) {
		if(user == null) {
			return null;
		}
		this.users.add( user );
		return user;
	}
}

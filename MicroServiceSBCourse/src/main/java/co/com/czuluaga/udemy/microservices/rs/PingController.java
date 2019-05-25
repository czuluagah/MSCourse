package co.com.czuluaga.udemy.microservices.rs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.czuluaga.udemy.microservices.rs.model.Ping;

@RestController
public class PingController {
	
	@GetMapping(path = "/ping")
	public Ping ping() {
		return new Ping("im alive");
	}
}

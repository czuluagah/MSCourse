package co.com.czuluaga.udemy.microservices.rs.model.users;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.com.czuluaga.udemy.microservices.rs.service.UserService;
import co.com.czuluaga.udemy.microservices.rsexceptions.ResourceNotFoudException;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/users")
	public ResponseEntity<Object> save( @Valid @RequestBody User user) {
		userService.save( user );
		URI resources = ServletUriComponentsBuilder.fromCurrentRequest()
								   .path("/{id}")
								   .buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created( resources ).build();
	}
	
	@GetMapping(path = "/users")
	public List<User> getAllUsers(){
		return userService.findAll();
	}
	
	
	@GetMapping(path = "/users/{id}")
	public EntityModel<User> getAllUsers(@PathVariable(name = "id") Long id){
		
		User user = userService.find( id ).orElseThrow(()-> new ResourceNotFoudException("id:" + id));
		
		EntityModel<User> model = new EntityModel<>(user);
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
		model.add(linkTo.withRel("all-users"));
		
		return model;
	}
}

package ukma.vam.edsystem.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ukma.vam.edsystem.entity.User;
import ukma.vam.edsystem.service.UserService;

@RestController
public class UserRestController {

	@Autowired
    UserService userService;
	
	 @RequestMapping(value = "/user", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder){
		 
		 try {
			userService.create(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 HttpHeaders headers = new HttpHeaders();
	        try {
				headers.setLocation(new URI("/?attention"));
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
	 
	 @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
		 
		 User currentUser = userService.getUserById(id);
		 
		 currentUser.setPassword(user.getPassword());
		 
		 try {
			userService.updatePassword(currentUser);
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		 
		 return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	 }
}

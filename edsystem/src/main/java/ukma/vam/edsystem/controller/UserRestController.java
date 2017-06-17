package ukma.vam.edsystem.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import ukma.vam.edsystem.entity.Chapter;
import ukma.vam.edsystem.entity.Choice;
import ukma.vam.edsystem.entity.Tests;
import ukma.vam.edsystem.entity.Theme;
import ukma.vam.edsystem.entity.User;
import ukma.vam.edsystem.service.ThemeService;
import ukma.vam.edsystem.service.UserService;

@RestController
public class UserRestController {

	@Autowired
    UserService userService;
	
	@Autowired
    ThemeService themeService;
	 
	 @RequestMapping(value = "/themes", method = RequestMethod.GET)
	    public ResponseEntity<List<Theme>> themesPage() {
		 	
		 	List<Theme> themes = themeService.getAllThemes();
		 	
		 	if(themes.isEmpty()){
	            return new ResponseEntity<List<Theme>>(HttpStatus.NO_CONTENT);
	        }
		 
	        return new ResponseEntity<List<Theme>>(themes, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/themes/{theme_id}", method = RequestMethod.GET)
	    public ResponseEntity<List<Chapter>> chaptersPage(@PathVariable("theme_id") long theme_id) {
		 	
		 	List<Chapter> chapters = themeService.getAllChapters(theme_id);
		 	
		 	if(chapters.isEmpty()){
	            return new ResponseEntity<List<Chapter>>(HttpStatus.NO_CONTENT);
	        }
		 
	        return new ResponseEntity<List<Chapter>>(chapters, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/themes/{theme_id}/{chapter_id}", method = RequestMethod.GET)
	    public ResponseEntity<List<Tests>> testsPage(@PathVariable("theme_id") long theme_id, @PathVariable long chapter_id) {
		 	
		 	List<Tests> tests = themeService.getTestsByChapter(chapter_id);
		 	
		 	if(tests.isEmpty()){
	            return new ResponseEntity<List<Tests>>(HttpStatus.NO_CONTENT);
	        }
		 
	        return new ResponseEntity<List<Tests>>(tests, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/themes/{theme_id}/{chapter_id}/{test_id}", method = RequestMethod.GET)
	    public ResponseEntity<List<Choice>> currentTestPage(@PathVariable("theme_id") long theme_id, @PathVariable long chapter_id, @PathVariable long test_id) {
		 	
		 	List<Choice> choices = themeService.getChoices(test_id);
		 	
		 	if(choices.isEmpty()){
	            return new ResponseEntity<List<Choice>>(HttpStatus.NO_CONTENT);
	        }
		 
	        return new ResponseEntity<List<Choice>>(choices, HttpStatus.OK);
	    }
	
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

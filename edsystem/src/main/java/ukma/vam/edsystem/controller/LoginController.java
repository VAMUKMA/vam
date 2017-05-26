package ukma.vam.edsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	/**
	 * main page The main page of site.
	 * 
	 * @param RequestMapping
	 *            URL of main page
	 * @return name of main page
	 * */
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model){
		return "main";
	}
	
}

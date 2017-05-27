package ukma.vam.edsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	/**
	 * main page The main page of site.
	 * 
	 * @param RequestMapping
	 *            URL of main page
	 * @return name of main page
	 * */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String welcomePage(Model model, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "attention", required = false) String attention){
		
		if (error != null) {
			model.addAttribute("msg", "Login/password is invalid");
		}

		if (attention != null) {
			model.addAttribute("msg", "First log in, please");
		}
		
		return "index";
	}
	
}

package ukma.vam.edsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	/**
	 * Deny page - if authenticated users go to page, which is designed for
	 * another role.
	 * 
	 * @param RequestMapping
	 *            URL of deny page
	 * @return name of deny page
	 * */
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		model.addAttribute("title", "403");
		model.addAttribute("head", "Ви не маєте доступу до цієї сторінки!");
		model.addAttribute("img", "/edsystem/resources/img/403.gif");
		return "message";
	}
	
	/**
	 * Error page - if users go to page, which doesn't exist.
	 * 
	 * @param RequestMapping
	 *            URL of error page
	 * @return name of error page
	 * */
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String error404(Model model) {
		model.addAttribute("title", "404");
		model.addAttribute("head", "Цієї сторінки не існує!");
		model.addAttribute("img", "/edsystem/resources/img/404.gif");
		return "message";
	}
	
	/**
	 * Error page - server error.
	 * 
	 * @param RequestMapping
	 *            URL of error page
	 * @return name of error page
	 * */
	@RequestMapping(value = "/500", method = RequestMethod.GET)
	public String error500(Model model) {
		model.addAttribute("title", "500");
		model.addAttribute("head", "Проблеми сервера");
		model.addAttribute("img", "/edsystem/resources/img/404.gif");
		return "message";
	}
	
}

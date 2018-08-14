package tw.elliot.web.ctrl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task/**")
public class TaskCtrl {
	@GetMapping("/index")
	public String index(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (obj instanceof UserDetails) {
			model.addAttribute("user", (UserDetails) obj);
		}

		return "/task/index";
	}
}

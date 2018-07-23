package tw.elliot.web.ctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class DefaultCtrl {

	@Value("${environment}")
	private String environment;

	@GetMapping("/")
	public String index(ModelMap mp) {
		mp.addAttribute("environment", environment);
		return "/index";
	}

}

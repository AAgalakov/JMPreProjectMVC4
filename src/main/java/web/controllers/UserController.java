package web.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public ModelAndView getUserPage(Authentication authentication) {
        return new ModelAndView("userPage", "name", authentication.getName());
    }
}

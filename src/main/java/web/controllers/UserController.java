package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView indexPage() {
        return new ModelAndView("index");
    }

    @GetMapping(path = "/table")
    public ModelAndView getAllUsers() {
        return new ModelAndView("table", "userList", userService.allUsers());
    }

    @PostMapping("/userAdd")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return new ModelAndView("redirect:/table");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return new ModelAndView("redirect:/table");
    }

    @GetMapping("/updateUserForm/{id}")
    public ModelAndView updateUser(@PathVariable("id") int id) {
        return new ModelAndView("updateUserForm", "user", userService.getUserById(id));
    }

    @PostMapping("/editUser")
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return new ModelAndView("redirect:/table", "userList", userService.allUsers());
    }
}

package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.dto.UserDto;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class UserController {

    private static Logger log = Logger.getLogger(UserController.class.getName());

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/login")
    public ModelAndView indexPage() {
        return new ModelAndView("login");
    }

    @RequestMapping(path = "/table")
    public ModelAndView getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userService.allUsers()) {
            userDtoList.add(new UserDto(user));
        }
        return new ModelAndView("table", "userList", userDtoList);

    }

    @RequestMapping(path = "/tableRole")
    public ModelAndView getAllRoles() {
        List<Role> roleList = roleService.allRoles();
        return new ModelAndView("roleTable", "roleList", roleList);
    }

    @PostMapping("/userAdd")
    public ModelAndView addUser(UserDto userDto) {
        if (userService.addUser(userDto)) {
            return new ModelAndView("redirect:/table");
        } else {
            return new ModelAndView("wrongName");
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return new ModelAndView("redirect:/table");
    }

    @GetMapping("/updateUserForm/{id}")
    public ModelAndView updateUser(@PathVariable("id") int id) {
        return new ModelAndView("updateUserForm", "user", new UserDto(userService.getUserById(id)));
    }

    @PostMapping("/editUser")
    public ModelAndView editUser(@ModelAttribute("user") UserDto userDto) {
        if (userService.updateUser(userDto)) {
            return new ModelAndView("redirect:/table", "userList", userService.allUsers());
        } else {
            return new ModelAndView("wrongName");
        }
    }

    @PostMapping("/user")
    public ModelAndView getUserPage(UserDto userDto, Authentication authentication){
        if (authentication == null){
            return new ModelAndView("redirect:/login");
        }
        return new ModelAndView("userPage", "user", userDto);
    }
}

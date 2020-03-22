package web.controllers;

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

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public ModelAndView getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userService.allUsers()) {
            userDtoList.add(new UserDto(user));
        }
        return new ModelAndView("table", "userList", userDtoList);
    }

    @GetMapping(path = "/tableRole")
    public ModelAndView getAllRoles() {
        List<Role> roleList = roleService.allRoles();
        return new ModelAndView("roleTable", "roleList", roleList);
    }

    @PostMapping("/userAdd")
    public ModelAndView addUser(UserDto userDto) {
        if (userService.addUser(userDto)) {
            return new ModelAndView("redirect:/admin");
        } else {
            return new ModelAndView("wrongName");
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return new ModelAndView("redirect:/admin");
    }

    @GetMapping("/updateUserForm/{id}")
    public ModelAndView updateUser(@PathVariable("id") int id) {
        return new ModelAndView("updateUserForm", "user", new UserDto(userService.getUserById(id)));
    }

    @PostMapping("/editUser")
    public ModelAndView editUser(@ModelAttribute("user") UserDto userDto) {
        if (userService.updateUser(userDto)) {
            return new ModelAndView("redirect:/admin", "userList", userService.allUsers());
        } else {
            return new ModelAndView("wrongName");
        }
    }
}

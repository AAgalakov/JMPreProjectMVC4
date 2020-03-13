package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

//@Controller
public class FirstController {

//    //todo сделать через конструктор done
//    private UserService userService;
//
//    public FirstController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/")
//    public String indexPage() {
//        return "index";
//    }
//
//    @GetMapping("/table")
//    public String printFirst(Model model) {
//        List<User> allUsers = userService.allUsers();
//        model.addAttribute("userList", allUsers);
//        return "table";
//        //todo добавить колонки done
//        //todo сделать кнопку done
//        //todo поддержка русского языка done
//    }
//
//
//    // todo @PostMapping использовать, где надо done
//    @PostMapping("/userAdd")
//    public String addUser(@ModelAttribute("user") User user) {
//        userService.addUser(user);
//        return "redirect:/table";
//        //todo возвращать не String, а model and view (везде) done
//    }
//
//
//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") long id) {
//        userService.deleteUser(id);
//        return "redirect:/table";
//    }
//
//    @GetMapping("/updateUserForm/{id}")
//    public String updateUser(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "updateUserForm";
//    }
//
//    @PostMapping("/editUser")//todo писать с использованием слэша done
//    public String editUser(@ModelAttribute("user") User user) {
//        userService.updateUser(user);
//        return "redirect:/table";
//    }
}

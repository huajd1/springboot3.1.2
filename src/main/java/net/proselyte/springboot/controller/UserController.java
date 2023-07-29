package net.proselyte.springboot.controller;

import net.proselyte.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import net.proselyte.springboot.model.User;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getListOfUsers(Model model) {
        List<User> users = userService.getListOfUsers();
        model.addAttribute("users", users);
        return "/index";
    }

    @GetMapping("/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String updateUserForm(Model model, @PathVariable("id") Long id) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "/edit";
    }

    @PostMapping("/{id}")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }
}
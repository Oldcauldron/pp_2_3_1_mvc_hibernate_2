package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping(value = "/users", produces = "text/html; charset=utf-8")
public class UserController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.allUsers()); // for forEach
        model.addAttribute("newUser", new User()); // for POST
        return "users";
    }

    @PostMapping("")
    public String createNewUser(@ModelAttribute User user, Model model) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String getOneUser(@PathVariable("id") int id, Model model ) {
        User user = userService.show(id);
        model.addAttribute("thisUser", user);
        return "user";
    }

    @PatchMapping("/{id}")
    public String editUser(@PathVariable("id") int id, @ModelAttribute User user, Model model) {
        userService.updateUser(id, user.getName(), user.getAge());
        String url = String.format("redirect:/users/%d", user.getId());
        return url;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute User user, @PathVariable("id") int id, Model model) {
        userService.removeUser(id);
        return "redirect:/users";

    }

}

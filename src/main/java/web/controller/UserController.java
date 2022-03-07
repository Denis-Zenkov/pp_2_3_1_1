package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUser(Model model) {
        model.addAttribute("allUser", userService.getUsers());
        return "user";
    }

    @GetMapping("addUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("save", true);
        return "updateUser";
    }

    @GetMapping("saveUser")
    public String saveUser(User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("editUser/{id}")
    public String editUser(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("save", false);
        return "updateUser";
    }

    @PostMapping("editUser/updateUser")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("deleteUser")
    public String edit(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
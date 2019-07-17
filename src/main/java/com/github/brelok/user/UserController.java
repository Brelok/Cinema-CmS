package com.github.brelok.user;

import ch.qos.logback.classic.util.LoggerNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("users", userService.findAllDtoDisplay());
        return "users";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("user", new UserDtoSave());
        return "user_add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("userDto")@Valid UserDtoSave userDtoSave){
    userService.createUser(userDtoSave);
    return "redirect:/user";
    }

    @GetMapping("/delete")
    public String delete (@RequestParam Long id){
        userService.delete(userService.findOne(id));
        return "redirect:/user";
    }

    @GetMapping("/edit")
    public String edit (Model model, @RequestParam Long id){
        model.addAttribute("user", userService.findOneUserDto(id));
        return "user_edit";
    }

    @PostMapping("/edit")
    public String edit (@ModelAttribute(name = "userDto")@Valid UserDtoSave userDtoSave){
        userService.edit(userDtoSave);
        return "redirect:/user";
    }
}

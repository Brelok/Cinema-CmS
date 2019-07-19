package com.github.brelok.security;

import com.github.brelok.user.User;
import com.github.brelok.user.UserServiceS;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {

    private final UserServiceS userServiceS;

    public SecurityController(UserServiceS userServiceS) {
        this.userServiceS = userServiceS;
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setLogin("admin");
        user.setPassword("admin");
        userServiceS.saveUser(user);
        return "admin";
    }
}

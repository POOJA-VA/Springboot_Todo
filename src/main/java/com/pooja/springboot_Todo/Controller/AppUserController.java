package com.pooja.springboot_Todo.Controller;

import com.pooja.springboot_Todo.model.AppUser;
import com.pooja.springboot_Todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class AppUserController {

    @Autowired
    public UserService userService;

    @PostMapping("/login")
    public AppUser login(@RequestBody AppUser appUser){
        return userService.login(appUser);
    }

    @PostMapping("/register")
    public AppUser register(@RequestBody AppUser appUser){
        return userService.register(appUser);
    }
}
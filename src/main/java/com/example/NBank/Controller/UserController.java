package com.example.NBank.Controller;

import com.example.NBank.Model.User;
import com.example.NBank.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public boolean criarUser(@RequestBody User user){
        return userService.criarUser(user);
    }

    @PostMapping("login")
    public ResponseEntity<User> login(@RequestBody User user){
        return userService.login(user);
    }
}

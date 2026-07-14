package userregistration.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import userregistration.entity.User;
import userregistration.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public String register(@RequestBody User user){

        service.saveUser(user);

        return "User Registered Successfully";

    }

}

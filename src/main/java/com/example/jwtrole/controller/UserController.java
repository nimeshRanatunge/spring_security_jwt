package com.example.jwtrole.controller;
import com.example.jwtrole.entity.User;
import com.example.jwtrole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //run when project starts
    @PostConstruct
    public void initRolesAndUsers() {
        userService.initRolesAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }


    //here this path accessible for one user
    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin() {
        return "This url is only accessible to admin";
    }

    //one path accessible to many users??????
    @GetMapping({"/forUser"})
    @PreAuthorize("hasAnyRole('Admin', 'User')")
    public String forUser() {
        return "This url is only accessible to user";
    }
}

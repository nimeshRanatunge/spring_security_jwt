package com.example.jwtrole.controller;

import com.example.jwtrole.entity.Role;
import com.example.jwtrole.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//containes endpoints
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    //create roles
    @PostMapping({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }
}

package com.example.jwtrole.controller;

import com.example.jwtrole.entity.JwtRequest;
import com.example.jwtrole.entity.JwtResponse;
import com.example.jwtrole.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {
    @Autowired
    private JwtService jwtService;

    //get username and password from body of the reqest
    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        //call service method
        return jwtService.createJwtToken(jwtRequest);

    }
}

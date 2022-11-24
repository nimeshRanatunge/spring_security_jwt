package com.example.jwtrole.service;


import com.example.jwtrole.dao.UserDAO;
import com.example.jwtrole.entity.JwtRequest;
import com.example.jwtrole.entity.JwtResponse;
import com.example.jwtrole.entity.User;
import com.example.jwtrole.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception{
        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userName, userPassword);

        final UserDetails userDetails= loadUserByUsername(userName);
        //call jwt util

        String newGeneratedToken = jwtUtil.generateToken(userDetails);
        User user = userDAO.findById(userName).get();
        return new JwtResponse(user, newGeneratedToken);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user =  userDAO.findById(username).get();

       if(user!=null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getUserPassword(),
                    getAuthorities(user)
            );
       }else {
           throw new UsernameNotFoundException("Username is not valid");
       }
    }

    private Set getAuthorities(User user) {
        Set authorities = new HashSet();

        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        });

        return authorities;
    }

    private void authenticate(String userName, String userPassword) throws  Exception{
        try{

        } catch (DisabledException e){
            throw new Exception("user is disabled");
        } catch (BadCredentialsException e) {
            throw new Exception("Bad credentials from user");
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
    }

}

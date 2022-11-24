package com.example.jwtrole.service;

import com.example.jwtrole.dao.RoleDao;
import com.example.jwtrole.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//use autowire to call all methods which are present in dao
@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;
    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}

package com.project.SearchProject.service.impl;

import com.project.SearchProject.repositories.UserRepository;
import com.project.SearchProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ctola
 */
@Service("UserService")
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
}

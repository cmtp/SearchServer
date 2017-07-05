package com.project.SearchProject.service.impl;

import com.project.SearchProject.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ctola
 */
@Service("LoginService")
public class LoginImpl implements LoginService {

    @Override
    public ResponseEntity authenticate(String username, String password){
        Map<String, Object> response = new HashMap<>();
        
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity userExist(String username) {
        return null;
    }


}

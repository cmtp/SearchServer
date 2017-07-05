package com.project.SearchProject.controller;

import com.project.SearchProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author ctola
 */
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    UserService userService;

    @Value("${search.server.jwt.token}")
    private String secretKey;

//    @RequestMapping(value = "/authenticate")
//    public ResponseEntity<Map<String, Object>> authenticate() {
//        return new ResponseEntity<Map<String, Object>>();
//    }
}

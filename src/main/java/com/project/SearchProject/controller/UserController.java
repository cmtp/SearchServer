package com.project.SearchProject.controller;

import com.project.SearchProject.dto.UserDTO;
import com.project.SearchProject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ctola
 */
@RestController
@RequestMapping("/rest")
public class UserController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/users/{page}/{size}")
    public ResponseEntity getUser(@PathVariable int page, @PathVariable int size) {
        Map<String, Object> mapResponse = new HashMap<>();

        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }
}

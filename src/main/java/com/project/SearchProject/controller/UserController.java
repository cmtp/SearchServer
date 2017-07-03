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
@RequestMapping("/api/rest")
public class UserController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * Web Service to list users
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/{page}/{size}")
    public ResponseEntity getUserList(@PathVariable int page, @PathVariable int size) {
        Map<String, Object> mapResponse = new HashMap<>();

        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    /**
     * Web service to create an user
     * @param userDTO
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    /**
     * Web service to obtain an user from his userId
     * @param userId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
    public ResponseEntity getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    /**
     * Web Service to update an user
     * @param userId
     * @param userDTO
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}")
    public ResponseEntity setUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        return userService.setUser(userId, userDTO);
    }

    /**
     * Web Service to set the state of the user from CREATED to ACTIVE
     * @param userId
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/users/{userId}")
    public ResponseEntity setStatus(@PathVariable Long userId) {
        return userService.setUserStatus(userId);
    }

    /**
     * Web Service to delete an user in database
     * @param userId
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
    public ResponseEntity deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}

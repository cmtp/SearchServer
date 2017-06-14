package com.project.SearchProject.service.impl;

import com.project.SearchProject.dto.UserDTO;
import com.project.SearchProject.model.User;
import com.project.SearchProject.repositories.UserRepository;
import com.project.SearchProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ctola
 */
@Service("UserService")
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Service to create an user
     * @param userDTO
     * @return
     */
    @Transactional
    @Override
    public ResponseEntity createUser(UserDTO userDTO) {
        Map<String, Object> response = new HashMap<>();
        if(null != userDTO) {
            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setName(userDTO.getName());
            user.setGender(userDTO.getGender());
            user.setTypeUser(userDTO.getTypeUser());
            user.setStatus("CREATED");
            userRepository.save(user);
            response.put("data", user);
            response.put("status", "ok");
            response.put("message", "User was created");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        response.put("status", "error");
        response.put("message", "error the user was not created");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Service rest to obtain an user
     * @param userId
     * @return
     */
    @Override
    public ResponseEntity getUser(Long userId) {
        Map<String, Object> response = new HashMap<>();
        User user = userRepository.findOne(userId);
        if(null != user) {
            response.put("status", "ok");
            response.put("message", "User was found");
            response.put("data", user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.put("status", "error");
        response.put("message", "Error User doesn't exist");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * Service to set params of user
     * @param userId
     * @param userDTO
     * @return
     */
    @Transactional
    @Override
    public ResponseEntity setUser(Long userId, UserDTO userDTO) {
        Map<String, Object> response = new HashMap<>();
        User user = userRepository.findOne(userId);
        if (null != user) {
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setGender(userDTO.getGender());
            userRepository.save(user);
            response.put("status", "ok");
            response.put("message", "User was modified");
            response.put("data", user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.put("status", "error");
        response.put("message", "User not found");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity setUserStatus(Long userId) {
        Map<String, Object> response = new HashMap<>();
        User user = userRepository.findOne(userId);
        if (null != user) {
            user.setStatus("ACTIVE");
            userRepository.save(user);
            response.put("status", "ok");
            response.put("message", "The state of this user was changed");
            response.put("data", user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.put("status", "error");
        response.put("message", "User not found");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

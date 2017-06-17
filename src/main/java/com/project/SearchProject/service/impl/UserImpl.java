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
        User user = userRepository.findByUsername(userDTO.getUsername());
        if(null == user) {
            user = new User();
            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setName(userDTO.getName());
            user.setGender(userDTO.getGender());
            user.setTypeUser(userDTO.getTypeUser());
            user.setStatus("CREATED");
            user.setIsDeleted(false);
            userRepository.save(user);
            response.put("data", user);
            response.put("status", "ok");
            response.put("message", "User was created");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        response.put("status", "error");
        response.put("message", "The user: " + userDTO.getUsername() + " already exists");
        return new ResponseEntity<>(response, HttpStatus.LOCKED);
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
            // TODO: We need to review how to do this control with the best form
            if (user.getIsDeleted()) {
                response.put("status", "error");
                response.put("message", "User was deleted");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
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
            if (user.getIsDeleted()) {
                response.put("status", "error");
                response.put("message", "User was deleted");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
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

    /**
     * Service to update the state of user
     * @param userId
     * @return
     */
    @Override
    public ResponseEntity setUserStatus(Long userId) {
        Map<String, Object> response = new HashMap<>();
        User user = userRepository.findOne(userId);
        if (null != user) {
            if (user.getIsDeleted()) {
                response.put("status", "error");
                response.put("message", "User was deleted");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
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

    /**
     * Service to logicc delete the user
     * @param userId
     * @return
     */
    @Transactional
    @Override
    public ResponseEntity deleteUser(Long userId) {
        Map<String, Object> response = new HashMap<>();
        User user = userRepository.findOne(userId);
        if (null != user) {
            user.setIsDeleted(true);
            response.put("status", "ok");
            response.put("message", "The user was removed");
            response.put("data", user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.put("status", "error");
        response.put("message", "User not found");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

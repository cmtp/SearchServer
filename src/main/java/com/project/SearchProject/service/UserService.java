package com.project.SearchProject.service;

import com.project.SearchProject.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.Map;

/**
 * @author ctola
 */
public interface UserService {
    public ResponseEntity createUser(UserDTO userDTO);
    public ResponseEntity getUser(Long userId);
    public ResponseEntity setUser(Long userId, UserDTO userDTO);
}

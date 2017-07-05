package com.project.SearchProject.service;

import org.springframework.http.ResponseEntity;

/**
 * @author ctola
 */
public interface LoginService {
    public ResponseEntity authenticate(String username, String password);
    public ResponseEntity userExist(String username);
}

package com.project.SearchProject.dto;

/**
 * @author ctola
 */
public class UserDTO {
    private String username;
    private String password;
    private String name;
    private String gender;
    private String typeUser;
    private String email;

    public UserDTO() {

    }

    public UserDTO(String username, String password, String name, String gender, String typeUser, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.typeUser = typeUser;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

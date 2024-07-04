package com.panel.LRapp.Dto;


import com.panel.LRapp.Entity.Role;

public class UserDTO {

    private int id;
    private String name;
    private String email;
    private String password;
    private String confirmPass;
    private String phone;

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserDTO(String name, String email, String password, String confirmPass, String phone, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPass = confirmPass;
        this.phone = phone;
        this.role = role;
    }

    public UserDTO(int id, String name, String email, String password, String confirmPass, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPass = confirmPass;
        this.phone = phone;
    }
    public UserDTO(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPass='" + confirmPass + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

package com.panel.LRapp.Service;

import com.panel.LRapp.Dto.ResetPassword;
import com.panel.LRapp.Dto.UserDTO;
import com.panel.LRapp.Dto.loginDTO;
import com.panel.LRapp.Dto.newPassword;
import com.panel.LRapp.Entity.User;
import com.panel.LRapp.Entity.code;
import com.panel.LRapp.response.AuthenticationResponse;
import com.panel.LRapp.response.LoginResponse;

import java.util.List;

public interface UserService {

    AuthenticationResponse addUser(UserDTO userDTO);

    AuthenticationResponse loginUser(loginDTO login);

    void deleteById(int id);

    LoginResponse findById(int id);

    List<User> findAll();

    LoginResponse update(User user);

    User checkEmailExist(String email);

    void save(User user);


    User findByMail(String email);


    LoginResponse sendCode(ResetPassword resetPassword);

    LoginResponse resetPassword(newPassword newpass);
}

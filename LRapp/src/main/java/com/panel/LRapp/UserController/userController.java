package com.panel.LRapp.UserController;

import com.panel.LRapp.Dto.*;
import com.panel.LRapp.Entity.ImageData;
import com.panel.LRapp.Entity.User;
import com.panel.LRapp.Entity.code;
import com.panel.LRapp.Service.StorageService;
import com.panel.LRapp.Service.UserService;
import com.panel.LRapp.Service.emailService;
import com.panel.LRapp.response.AuthenticationResponse;
import com.panel.LRapp.response.LoginResponse;
import com.panel.LRapp.utill.OTPUtil;
import com.panel.LRapp.utill.userCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class userController {

    @Autowired
    private UserService userService;
    @PostMapping("/save")
    public AuthenticationResponse addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody loginDTO login, @RequestParam Map<String , Object> claims)
    {
        AuthenticationResponse loginResponse = userService.loginUser(login);
        return ResponseEntity.ok(loginResponse);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam("userId") int id){
        userService.deleteById(id);
    }

    @GetMapping("/findUser")
    public LoginResponse findById(@RequestParam("userId") int id){
           return userService.findById(id);
    }

    @GetMapping("/findAllUser")
    public List<User> findAllUser(){
        return userService.findAll();
    }

    @PutMapping("/updateProfile")
    public LoginResponse updateUser(@RequestBody User userDTO){
        return userService.update(userDTO);
    }

    @PostMapping("/checkEmail")
    public LoginResponse sendCode(@RequestBody ResetPassword resetPassword){
        return userService.sendCode(resetPassword);
    }
    @PostMapping("/resetPassword")
    public LoginResponse resetPassword(@RequestBody newPassword newpass){
        return userService.resetPassword(newpass);
    }

    @PostMapping("/checkCode")
    public void verifyCode(){

    }

    @PostMapping("/changePass")
    public void CPassword(){

    }

//    @PostMapping("/image")
//    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file , @RequestParam("email") String email) throws IOException {
//        ImageData uploadImage = service.uploadImage(file);
//        User user=userService.findByMail(email);
//        user.getImageData().setName(uploadImage.getName());
//        user.getImageData().setType(uploadImage.getType());
//        user.getImageData().setImageData(uploadImage.getImageData());
//        userService.save(user);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body("uploadImage");
//    }
}

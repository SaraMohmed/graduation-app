package com.panel.LRapp.UserController;


import com.panel.LRapp.Dto.feelingsDTO;

import com.panel.LRapp.Entity.*;
import com.panel.LRapp.Repo.TokenRepository;
import com.panel.LRapp.Repo.UserRepo;
import com.panel.LRapp.Service.feelingsService;

import com.panel.LRapp.response.feelingsResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/feelings")
public class feelingsController {
    @Autowired
    private feelingsService fService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TokenRepository tokenRepository;
    @PostMapping("/save")
    public feelingsResponse addFeeling(@RequestBody feelings fDto){

        return fService.save(fDto);
    }

    @DeleteMapping("/delete")
    public String deleteFeeling(@RequestParam("feelingId") int id){
        fService.delete(id);
        return "تم الحذف بنجاح :)";
    }

    @GetMapping("/findfeeling")
    public feelingsResponse findById(@RequestParam("feelingId") int id){
        return fService.findById(id);
    }

    @GetMapping("/search")
    public List<feelings> search(@RequestParam("search") String name){
        return fService.findByName(name);
    }

    @GetMapping("/findAll")
    public List<feelings> findAllfeelings(){
        return fService.findAll();
    }

    @PutMapping("/update")
    public feelingsResponse updateFeeling(@RequestBody feelings fDTO){
        return fService.update(fDTO);
    }

    @GetMapping("/findAllFUser")
    public Set<feelings> findAllFUser(@RequestHeader("Authorization") String t){
        return fService.findAllFUser(t);
    }

    @GetMapping("/setUserToFeel")
    public String setUserToAdmin(@RequestHeader("Authorization") String t,@RequestParam("feelId") int id){

        Token to= tokenRepository.findByToken(t.substring(7));
        User user=userRepo.findByEmail(to.getUser().getEmail());

        fService.enrollUserInFeel(user.getId(),id);
        return "تمت الاضافه بنجاح :)";
    }

}

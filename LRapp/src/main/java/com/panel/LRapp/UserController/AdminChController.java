package com.panel.LRapp.UserController;


import com.panel.LRapp.Dto.AdminDTO;
import com.panel.LRapp.Entity.AdminCDays;
import com.panel.LRapp.Entity.AdminChallenge;

import com.panel.LRapp.Entity.Token;
import com.panel.LRapp.Entity.User;
import com.panel.LRapp.Repo.TokenRepository;
import com.panel.LRapp.Repo.UserRepo;
import com.panel.LRapp.Service.AdminCService;
import com.panel.LRapp.response.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/adminChallenge")
public class AdminChController {
    @Autowired
    private AdminCService adminCService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TokenRepository tokenRepository;
    @PostMapping("/save")
    public AdminCResponse addChallenge(@RequestBody AdminChallenge adminChallenge) {
        return adminCService.save(adminChallenge);
    }

    @DeleteMapping("/delete")
    public String deleteChallenge(@RequestParam("ChallengeId") int id){
        adminCService.delete(id);
        return "Challenge delete Successfully";
    }

    @GetMapping("/findChallenge")
    public ACDisplayResponse findById(@RequestParam("ChallengeId") int id){
        return adminCService.findById(id);
    }

    @GetMapping("/search")
    public List<AdminChallenge> search(@RequestParam("search") String name){
        return adminCService.findByName(name);
    }

    @GetMapping("/findAll")
    public List<AdminChallenge> findAllChallenge(){
        return adminCService.findAll();
    }

    @GetMapping("/findAllCAUser")
    public AllCAUser findAllCAUser(@RequestHeader("Authorization") String t){
        return adminCService.findAllCAUser(t);
    }

    @GetMapping("/setUserToAdmin")
    public UserAdminC setUserToAdmin(@RequestHeader("Authorization") String t, @RequestParam("ChallengeId") int id){

        Token to= tokenRepository.findByToken(t.substring(7));
        User user=userRepo.findByEmail(to.getUser().getEmail());

        adminCService.enrollUserInAdmin(user.getId(),id);
        return new UserAdminC("تم الاضافه بنجاح :)");
    }


    @PutMapping("/update")
    public AdminCResponse updateChallenge(@RequestBody AdminChallenge adminChallenge){
        return adminCService.update(adminChallenge);
    }

    @PutMapping("/updateRC")
    public CRAdminCU updateRC(@RequestBody AdminDTO adminChallenge, @RequestHeader("Authorization") String t){
        return adminCService.updateCR(t,adminChallenge);
    }


}

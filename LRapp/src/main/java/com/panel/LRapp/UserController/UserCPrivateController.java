package com.panel.LRapp.UserController;

import com.panel.LRapp.Entity.UserChallengePrivate;

import com.panel.LRapp.Service.UCPrivateService;
import com.panel.LRapp.response.UCPrivateResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/userChallengePrivate")
public class UserCPrivateController {
    @Autowired
    private UCPrivateService ucPrivateService;
    @PostMapping("/save")
    public UCPrivateResponse addChallenge(@RequestBody UserChallengePrivate userChallengePrivate,@RequestHeader("Authorization") String t) {

        return ucPrivateService.save(userChallengePrivate,t);
    }

    @DeleteMapping("/delete")
    public String deleteChallenge(@RequestParam("ChallengeId") int id,@RequestHeader("Authorization") String t){

        return ucPrivateService.delete(id,t);
    }

    @GetMapping("/findChallenge")
    public UCPrivateResponse findById(@RequestParam("ChallengeId") int id){
        return ucPrivateService.findById(id);
    }

    @GetMapping("/search")
    public List<UserChallengePrivate> search(@RequestParam("search") String name){
        return ucPrivateService.findByName(name);
    }

    @GetMapping("/findAll")
    public List<UserChallengePrivate> findAllChallenge(@RequestHeader("Authorization") String t){
        return ucPrivateService.findAll(t);
    }

    @PutMapping("/update")
    public UCPrivateResponse updateChallenge(@RequestBody UserChallengePrivate userChallengePrivate){
        return ucPrivateService.update(userChallengePrivate);
    }
}

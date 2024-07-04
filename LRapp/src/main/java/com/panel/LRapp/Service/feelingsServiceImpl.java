package com.panel.LRapp.Service;

import com.panel.LRapp.Dto.feelingsDTO;

import com.panel.LRapp.Entity.FeelingDays;
import com.panel.LRapp.Entity.Token;
import com.panel.LRapp.Entity.User;
import com.panel.LRapp.Entity.feelings;
import com.panel.LRapp.Repo.TokenRepository;
import com.panel.LRapp.Repo.UserRepo;
import com.panel.LRapp.Repo.feelingsRepo;

import com.panel.LRapp.response.feelingsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class feelingsServiceImpl implements feelingsService{
    @Autowired
    private feelingsRepo fRepo;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TokenRepository tokenRepository;


    @Override
    public feelingsResponse save(feelings fDTO) {

        feelings feel=new feelings(fDTO.getName(),fDTO.getDescription());

        List<FeelingDays> feelingDays=new ArrayList<>();
        for (FeelingDays fIn: fDTO.getFeelingDays()){
            FeelingDays feelingDays1=new FeelingDays(fIn.getAdvice());
            feelingDays1.setFeeling(feel);

            feelingDays.add(feelingDays1);
        }

        feel.setFeelingDays(feelingDays);

        return new feelingsResponse("تمت الاضافه بنجاح :)",fRepo.save(feel));
    }

    @Override
    public void delete(int id) {
        fRepo.deleteById(id);
    }

    @Override
    public feelingsResponse update(feelings fDTO) {
        Optional<feelings> f=fRepo.findById(fDTO.getId());
        if(f.isEmpty()){
            return new feelingsResponse("لم يتم العثور على هذا الشعور :(",null);
        }else{
            f.get().setName(fDTO.getName());
            f.get().setDescription(fDTO.getDescription());

            List<FeelingDays> feelingDays=f.get().getFeelingDays();
            List<FeelingDays> feelingDays2=fDTO.getFeelingDays();
            for (int i = 0; i < feelingDays.size(); i++) {
                f.get().getFeelingDays().get(i).setAdvice(feelingDays2.get(i).getAdvice());
            }
            f.get().setFeelingDays(feelingDays);
            return new feelingsResponse("تم التعديل بنجاح :)",fRepo.save(f.get()));
        }

    }

    @Override
    public feelingsResponse findById(int id) {

        Optional<feelings> f=fRepo.findById(id);
        if(f.isEmpty()){
            return new feelingsResponse("لم يتم العثور على هذا الشعور :(",null);
        }else {
            return new feelingsResponse("تم العثور على الشعور بنجاح :)", f.get());
        }
    }

    @Override
    public List<feelings> findByName(String name) {
        List<feelings> f=fRepo.findByName(name);
        return f;
    }

    @Override
    public void enrollUserInFeel(int userId, int feelId) {
        Optional<User> userOpt = userRepo.findById(userId);
        Optional<feelings> feelOpt = fRepo.findById(feelId);

        if (userOpt.isPresent() && feelOpt.isPresent()) {
            User user = userOpt.get();
            feelings feel = feelOpt.get();

            user.getFeelingsSet().add(feel);
            feel.getUser().add(user);

            userRepo.save(user);
            fRepo.save(feel);
        }
    }
    @Override
    public Set<feelings> findAllFUser(String t) {
        Token to= tokenRepository.findByToken(t.substring(7));
        User user=userRepo.findByEmail(to.getUser().getEmail());
        return user.getFeelingsSet();
    }

    @Override
    public List<feelings> findAll() {
        return fRepo.findAll();
    }

    @Override
    public feelingsResponse saveF(feelings f) {
        return new feelingsResponse("تمت الاضافه بنجاح :)",fRepo.save(f));
    }
}

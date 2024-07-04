package com.panel.LRapp.Service;


import com.panel.LRapp.Dto.DateT;
import com.panel.LRapp.Dto.Habit;
import com.panel.LRapp.Dto.HabitsDTO;
import com.panel.LRapp.Entity.Habits;
import com.panel.LRapp.Entity.Token;
import com.panel.LRapp.Entity.User;
import com.panel.LRapp.Repo.HabitsRepo;
import com.panel.LRapp.Repo.TokenRepository;
import com.panel.LRapp.Repo.UserRepo;
import com.panel.LRapp.response.HabitsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HabitsServiceImpl implements HabitsService{

    @Autowired
    private HabitsRepo habitsRepo;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public HabitsResponse findById(int id) {
        if(habitsRepo.findById(id).isEmpty()){
            return new HabitsResponse("لم يتم العثور على هذه العاده :(",null);
        }
        else{
            return new HabitsResponse("تم العثور على هذه العاده بنجاح :)",habitsRepo.findById(id).get());
        }
    }

    @Override
    public List<Habits> findAll(String token) {
        Token t= tokenRepository.findByToken(token.substring(7));
        User user=userRepo.findByEmail(t.getUser().getEmail());
        return user.getHabits();
    }


    @Override
    public HabitsResponse save(HabitsDTO habitsDto,String token) {

        Token t= tokenRepository.findByToken(token.substring(7));
        User user=userRepo.findByEmail(t.getUser().getEmail());
        Habits habits = new Habits(habitsDto.getTitle(),habitsDto.getStartDate(),habitsDto.getEndDate(),false);
        habits.setUser(user);
        return new HabitsResponse("تمت الاضافه بنجاح :)",habitsRepo.save(habits));
    }



    @Override
    public HabitsResponse update(Habit habit) {
        Optional<Habits> habits = habitsRepo.findById(habit.getId());
        if(habit.getTitle()==null) {
            habits.get().setDone(habit.isDone());
        }else {
            habits.get().setTitle(habit.getTitle());
        }
        return new HabitsResponse("تم التعديل بنجاح :)",habitsRepo.save(habits.get()));
    }

    @Override
    public String deleteById(int id) {
        Optional<Habits> habits = habitsRepo.findById(id);
        if(habits.isEmpty()){
            return "لم يتم العثور على هذه العاده :(";
        }
        else{
            habitsRepo.deleteById(id);
            return "تم الحذف بنجاح :)";
        }
    }

//    @Override
//    public String deleteHabits(int id, int indx) {
//        Optional<Habits> habits = habitsRepo.findById(id);
//        habits.get().getTitle().set(indx,null);
//        return "deleted";
//    }

    @Override
    public List<Habits> searchByDate(DateT date, String token) {
        Token to= tokenRepository.findByToken(token.substring(7));
        User user=userRepo.findByEmail(to.getUser().getEmail());
        List<Habits> habits = new ArrayList<>();
        for(int i=0;i<user.getHabits().size();i++){
            if(user.getHabits().get(i).getStartDate().isEqual(date.getDate())){
                habits.add(user.getHabits().get(i));
            }
        }
        return habits;
    }


}

package com.panel.LRapp.Service;


import com.panel.LRapp.Dto.DateT;
import com.panel.LRapp.Dto.Habit;
import com.panel.LRapp.Dto.HabitsDTO;
import com.panel.LRapp.Entity.Habits;
import com.panel.LRapp.response.HabitsResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public interface HabitsService {

    HabitsResponse findById(int id);
    List<Habits> findAll(String t);

    HabitsResponse save(HabitsDTO habitsDto,String t);

    HabitsResponse update(Habit habitsDto);

    String deleteById(int id);

    List<Habits> searchByDate(DateT date, String token);

//    String deleteHabits(int id, int indx);
}

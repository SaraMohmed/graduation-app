package com.panel.LRapp.UserController;

import com.panel.LRapp.Dto.DateT;
import com.panel.LRapp.Dto.Habit;
import com.panel.LRapp.Dto.HabitsDTO;
import com.panel.LRapp.Entity.Habits;
import com.panel.LRapp.Entity.Tasks;
import com.panel.LRapp.Service.HabitsService;
import com.panel.LRapp.response.HabitsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api/v1/habits")
public class HabitsController {

    @Autowired
    private HabitsService habitsService;
    @GetMapping("/getAllHabits")
    public List<Habits> findAll( @RequestHeader("Authorization") String t){
        return habitsService.findAll(t);
    }

    @PostMapping("/save")
    public HabitsResponse save(@RequestBody HabitsDTO habitsDto, @RequestHeader("Authorization") String t){
        return habitsService.save(habitsDto,t);
    }

    @PutMapping("/update")
    public HabitsResponse update(@RequestBody Habit habitsDto){
        return habitsService.update(habitsDto);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") int id){
        return habitsService.deleteById(id);}

    @GetMapping("/getHabits")
    public HabitsResponse findById(@RequestParam("id") int id){
        return habitsService.findById(id);
    }

    @GetMapping("search")
    public List<Habits> searchByDate(@RequestBody DateT date, @RequestHeader("Authorization") String t){
        return habitsService.searchByDate(date,t);
    }

//    @DeleteMapping("/deleteHabit")
//    public String deleteHabit(@RequestParam("id") int id,@RequestParam("index") int indx){
//        return habitsService.deleteHabits(id,indx);}
}

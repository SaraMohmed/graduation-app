package com.panel.LRapp.Service;


import com.panel.LRapp.Dto.DateT;
import com.panel.LRapp.Dto.Task;
import com.panel.LRapp.Dto.TasksDto;
import com.panel.LRapp.Entity.Habits;
import com.panel.LRapp.Entity.Tasks;
import com.panel.LRapp.Entity.Token;
import com.panel.LRapp.Entity.User;
import com.panel.LRapp.Repo.TasksRepo;
import com.panel.LRapp.Repo.TokenRepository;
import com.panel.LRapp.Repo.UserRepo;
import com.panel.LRapp.response.TasksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private TasksRepo tasksRepo;
    @Autowired
    private HabitsService habitsService;

    @Override
    public TasksResponse findById(int id) {
        if (tasksRepo.findById(id).isEmpty()){
            return new TasksResponse("لم يتم العثور على هذه المهمه :(", null);
        }

        else{
            return new TasksResponse("تم العثور على هذه المهمه بنجاح :) ", tasksRepo.findById(id).get());
        }


    }

    @Override
    public TasksResponse save(TasksDto tDto,String token) {

        Token to= tokenRepository.findByToken(token.substring(7));
        User user=userRepo.findByEmail(to.getUser().getEmail());
        Tasks t=new Tasks(tDto.getTitle(),tDto.getDate(),false);
        t.setUser(user);
        return new TasksResponse("تمت الاضافه بنجاح :) ",tasksRepo.save(t));
    }

    @Override
    public TasksResponse update(Task tDto) {
        Optional<Tasks> t=tasksRepo.findById(tDto.getId());
        if(t.isEmpty()){
            return new TasksResponse("لم يتم العثور على هذه المهمه :(",null);
        }
        t.get().setTitle(tDto.getTitle());
        t.get().setDone(tDto.isDone());
        return new TasksResponse("تم التعديل بنجاح :)",tasksRepo.save(t.get()));
    }

    @Override
    public String delete(int id) {

        Optional<Tasks> t=tasksRepo.findById(id);
        if(t.isEmpty()){
            return "لم يتم العثور على هذه المهمه :(";
        }
        tasksRepo.deleteById(id);
        return "تم الحذف بنجاح :)";
    }

    @Override
    public List<Tasks> findAll(String token) {
        Token to= tokenRepository.findByToken(token.substring(7));
        User user=userRepo.findByEmail(to.getUser().getEmail());

        return user.getTasks();
    }

//    @Override
//    public String deleteTasks(int id, int indx) {
//        Optional<Tasks> task = tasksRepo.findById(id);
//        task.get().getTitle().set(indx,null);
//        return "deleted";
//    }

    @Override
    public List<Tasks> searchByDate(DateT date, String token) {
        Token to= tokenRepository.findByToken(token.substring(7));
        User user=userRepo.findByEmail(to.getUser().getEmail());
        List<Tasks> tasks = new ArrayList<>();
        for(int i=0;i<user.getTasks().size();i++){
            if(user.getTasks().get(i).getDate().isEqual(date.getDate())){
                tasks.add(user.getTasks().get(i));
            }
        }
        return tasks;
    }

    @Override
    public int sumDone(DateT date, String token){
        List<Tasks> tasks=searchByDate(date,token);
        List<Habits> habits=habitsService.searchByDate(date,token);
        int count=0;
        for (Tasks task : tasks) {
            if (task.isDone()) {
                count++;
            }
        }
        for (Habits habit : habits) {
            if (habit.isDone()) {
                count++;
            }
        }
        return count;
    }
}

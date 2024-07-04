package com.panel.LRapp.UserController;

import com.panel.LRapp.Dto.DateT;
import com.panel.LRapp.Dto.Task;
import com.panel.LRapp.Dto.TasksDto;
import com.panel.LRapp.Entity.Tasks;
import com.panel.LRapp.Service.TaskService;
import com.panel.LRapp.response.TasksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/tasks")
public class TasksController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/getAllTasks")
    public List<Tasks> findAll(@RequestHeader("Authorization") String t){
        return taskService.findAll(t);
    }

    @PostMapping("/save")
    public TasksResponse save(@RequestBody TasksDto tasks, @RequestHeader("Authorization") String t){
        return taskService.save(tasks,t);
    }

    @PutMapping("/update")
    public TasksResponse update(@RequestBody Task toDoItem){
        return taskService.update(toDoItem);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") int id){
        return taskService.delete(id);
    }

    @GetMapping("/getTasks")
    public TasksResponse findById(@RequestParam("id") int id){
        return taskService.findById(id);
    }

    @GetMapping("search")
    public List<Tasks> searchByDate(@RequestBody DateT date, @RequestHeader("Authorization") String t){
        return taskService.searchByDate(date,t);
    }

    @GetMapping("getSum")
    public int getSumDone(@RequestBody DateT date, @RequestHeader("Authorization") String t){
        return taskService.sumDone(date,t);
    }

    //    @DeleteMapping("/deleteTask")
//    public String deleteTask(@RequestParam("id") int id,@RequestParam("index") int indx){
//        return taskService.deleteTasks(id,indx);}

}

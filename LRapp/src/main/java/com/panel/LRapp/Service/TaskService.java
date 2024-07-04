package com.panel.LRapp.Service;

import com.panel.LRapp.Dto.DateT;
import com.panel.LRapp.Dto.Task;
import com.panel.LRapp.Dto.TasksDto;
import com.panel.LRapp.Entity.Tasks;
import com.panel.LRapp.response.TasksResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {

    TasksResponse findById(int id);
    TasksResponse save(TasksDto tDto,String t);

    TasksResponse update(Task tDto);

    String delete (int id);

    List<Tasks> findAll(String token);

//    String deleteTasks(int id, int indx);

    List<Tasks> searchByDate(DateT Date, String t);

    int sumDone(DateT date, String token);
}

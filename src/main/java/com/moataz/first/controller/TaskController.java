package com.moataz.first.controller;



import com.moataz.first.model.Task;
import com.moataz.first.services.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskServiceImpl taskService;

    @GetMapping("")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{tid}")
    public Task getTaskById(@PathVariable("tid") Long tid){

        return taskService.getTaskById(tid);

    }
    @PutMapping("/updateTask/{tid}")
    public String updateUser(@PathVariable("tid")Long tid, Task t){
        taskService.editTask(t);
        return "Task updated";
    }
    @PutMapping("/createTask")
    public String addTask(@ModelAttribute("Task")Task task){
        taskService.addTask(task);
        return "Task added successfuly";
    }

    @DeleteMapping("/deleteTask")
    public String deleteTask(Long tid){
        taskService.deleteTask(tid);
        return "Task deleted successfuly";
    }

}

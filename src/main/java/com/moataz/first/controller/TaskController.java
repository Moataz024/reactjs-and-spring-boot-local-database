package com.moataz.first.controller;


import com.moataz.first.model.Task;
import com.moataz.first.services.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskServiceImpl taskService;

    @GetMapping("")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping(value = "/")
    public String saveTask( Task Task ){
        taskService.add(Task);
        return "Task created with ID : "+Task.getTid() ;
    }

    @RequestMapping("/update")
    public String editTask(@RequestParam("tid")Long tid){
        Task u=taskService.getTaskById(tid);
        return "updateTask";
    }
    @PostMapping("/update")
    public String updateTask(Task p) {
        taskService.edit(p);
        return "Task updated";
    }

    @PostMapping("/delete")
    public String deleteTask(Long tid){
        taskService.del(tid);
        return "Task deleted !";
    }

    @GetMapping("/{tid}")
    public Task getTaskById(@PathVariable("tid") Long tid)
    {
        return taskService.getTaskById(tid);
    }

}

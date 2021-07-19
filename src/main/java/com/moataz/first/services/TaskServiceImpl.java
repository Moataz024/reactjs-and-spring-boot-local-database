package com.moataz.first.services;


import com.moataz.first.model.Task;
import com.moataz.first.repos.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    
    
    @Autowired
    TaskRepository tRepo;

    public Task add(Task task){
        tRepo.save(task);
        return task;
    }

    public String del(Long tid){
        tRepo.deleteById(tid);
        return "User deleted";
    }

    public Task edit(Task task){
        tRepo.save(task);
        return task;
    }

    public List<Task> getAllTasks(){
        List<Task> Tasks = new ArrayList<>(tRepo.findAll());
        return Tasks;
    }

    public Task getTaskById(Long tid) {
        return tRepo.findById(tid).get();
    }

    public Page<Task> getAllTaskPerPage(int page, int size) {
        return tRepo.findAll(PageRequest.of(page,size));
    }



}

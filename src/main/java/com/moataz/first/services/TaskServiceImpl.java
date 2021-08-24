package com.moataz.first.services;

import com.moataz.first.model.Task;
import com.moataz.first.repos.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {


    @Autowired
    TaskRepository tRepo;

    @Override
    public Task addTask(Task task) {
        return tRepo.save(task);
    }

    @Override
    public String deleteTask(Long tid) {
        tRepo.deleteById(tid);
        return "Task deleted!";
    }

    @Override
    public Task editTask(Task task) {
        return tRepo.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return tRepo.findAll();
    }

    @Override
    public Task getTaskById(Long tid) {
        return tRepo.getById(tid);
    }

    @Override
    public Page<Task> getAllTasksPerPage(int page, int size) {
        return null;
    }
}

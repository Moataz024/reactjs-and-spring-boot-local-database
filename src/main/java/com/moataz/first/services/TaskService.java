package com.moataz.first.services;


import com.moataz.first.model.Task;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TaskService {

    Task addTask(Task task);
    String deleteTask(Long pid);
    Task editTask(Task task);
    List<Task> getAllTasks();
    Task getTaskById(Long tid);
    Page<Task> getAllTasksPerPage(int page, int size);

}

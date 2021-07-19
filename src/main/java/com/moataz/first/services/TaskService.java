package com.moataz.first.services;

import com.moataz.first.model.Projects;
import com.moataz.first.model.Task;
import org.springframework.data.domain.Page;


import java.util.List;


public interface TaskService {

    Task add(Task task);
    String del(Long tid);
    Task edit(Task task);
    List<Task> getAllTasks();
    Task getTaskById(Long pid);
    Page<Task> getAllTaskPerPage(int page, int size);



}

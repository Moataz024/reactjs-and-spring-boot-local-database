package com.moataz.first.services;

import com.moataz.first.model.Projects;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProjectService {

    Projects add(Projects project);
    String del(Long pid);
    Projects edit(Projects project);
    List<Projects> getAllProjects();
    Projects getProjectById(Long pid);
    Page<Projects> getAllProjectsPerPage(int page, int size);

}

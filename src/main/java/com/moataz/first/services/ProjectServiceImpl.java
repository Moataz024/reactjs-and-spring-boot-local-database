package com.moataz.first.services;

import com.moataz.first.model.Projects;
import com.moataz.first.repos.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    ProjectRepository pRepo;

    public Projects add(Projects project){
        pRepo.save(project);
        return project;
    }

    public String del(Long pid){
        pRepo.deleteById(pid);
        return "User deleted";
    }

    public Projects edit(Projects project){
        pRepo.save(project);
        return project;
    }

    public List<Projects> getAllProjects(){
        List<Projects> projects = new ArrayList<>(pRepo.findAll());
        return projects;
    }

    public Projects getProjectById(Long pid){
        return pRepo.getById(pid);
    }

    public Page<Projects> getAllProjectsPerPage(int page, int size) {
        return pRepo.findAll(PageRequest.of(page,size));
    }


    public Projects getProjectsById(Long pid) {
        return  pRepo.findById(pid).get();
    }
}

package com.moataz.first.controller;


import com.moataz.first.model.Projects;
import com.moataz.first.services.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectServiceImpl pService;


    @RequestMapping("")
    public List<Projects> getAllProjects(ModelMap modelMap)
    {
        return pService.getAllProjects();
    }
    @GetMapping("/{pid}")
    public Projects getProject(@PathVariable("pid")Long pid){
        return pService.getProjectsById(pid);
    }

    @PutMapping(value = "/createProject")
    public String saveProject( Projects project ) {
        pService.add(project);
        return "Project Created with ID : " + project.getPid();
    }


    @PutMapping("/update/{pid}")
    public String updateUser(@PathVariable("pid")Long pid, Projects p){
        pService.edit(p);
        return "Project updated";
    }
    @DeleteMapping("/deleteProject/{pid}")
    public String deleteProject(@PathVariable(value = "pid")Long pid){
        pService.del(pid);
        return "Project deleted !";
    }
    @RequestMapping("/displayProjects")
    public List<Projects> displayProjects(ModelMap modelMap)
    {
        return pService.getAllProjects();
    }

}

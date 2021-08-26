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

    @PutMapping(value = "/createProject")
    public String saveProject(@ModelAttribute("Projects") Projects project ) {
        pService.add(project);
        return "Project Created with ID : " + project.getPid();
    }
    @GetMapping("/editProject")
    public Projects editUser(@RequestParam("pid")Long pid){
        return pService.getProjectsById(pid);
    }

    @PutMapping("/update/{pid}")
    public String updateUser(@PathVariable("pid")Long pid, Projects p){
        pService.edit(p);
        return "Project updated";
    }
    @RequestMapping("/deleteProject/{id}")
    public String deleteUser(@RequestParam("pid") Long pid){
        pService.del(pid);
        return "Project deleted !";
    }
    @RequestMapping("/displayProjects")
    public List<Projects> displayProjects(ModelMap modelMap)
    {
        return pService.getAllProjects();
    }

}

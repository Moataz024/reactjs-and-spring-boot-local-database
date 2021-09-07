package com.moataz.first.controller;


import com.moataz.first.model.Projects;
import com.moataz.first.services.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectServiceImpl pService;


    @RequestMapping("")
    public List<Projects> getAllProjects()
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
    @GetMapping("/getProject")
    public Projects editUser(@RequestParam("pid")Long pid){
        return pService.getProjectsById(pid);
    }

    @PutMapping("/update/{pid}")
    public String updateUser(@PathVariable("pid") Projects p){
        pService.edit(p);
        return "Project updated";
    }
    @DeleteMapping("/deleteProject/{pid}")
    public String deleteProject(@PathVariable(value = "pid")Long pid){
        pService.del(pid);
        return "Project deleted !";
    }
    @RequestMapping("/displayAllProjects")
    public String displayProjects(@ModelAttribute("projects") List<Projects> projects,ModelMap modelMap)
    {
        projects = pService.getAllProjects();
        modelMap.addAttribute("projects",projects);
        return "displayProjects";
    }

/*    @PutMapping("/addUsersToProject")
    public void addUsersToProject(Long pid){
        Set<User> us = pService.getProjectsById(pid).getUsers();
        us.addAll(users);
        pService.getProjectsById(pid).setUsers(us);
    }*/
}

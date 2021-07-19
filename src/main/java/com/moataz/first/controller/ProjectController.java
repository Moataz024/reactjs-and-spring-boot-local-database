package com.moataz.first.controller;


import com.moataz.first.model.Projects;
import com.moataz.first.services.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/project")
public class ProjectController {



    @Autowired
    ProjectServiceImpl pService;

    @GetMapping("")
    public List<Projects> getAllProjects() {
        return pService.getAllProjects();
    }

    @PostMapping(value = "/")
    public String saveProject(@ModelAttribute("Projects") Projects project ) {
        pService.add(project);
        return "Project Created with ID : " + project.getPid();
    }
/*    @PostMapping(value = "/edit")
    public Projects editUser(@RequestParam("pid")Long pid){
        return pService.getProjectsById(pid);
    }*/

    @PostMapping("/update")
    public String updateProject(Projects p) {
        pService.edit(p);
        return "Project updated";
    }

    @PostMapping("/delete")
    public String deleteProject(Long pid){
        pService.del(pid);
        return "Project deleted !";
    }

    @GetMapping("/{pid}")
    public Projects getProjectById(@PathVariable("pid") Long pid)
    {
        return pService.getProjectsById(pid);
    }

}

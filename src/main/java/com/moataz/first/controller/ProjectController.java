package com.moataz.first.controller;


import com.moataz.first.model.Projects;
import com.moataz.first.services.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    ProjectServiceImpl pService;

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        return mv;
    }


    @RequestMapping(value = "createProject")
    public String saveProject(@ModelAttribute("Projects") Projects project ){
        pService.add(project);
        ModelAndView mv = new ModelAndView("displayProjects");
        return "Project Created with ID = "+project.getPid() ;
    }
    @RequestMapping("/editProject")
    public Projects editUser(@RequestParam("pid")Long pid){

        return pService.getProjectsById(pid);
    }
    @RequestMapping("/update")
    public String updateUser(Projects p){
        pService.edit(p);
        return "Project updated";
    }
    @RequestMapping("/deleteProject")
    public String deleteUser(@RequestParam("pid") Long pid){
        pService.del(pid);
        return "Project deleted !";
    }
    @RequestMapping("/displayProjects")
    public List<Projects> displayUsers(ModelMap modelMap)
    {
        return pService.getAllProjects();
    }

}

package com.moataz.first.controller;


import com.moataz.first.model.Projects;
import com.moataz.first.model.User;
import com.moataz.first.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.Date;
import java.util.List;
import java.util.Set;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl uService;

    @GetMapping("")
    public List<User> getAllUsers()
    {
        return uService.getAllUsers();
    }

    @PostMapping( "/createUser")
        public String saveUser(@ModelAttribute("user") User user ){
        uService.add(user);
        user.setCreationDate(new Date());
        return "User created";
    }

    @GetMapping("/{uid}")
        public User editUser(@PathVariable("uid") Long uid){
        return uService.getUserById(uid);
    }
    @PutMapping("/updateUser")
    public String updateUser(User u){

        uService.edit(u);
        u.setUpdateDate(new Date());
        return "User updated";
    }
    @DeleteMapping("/deleteUser/{uid}")
        public String deleteUser(@PathVariable("uid") Long uid){
        uService.del(uid);
        return "User deleted !";
    }

    @GetMapping("/displayUsers")
    public List<User> displayUsers()
    {
        return uService.getAllUsers();
    }
    @PutMapping("/addProjectsToUser")
    public void addUsersToProject(Long uid,List<Projects> projects){
        Set<Projects> ps = uService.getUserById(uid).getProjects();
        ps.addAll(projects);
        uService.getUserById(uid).setProjects(ps);
    }
}
package com.moataz.first.controller;


import com.moataz.first.model.User;
import com.moataz.first.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
        public User saveUser(@ModelAttribute("user") User user ){
        return uService.add(user);
    }

    @GetMapping("/{uid}")
        public User editUser(@PathVariable("uid") Long uid){
        return uService.getUserById(uid);
    }
    @PutMapping("/updateUser")
    public String updateUser(User u){
        uService.edit(u);
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
}

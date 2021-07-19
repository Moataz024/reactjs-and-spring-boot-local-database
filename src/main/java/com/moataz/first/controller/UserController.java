package com.moataz.first.controller;


import com.moataz.first.model.User;
import com.moataz.first.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl uService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return uService.getAllUsers();
    }

    @PostMapping(value = "/")
        public String saveUser( User user ){
        uService.add(user);
        return "User created with ID : "+user.getUid() ;
    }

    @RequestMapping("/update")
        public String editUser(@RequestParam("uid")Long uid){
        User u=uService.getUserById(uid);
        return "updateUser";
    }
    @PostMapping("/update")
    public String updateUser(User p) {
        uService.edit(p);
        return "User updated";
    }

    @PostMapping("/delete")
    public String deleteUser(Long uid){
        uService.del(uid);
        return "User deleted !";
    }

    @GetMapping("/{uid}")
    public User getUserById(@PathVariable("uid") Long uid)
    {
        return uService.getUserById(uid);
    }

}


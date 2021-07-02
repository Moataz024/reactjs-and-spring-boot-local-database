package com.moataz.first.controller;


import com.moataz.first.model.User;
import com.moataz.first.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl uService;

    @RequestMapping("/add")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("createUser");
        return mv;
    }


    @RequestMapping(value = "create")
        public ModelAndView saveUser(@ModelAttribute("user") User user ){
        uService.add(user);
        ModelAndView mv = new ModelAndView("display");
        return mv ;
    }
    @RequestMapping("/editUser")
        public String editUser(@RequestParam("uid")Long uid){
        User u=uService.getUserById(uid);
        return "updateUser";
    }
    @RequestMapping("/updateUser")
    public String updateUser(User u){
        uService.edit(u);
        return "display";
    }
    @RequestMapping("/deleteUser")
        public String deleteUser(@RequestParam Long uid){
        uService.del(uid);
        return "User deleted !";
    }



//    @RequestMapping("/display")
//    public ModelAndView display(
//            ModelMap modelMap,
//     @RequestParam (name="page",defaultValue = "0") int page,
//     @RequestParam (name="size", defaultValue = "5") int size
//    )
//
//    {
//        Page<User> users = uService.getAllUsersPerPage(page, size);
//        modelMap.addAttribute("users", users);
//
//        modelMap.addAttribute("pages", new int[users.getTotalPages()]);
//
//        modelMap.addAttribute("currentPage", page);
//        modelMap.addAttribute("size", size);
//        ModelAndView mv = new ModelAndView("display");
//        return mv;
//    }

    @RequestMapping("/displayUsers")
    public List<User> displayUsers(ModelMap modelMap)
    {
        return uService.getAllUsers();
    }
}

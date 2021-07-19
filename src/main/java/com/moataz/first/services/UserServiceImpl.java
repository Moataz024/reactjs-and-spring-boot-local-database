package com.moataz.first.services;

import com.moataz.first.model.User;
import com.moataz.first.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository UserRepo;

    public User add(User user){
        UserRepo.save(user);
        return user;
    }

    public String del(Long uid){
        UserRepo.deleteById(uid);
        return "User deleted";
    }

    public User edit(User user){
        UserRepo.save(user);
        return user;
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>(UserRepo.findAll());
        return users;
    }

    public User getUserById(Long uid){
        return UserRepo.findById(uid).get();
    }

    public Page<User> getAllUsersPerPage(int page, int size) {
        return UserRepo.findAll(PageRequest.of(page,size));

    }

}

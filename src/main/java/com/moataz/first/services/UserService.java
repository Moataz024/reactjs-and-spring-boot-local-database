package com.moataz.first.services;

import com.moataz.first.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
     User add(User user);
    String del(Long uid);
    User edit(User user);
    List<User> getAllUsers();
    User getUserById(Long uid);
    Page<User> getAllUsersPerPage(int page, int size);
}

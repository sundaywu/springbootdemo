package com.sunday.demo.service;

import com.sunday.demo.model.User;

import java.util.List;

/**
 * User crud
 */
public interface UserService {

    public Boolean addUser(User user);

    public List<User> getAllUser();

    public User getUserById(Integer id);

    public Boolean delUserById(Integer id);

    public Boolean updateUserById(Integer id, User user);

}

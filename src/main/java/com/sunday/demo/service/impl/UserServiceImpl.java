package com.sunday.demo.service.impl;

import com.sunday.demo.mapper.UserMapper;
import com.sunday.demo.model.User;
import com.sunday.demo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunday on 2015/8/27.
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Override
    public Boolean addUser(User user) {
        Boolean flag = false;
        Integer num  = 0;
        try {
            num = userMapper.addUser(user);
            if (num > 0) {
                flag = true;
            }
        } catch (Exception e) {
            logger.error("addUser from db error, e : {}", e);
        }
        return flag;
    }

    @Override
    public List<User> getAllUser(){
        List<User> userList = new ArrayList<User>();
        try {
            userList = userMapper.getAllUser();
        } catch (Exception e) {
            logger.error("getAllUser from db error, e : {}", e);
        }
        return userList;
    }

    @Override
    public User getUserById(Integer id){
        User user = null;
        try {
            user = userMapper.getUserById(id);
        } catch (Exception e) {
            logger.error("getUserById from db error, e : {}", e);
        }
        return user;
    }

    @Override
    public Boolean delUserById(Integer id) {
        Boolean flag = false;
        Integer num  = 0;
        try {
            num = userMapper.delUserById(id);
            if (num > 0) {
                flag = true;
            }
        } catch (Exception e) {
            logger.error("delUserById from db error, e : {}", e);
        }
        return flag;
    }

    @Override
    public Boolean updateUserById(Integer id, User user) {
        Boolean flag = false;
        Integer num  = 0;
        try {
            user.setId(id);
            num = userMapper.updateUserById(user);
            if (num > 0) {
                flag = true;
            }
        } catch (Exception e) {
            logger.error("updateUserById from db error, e : {}", e);
        }
        return flag;
    }
}

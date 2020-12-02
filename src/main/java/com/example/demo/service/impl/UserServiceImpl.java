package com.example.demo.service.impl;

import com.example.demo.dao.db2.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }
}

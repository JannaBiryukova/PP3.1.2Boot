package com.example.PP31.Boot.service;

import com.example.PP31.Boot.dao.UserDao;
import com.example.PP31.Boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
public class ServiceImpl implements com.example.PP31.Boot.service.Service {


    private final UserDao userDao;


    @Autowired
    public ServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);
    }

    @Override
    @Transactional
    public User getUser(int userId) {
        return userDao.getUser(userId);
    }

}

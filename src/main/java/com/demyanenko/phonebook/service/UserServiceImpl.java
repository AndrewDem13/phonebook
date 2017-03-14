package com.demyanenko.phonebook.service;


import com.demyanenko.phonebook.dao.ContactDao;
import com.demyanenko.phonebook.dao.UserDao;
import com.demyanenko.phonebook.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }
}

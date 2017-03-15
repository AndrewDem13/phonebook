package com.demyanenko.phonebook.dao;

import com.demyanenko.phonebook.model.User;


public interface UserDao {
    void addUser(User user);
    User findByLogin(String login);
}

package com.demyanenko.phonebook.service;


import com.demyanenko.phonebook.model.User;

public interface UserService {
    void save(User user);

    User findByLogin(String login);
}

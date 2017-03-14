package com.demyanenko.phonebook.dao;

import com.demyanenko.phonebook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer>{
    User findByLogin(String login);
}

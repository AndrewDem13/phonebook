package com.demyanenko.phonebook.service;


public interface SecurityService {
    String findLoggedInLogin();
    void autoLogin(String username, String password);
}

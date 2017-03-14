package com.demyanenko.phonebook.dao;

import com.demyanenko.phonebook.model.Contact;

import java.util.List;


public interface ContactDao {
    void addContact(Contact contact);
    void updateContact(Contact contact);
    void removeContact(int id);
    List<Contact> listContacts(String owner);
}

package com.demyanenko.phonebook.service;


import com.demyanenko.phonebook.dao.ContactDao;
import com.demyanenko.phonebook.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ContactService {

    @Autowired
    private ContactDao contactDao;
    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void addContact(Contact contact) {
        contactDao.addContact(contact);
    }

    public void updateContact(Contact contact) {
        contactDao.updateContact(contact);
    }

    public void removeContact(int id) {
        contactDao.removeContact(id);
    }

    public List<Contact> listContacts(String owner) {
        return contactDao.listContacts(owner);
    }
}

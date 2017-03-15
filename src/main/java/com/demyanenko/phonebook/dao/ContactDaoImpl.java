package com.demyanenko.phonebook.dao;

import com.demyanenko.phonebook.model.Contact;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ContactDaoImpl implements ContactDao{

    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addContact(Contact contact) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(contact);
    }

    @Override
    public void updateContact(Contact contact) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(contact);
    }

    @Override
    public void removeContact(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Contact contact = (Contact) session.load(Contact.class, id);
        if(contact!=null){
            session.delete(contact);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contact> listContacts(String own) {
        Session session = this.sessionFactory.getCurrentSession();
        //String query = "FROM Contact WHERE owner =";
        Query query = session.createQuery("FROM Contact AS C WHERE C.owner = :owner");
        query.setParameter("owner", own);
        return query.list();
    }
}

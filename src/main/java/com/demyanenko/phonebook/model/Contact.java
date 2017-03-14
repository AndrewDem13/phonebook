package com.demyanenko.phonebook.model;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "owner")
    private String owner;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "fist_name")
    private String fist_name;

    @Column(name = "middle_name")
    private String middle_name;

    @Column(name = "number_mob")
    private String number_mob;

    @Column(name = "number_home")
    private String number_home;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    /* Trying this, maybe owner isn't needed?
    @ManyToOne
    private User owner;
    */


    /** Constructor, Getters & Setters **/

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFist_name() {
        return fist_name;
    }

    public void setFist_name(String fist_name) {
        this.fist_name = fist_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getNumber_mob() {
        return number_mob;
    }

    public void setNumber_mob(String number_mob) {
        this.number_mob = number_mob;
    }

    public String getNumber_home() {
        return number_home;
    }

    public void setNumber_home(String number_home) {
        this.number_home = number_home;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
    */
}
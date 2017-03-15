package com.demyanenko.phonebook.controller;

import com.demyanenko.phonebook.model.Contact;
import com.demyanenko.phonebook.model.User;
import com.demyanenko.phonebook.service.ContactService;
import com.demyanenko.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
    @Autowired
    @Qualifier(value = "userService")
    private UserService userService;

    @Autowired
    @Qualifier(value = "contactService")
    private ContactService contactService;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, Model model) {
        userService.save(userForm);
        return "redirect:/welcome";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        model.addAttribute("contactForm", new Contact());
        return "welcome";
    }

    @RequestMapping(value = {"/welcome/add"}, method = RequestMethod.POST)
    public String welcome(@ModelAttribute("contactForm") Contact contactForm, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            contactService.addContact(contactForm);
        }
        return "welcome";
    }

    @RequestMapping(value = "/contacts")
    public String admin(@ModelAttribute("owner")String owner, Model model) {
        model.addAttribute("listContacts", contactService.listContacts(owner));
        return "contacts";
    }
}

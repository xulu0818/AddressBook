package com.cfm.addressbook.controller;

import com.cfm.addressbook.domain.Contact;
import com.cfm.addressbook.domain.SearchForm;
import com.cfm.addressbook.domain.service.ContactsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ContactsController {

    @Autowired
    ContactsService contactsService;

    @GetMapping("/addressBook")
    public String getContact(Model model) {
        List<Contact> allContacts = contactsService.getAllContacts();
        model.addAttribute("addressBook", allContacts);
        model.addAttribute("searchForm", new SearchForm());
        return "addressBook";
    }

    @PostMapping("/addressBook")
    public String saveContact(Contact contact) {
    	contactsService.saveContact(contact);
        return "redirect:/addressBook";
    }

    @RequestMapping("/newContact")
    public String createContact(Model model) {
    	Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "contact";
    }

    @RequestMapping("/contact/delete/{id}")
    public String deleteContact(@PathVariable("id") Integer id) {
    	contactsService.deleteContact(id);
        return "redirect:/addressBook";
    }

    @RequestMapping("/contact/edit/{id}")
    public String editContact(@PathVariable("id") Integer id, Model model) {
        Contact contact = contactsService.getContactById(id);
        model.addAttribute("contact", contact);
        return "contact";
    }

    @GetMapping("/contact/search")
    public String searchContact(String query, Model model) {
        List<Contact> filteredContacts = contactsService.getContactsByQuery(query);
        model.addAttribute("addressBook", filteredContacts);
        model.addAttribute("searchForm", new SearchForm());
        return "addressBook";
    }
}

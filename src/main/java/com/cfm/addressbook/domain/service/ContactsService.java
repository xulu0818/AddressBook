package com.cfm.addressbook.domain.service;

import com.cfm.addressbook.domain.Contact;
import com.cfm.addressbook.domain.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContactsService {

    @Autowired
    ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public void saveContact(Contact contact) {

        Integer id = contact.getId();

        if (id != null) {
        	contactRepository.delete(id);
            System.out.println("Delete the old address");
        }

        contactRepository.save(contact);
    }

    public void deleteContact(Integer id) {
    	contactRepository.delete(id);
    }

    public Contact getContactById(Integer id) {
        return contactRepository.getOne(id);
    }

    public List<Contact> getContactsByQuery(String query) {
        List<Contact> contactListByFirstName= contactRepository.findByFirstName(query);
        List<Contact> contactListByLastName= contactRepository.findByLastName(query);
        List<Contact> contactListByPhoneNumber= contactRepository.findByPhoneNumber(query);
        List<Contact> contactListByAddress= contactRepository.findByAddress(query);
        List<Contact> contactListByEmail= contactRepository.findByEmail(query);

        Set<Contact> contactSet = new HashSet<>();

        contactSet.addAll(contactListByFirstName);
        contactSet.addAll(contactListByLastName);
        contactSet.addAll(contactListByPhoneNumber);
        contactSet.addAll(contactListByAddress);
        contactSet.addAll(contactListByEmail);

        return contactSet.stream().collect(Collectors.toList());
    }

}

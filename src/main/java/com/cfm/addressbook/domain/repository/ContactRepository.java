package com.cfm.addressbook.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cfm.addressbook.domain.Contact;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findByFirstName(String firstName);
    List<Contact> findByLastName(String lastName);
    List<Contact> findByPhoneNumber(String phoneNumber);
    List<Contact> findByAddress(String address);
    List<Contact> findByEmail(String email);
}

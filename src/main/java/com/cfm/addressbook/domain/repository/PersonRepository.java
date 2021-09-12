package com.cfm.addressbook.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cfm.addressbook.domain.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByFirstName(String firstName);
    List<Person> findByLastName(String lastName);
    List<Person> findByPhoneNumber(String phoneNumber);
    List<Person> findByAddress(String address);
    List<Person> findByEmail(String email);
}

package com.cfm.addressbook.controller;

import com.cfm.addressbook.domain.Person;
import com.cfm.addressbook.domain.SearchForm;
import com.cfm.addressbook.domain.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public String getPersons(Model model) {
        List<Person> allPersons = personService.getAllPersons();
        model.addAttribute("persons", allPersons);
        model.addAttribute("searchForm", new SearchForm());
        return "persons";
    }

    @PostMapping("/persons")
    public String savePerson(Person person) {
        personService.savePerson(person);
        return "redirect:/persons";
    }

    @RequestMapping("/newPerson")
    public String createPerson(Model model) {
    	Person person = new Person();
        model.addAttribute("person", person);
        return "personform";
    }

    @RequestMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable("id") Integer id) {
        personService.deletePerson(id);
        return "redirect:/persons";
    }

    @RequestMapping("/person/edit/{id}")
    public String editPerson(@PathVariable("id") Integer id, Model model) {
        Person person = personService.getPersonById(id);
        model.addAttribute("person", person);
        return "personform";
    }

    @GetMapping("/person/search")
    public String searchPerson(String query, Model model) {
        List<Person> filteredPersons = personService.getPersonsByQuery(query);
        model.addAttribute("persons", filteredPersons);
        model.addAttribute("searchForm", new SearchForm());
        return "persons";
    }
}

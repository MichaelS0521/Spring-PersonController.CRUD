package io.zipcoder.crudapp.controller;

import io.zipcoder.crudapp.entity.Person;
import io.zipcoder.crudapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    public PersonRepository personRepository;

    public Person createPerson(Person p) {
        return null;
    }

    public Person getPerson(int id) {
            return null;
    }

    public List<Person> getPersonList() {
        return null;
    }

    public Person updatePerson(Person p) {
        return null;
    }

    public void DeletePerson(int id) {

    }

}

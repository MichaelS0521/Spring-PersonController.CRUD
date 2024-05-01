package io.zipcoder.crudapp.controller;

import io.zipcoder.crudapp.entity.Person;
import io.zipcoder.crudapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    public PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<List<Person>> getPersonList() {
        List<Person> people = (List<Person>) personRepository.findAll();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person p) {
        Person person = personRepository.save(p);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer id) {
        Optional<Person> person = personRepository.findById(id);
        return person.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id")
    public ResponseEntity<Person> updatePerson(@PathVariable Integer id, @RequestBody Person p) {
        return personRepository.findById(id)
                .map(existingPerson ->{
                    existingPerson.setFirstName(p.getFirstName());
                    existingPerson.setLastName(p.getLastName());
                    Person person = personRepository.save(existingPerson);
                    return new ResponseEntity<>(person, HttpStatus.OK);
                }).orElseGet(() -> {
                    p.setId(id);
                    Person newPerson = personRepository.save(p);
                    return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
        });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> DeletePerson(int id) {
        personRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

}

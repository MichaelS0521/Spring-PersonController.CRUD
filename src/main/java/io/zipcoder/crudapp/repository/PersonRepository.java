package io.zipcoder.crudapp.repository;

import io.zipcoder.crudapp.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Integer> {


    Optional<Person> findById(Integer id);
}

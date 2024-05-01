package io.zipcoder.crudapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    private String firstName;
    private String lsatName;
    private int id;

}

package com.ohar.pdbserver.service;

import com.ohar.pdbserver.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();

    List<Person> searchPersons(String search);

    Person addPerson(Person person);

    Person getPersonById(long id);

    Person editPerson(Person person);

    boolean deletePerson(long id);

    List<Person> findByPersonIds(String ids);
}

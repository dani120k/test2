package com.test2.test2.service;

import com.test2.test2.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl {

    @Autowired
    private PersonService repository;

    public List<Person> getAll() {
        return (List<Person>)repository.findAll();
    }

    public Person add(Person person){
        try {
            return repository.save(person);
        } catch (Exception ex){
            return null;
        }
    }

    public void deletePerson(Person person){
        repository.delete(person);
    }

    public Person findByEmail(String email){
        Person personList = repository.findByEmail(email);
        if (personList!= null)
            return personList;
        else
            return null;
    }

}
package com.test2.test2.service;

import com.test2.test2.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonService extends CrudRepository<Person, Long> {

    @Query("select p from Person p where p.email = :email")
    Person findByEmail(@Param("email") String email);
}

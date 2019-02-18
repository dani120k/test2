package com.test2.test2.rest;


import com.google.gson.Gson;
import com.test2.test2.model.Person;
import com.test2.test2.service.PersonServiceImpl;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Test {
    @Autowired
    PersonServiceImpl personService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public String getAll(){
        List<Person> person = personService.getAll();
        return new Gson().toJson(person);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String add(@RequestBody Person person){
        person.setPassword(BCrypt.hashpw(person.getPassword(), BCrypt.gensalt()));
        Person addedPerson = personService.add(person);
        if (addedPerson!=null)
            return new Gson().toJson(addedPerson);
        else
            return "Email must be unique";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete")
    public String deleteByEmail(@RequestParam String email){
        Person personForDelete = personService.findByEmail(email);
        if (personForDelete != null) {
            personService.deletePerson(personForDelete);
            return "Person with email " + email + " was deleted";
        } else
            return "Person with email " + email + " wasn't found";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/find")
    public String findByEmail(@RequestParam String email){
        Person person = personService.findByEmail(email);
        if (person != null)
            return new Gson().toJson(person);
        else
            return "Person with email " + email + "doesn't exist";
    }


}
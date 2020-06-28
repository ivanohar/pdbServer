package com.ohar.pdbserver.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ohar.pdbserver.entity.Person;
import com.ohar.pdbserver.service.PersonService;
import com.ohar.pdbserver.util.LocalDateAdapter;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping({"/persons"})
public class PersonController {

    private final PersonService service;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();

    PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll() {
        return gson.toJson(service.getAllPersons());
    }

    @GetMapping(path = {"/search/{search}"})
    public String searchPersons(@PathVariable String search) {
        return gson.toJson(service.searchPersons(search));
    }

    @PostMapping
    public String add(@RequestBody Person person) {
        return gson.toJson(service.addPerson(person));
    }

    @GetMapping(path = {"/{id}"})
    public String getById(@PathVariable long id) {
        return gson.toJson(service.getPersonById(id));
    }

    @PutMapping
    public String edit(@RequestBody Person person) {
        return gson.toJson(service.editPerson(person));
    }

    @DeleteMapping(path = {"/{id}"})
    public boolean delete(@PathVariable("id") long id) {
        return service.deletePerson(id);
    }

    @GetMapping(path = {"/get/{ids}"})
    public String getByIds(@PathVariable String ids) {
        return gson.toJson(service.findByPersonIds(ids));
    }
}

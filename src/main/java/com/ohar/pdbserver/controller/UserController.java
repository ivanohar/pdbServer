package com.ohar.pdbserver.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ohar.pdbserver.entity.User;
import com.ohar.pdbserver.service.UserService;
import com.ohar.pdbserver.util.LocalDateAdapter;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping({"/users"})
public class UserController {

    private final UserService service;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();

    UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public String add(@RequestBody User user) {
        return gson.toJson(service.addUser(user));
    }

    @GetMapping(path = {"/{id}"})
    public String getById(@PathVariable long id) {
        return gson.toJson(service.getUserById(id));
    }

    @GetMapping(path = {"/exist/{login}"})
    public String getByLogin(@PathVariable String login) {
        return gson.toJson(service.getUserByLogin(login));
    }

    @PutMapping
    public String edit(@RequestBody User user) {
        return gson.toJson(service.editUser(user));
    }

    @DeleteMapping(path = {"/{id}"})
    public boolean delete(@PathVariable("id") long id) {
        return service.deleteUser(id);
    }

    @GetMapping
    public String getAll() {
        return gson.toJson(service.getAllUsers());
    }
}

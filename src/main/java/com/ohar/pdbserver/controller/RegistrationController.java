package com.ohar.pdbserver.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ohar.pdbserver.entity.User;
import com.ohar.pdbserver.service.UserService;
import com.ohar.pdbserver.util.LocalDateAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequestMapping({"/register"})
public class RegistrationController {

    private final UserService service;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();

    RegistrationController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public String registration(@RequestBody User user) {
        return gson.toJson(service.addUser(user));
    }
}

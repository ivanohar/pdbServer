package com.ohar.pdbserver.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ohar.pdbserver.entity.User;
import com.ohar.pdbserver.service.UserService;
import com.ohar.pdbserver.util.LocalDateAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequestMapping({"/login"})
public class AuthorizationController {

    private final UserService service;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();

    AuthorizationController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String authorization(@RequestParam String login, @RequestParam String password) {
        User user = service.getUserByLogin(login);
        if (user == null || !user.getPassword().equals(password)) {
            return gson.toJson(null);
        }
        return gson.toJson(user);
    }
}

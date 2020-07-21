package com.ohar.pdbserver;

import com.ohar.pdbserver.entity.Person;
import com.ohar.pdbserver.entity.User;
import com.ohar.pdbserver.entity.enums.*;
import com.ohar.pdbserver.repository.PersonRepository;
import com.ohar.pdbserver.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.LongStream;

@SpringBootApplication
public class PdbServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdbServerApplication.class, args);
    }
    @Bean
    CommandLineRunner init(UserRepository repository) {
        User admin = repository.findByLogin("admin");
        return args -> {
            if (admin == null) {
                User user = new User();
                user.setFirstName("admin");
                user.setLastName("admin");
                user.setMail("admin" + "@mail.com");
                user.setLogin("admin");
                user.setPassword("admin");
                user.setStatus(Status.ABBOT);
                user.setActivation(Activation.YES);
                repository.save(user);
            }
        };
    }

}

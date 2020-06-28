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
//
//    @Bean
//    CommandLineRunner init(UserRepository repository) {
//        return args -> {
//            repository.deleteAll();
//            LongStream.range(1, 11)
//                    .mapToObj(i -> {
//                        User user = new User();
//                        user.setFirstName("admin" + i);
//                        user.setLastName("admin" + i);
//                        user.setMail("admin" + i + "@mail.com");
//                        user.setLogin("admin" + i);
//                        user.setPassword("admin" + i);
//                        user.setStatus(Status.ABBOT);
//                        user.setActivation(Activation.YES);
//                        return user;
//                    })
//                    .map(repository::save)
//                    .forEach(System.out::println);
//        };
//    }
//
//    @Bean
//    CommandLineRunner init(PersonRepository repository) {
//        return args -> {
//            repository.deleteAll();
//            LongStream.range(1, 11)
//                    .mapToObj(i -> {
//                        Person person = new Person();
//                        person.setLastName("Ivanov" + i);
//                        person.setFirstName("Ivan" + i);
//                        person.setFatherName("Ivanovich" + i);
//                        person.setFio("Ivanov" + i + " Ivan" + i + " Ivanovich" + i);
//                        person.setBirthday(LocalDate.of(2000, 8, 23));
//                        person.setEducation("Driver");
//                        person.setProfession("Teacher");
//                        person.setFamilyStatus(FamilyStatus.NOTMARR);
//                        person.setGender(Gender.MALE);
//                        person.setCity("Minsk");
//                        person.setStreet("First");
//                        person.setNumberHouse("2" + i);
//                        person.setNumberFlat("1" + i);
//                        person.setAddress("Minsk, First 2" + i + "/1" + i);
//                        person.setTelephon("22-34-345");
//                        person.setMobile("(29)56-76-678");
//                        person.setHrostDate(LocalDate.of(2000, 9, 23));
//                        person.setKamuniyaDate(LocalDate.of(2010, 5, 12));
//                        person.setKanfirmazyiaDate(LocalDate.of(2016, 4, 30));
//                        person.setSuzhenstvaDate(LocalDate.of(2020, 3, 11));
//                        person.setReligionEducation(ReligionEducation.YES);
//                        person.setUdzelImshy(UdzelImshy.OFTEN);
//                        person.setSpovedz(Spovedz.OFTEN);
//                        person.setFamilyStatus(FamilyStatus.MARR);
//                        Optional<Person> partner = repository.findById(i - 1);
//                        partner.ifPresent(person::setPartner);
//                        for (int k = 1; k < i; k++) {
//                            Optional<Person> child = repository.findById((long) k);
//                            child.ifPresent(value -> person.getChildren().add(value.getId().toString()));
//                        }
//                        person.setOtherMember(null);
//                        return person;
//                    })
//                    .map(repository::save)
//                    .forEach(System.out::println);
//        };
//    }
}

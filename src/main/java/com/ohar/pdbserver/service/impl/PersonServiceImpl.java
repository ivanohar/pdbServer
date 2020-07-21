package com.ohar.pdbserver.service.impl;

import com.ohar.pdbserver.entity.Person;
import com.ohar.pdbserver.helper.AbstractHelper;
import com.ohar.pdbserver.repository.PersonRepository;
import com.ohar.pdbserver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository repository;

    PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    @Override
    public List<Person> searchPersons(String search) {
        return repository.findByFioOrAddressLike(AbstractHelper.decodeParam(search));
    }

    @Override
    public Person addPerson(Person person) {
        person.setFio(person.getLastName() + " " + person.getFirstName() + " " + person.getFatherName());
        return repository.save(person);
    }

    @Override
    public Person getPersonById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Person editPerson(Person person) {
        return repository.findById(person.getId())
                .map(item -> {
                    item.setLastName(person.getLastName());
                    item.setFirstName(person.getFirstName());
                    item.setFatherName(person.getFatherName());
                    item.setFio(person.getLastName() + " " + person.getFirstName() + " " + person.getFatherName());
                    item.setBirthday(person.getBirthday());
                    item.setEducation(person.getEducation());
                    item.setProfession(person.getProfession());
                    item.setFamilyStatus(person.getFamilyStatus());
                    item.setGender(person.getGender());
                    item.setCity(person.getCity());
                    item.setStreet(person.getStreet());
                    item.setNumberHouse(person.getNumberHouse());
                    item.setNumberFlat(person.getNumberFlat());
                    item.setTelephon(person.getTelephon());
                    item.setMobile(person.getMobile());
                    item.setHrost(person.getHrost());
                    item.setHrostDate(person.getHrostDate());
                    item.setKamuniya(person.getKamuniya());
                    item.setKamuniyaDate(person.getKamuniyaDate());
                    item.setKanfirmazyia(person.getKanfirmazyia());
                    item.setKanfirmazyiaDate(person.getKanfirmazyiaDate());
                    item.setSuzhenstva(person.getSuzhenstva());
                    item.setSuzhenstvaDate(person.getSuzhenstvaDate());
                    item.setReligionEducation(person.getReligionEducation());
                    item.setUdzelImshy(person.getUdzelImshy());
                    item.setSpovedz(person.getSpovedz());
                    item.setPartner(person.getPartner());
                    item.setChildren(person.getChildren());
                    item.setOtherMember(person.getOtherMember());
                    item.setComments(person.getComments());
                    item.setVisitYears(person.getVisitYears());
                    item.setLastVisitYear(person.getLastVisitYear());
                    return repository.save(item);
                }).orElse(null);
    }

    @Override
    public boolean deletePerson(long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return true;
                }).orElse(false);
    }

    @Override
    public List<Person> findByPersonIds(String ids) {
        List<Long> list = Arrays.stream(ids.split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        return repository.findByPersonIds(list);
    }
}

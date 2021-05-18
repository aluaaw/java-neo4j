package com.example.demo.services;

import com.example.demo.persistence.Entity.Person;
import com.example.demo.persistence.Repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public String addPerson(String firstName, String lastName) {
        personRepository.save(Person.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build());
        return "SAVE SUCCESS";
    }

    public String updatePerson(Long id, String firstName, String lastName) {
        personRepository.findById(id)
                .ifPresent(value -> {
                    value.setFirstName(firstName);
                    value.setLastName(lastName);
                    personRepository.save(value);
                });
        return "UPDATE SUCCESS";
    }

    public String deletePerson(Long id) {
        if (personRepository.findById(id).isPresent()) {
            personRepository.deleteById(id);
            return "DELETE SUCCESS";
        }
        return "NOT EXIST";
    }
}
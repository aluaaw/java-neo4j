package com.example.demo.controllers;

import com.example.demo.persistence.Entity.Person;
import com.example.demo.persistence.Repository.PersonRepository;
import com.example.demo.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;
    private final PersonRepository personRepository;

    @PostMapping
    public String addPerson(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName) {
        return personService.addPerson(firstName, lastName);
    }

    @GetMapping("/list")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> getPerson(@PathVariable("id") Long id) {
        return personRepository.findById(id);
    }

    @PutMapping
    public String updatePerson(@RequestParam("id") Long id,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        return personService.updatePerson(id, firstName, lastName);
    }

    @DeleteMapping
    public String deletePerson(@RequestParam("id") Long id) {
        return personService.deletePerson(id);
    }
}

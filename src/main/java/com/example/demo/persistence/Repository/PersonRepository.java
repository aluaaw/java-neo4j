package com.example.demo.persistence.Repository;

import com.example.demo.persistence.Entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface PersonRepository extends Neo4jRepository<Person, Long> {
    Optional<Person> findById(Long id);
}
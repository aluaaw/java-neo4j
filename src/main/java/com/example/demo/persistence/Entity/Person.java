package com.example.demo.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Getter
@Setter
@Builder
@Node("Person")
public class Person {
    @Id @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
}

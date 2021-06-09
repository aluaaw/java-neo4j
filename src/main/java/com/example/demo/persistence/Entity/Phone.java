package com.example.demo.persistence.Entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class CellPhone {
    @Id @GeneratedValue
    private Long id;
    private String phone;

    @Relationship(direction = Relationship.Direction.INCOMING)
    private Person person;
}

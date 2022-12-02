package com.dewen.repository;

import com.dewen.entity.Person;
import com.dewen.enums.Status;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    // put your custom logic here as instance methods

    public Uni<Person> findByName(String name) {
        return find("name", name).firstResult();
    }

    public Uni<List<Person>> findAlive() {
        return list("status", Status.Alive);
    }

    public Uni<Long> deleteStefs() {
        return delete("name", "Stef");
    }
}
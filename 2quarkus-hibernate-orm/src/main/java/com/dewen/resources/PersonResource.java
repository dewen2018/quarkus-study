package com.dewen.resources;

import com.dewen.entity.Person;
import com.dewen.enums.Status;
import com.dewen.repository.PersonRepository;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * @author dewen
 * @date 2022/12/2 9:12
 */
@Path("/persion")
public class PersonResource {
    @Inject
    PersonRepository personRepository;

    @GET
    @Path("/add")
    @ReactiveTransactional
    public Uni<Person> add() {
        // creating a person
        Person person = new Person();
        person.name = "Stef";
        person.birth = LocalDate.of(1910, Month.FEBRUARY, 1);
        person.status = Status.Alive;

        // persist it
        return person.persist();
        // return personRepository.persist(person);
    }

    @GET
    @Path("/count")
    public Uni<Long> count() {
        return personRepository.count();
    }

    /**
     * Most useful operations
     */
    public void operations() {
        // creating a person
        Person person = new Person();
        person.name = "Stef";
        person.birth = LocalDate.of(1910, Month.FEBRUARY, 1);
        person.status = Status.Alive;

        // persist it
        Uni<Person> persistOperation = person.persist();

        // note that once persisted, you don't need to explicitly save your entity: all
        // modifications are automatically persisted on transaction commit.

        // check if it is persistent
        if (person.isPersistent()) {
            // delete it
            Uni<Void> deleteOperation = person.delete();
        }

        // getting a list of all Person entities
        Uni<List<Person>> allPersons = Person.listAll();

        // finding a specific person by ID
        Uni<Person> personById = Person.findById(23L);

        // finding all living persons
        Uni<List<Person>> livingPersons = Person.list("status", Status.Alive);

        // counting all persons
        Uni<Long> countAll = Person.count();

        // counting all living persons
        Uni<Long> countAlive = Person.count("status", Status.Alive);

        // delete all living persons
        Uni<Long> deleteAliveOperation = Person.delete("status", Status.Alive);

        // delete by id
        Uni<Boolean> deleteByIdOperation = Person.deleteById(23L);

        // delete all persons
        Uni<Long> deleteAllOperation = Person.deleteAll();

        // set the name of all living persons to 'Mortal'
        Uni<Integer> updateOperation = Person.update("name = 'Mortal' where status = ?1", Status.Alive);
    }
}

package com.dewen.entity;

import com.dewen.enums.Status;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.smallrye.mutiny.Uni;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "persion")
public class Person extends PanacheEntity {
    public String name;
    public LocalDate birth;
    public Status status;

    public static Uni<Person> findByName(String name) {
        return find("name", name).firstResult();
    }

    public static Uni<List<Person>> findAlive() {
        return list("status", Status.Alive);
    }

    public static Uni<Long> deleteStefs() {
        return delete("name", "Stef");
    }

    // return name as uppercase in the model
    public String getName() {
        return name.toUpperCase();
    }

    // store all names in lowercase in the DB
    public void setName(String name) {
        this.name = name.toLowerCase();
    }


    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
package com.dewen.resources;

import com.dewen.entity.Fruit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@ApplicationScoped
@Path("/fruits")
public class FruitResource {

    @Inject
    EntityManager entityManager;

    @GET
    @Path("/get")
    public Fruit[] getFruits() {
        return entityManager.createNamedQuery("Fruits.findAll", Fruit.class)
                .getResultList()
                .toArray(new Fruit[0]);
    }

}
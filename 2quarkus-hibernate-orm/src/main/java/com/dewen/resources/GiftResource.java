package com.dewen.resources;

import com.dewen.service.SantaClausService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@ApplicationScoped
@Path("/gift")
public class GiftResource {
    @Inject
    EntityManager entityManager;

    // @GET
    // @Path("fruits")
    // public Gift[] getFruits() {
    //     return entityManager.createNamedQuery("Fruits.findAll", Fruit.class)
    //             .getResultList().toArray(new Gift[0]);
    // }
    @Inject
    SantaClausService service;

    @GET
    @Path("/add")
    public void addGift() {
        service.createGift("我尼玛");
    }

}
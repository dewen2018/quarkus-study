package com.dewen;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/hello")
public class ExampleResource {
    @ConfigProperty(name = "greeting.message")
    String message;

    @ConfigProperty(name = "greeting.suffix", defaultValue = "!")
    String suffix;

    @ConfigProperty(name = "greeting.name")
    Optional<String> name;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        // return "Hello from RESTEasy Reactive";
        return message + " " + name.orElse("world") + suffix;
    }

    @Inject
    Server server;

    @GET
    @Path("/v2")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello2() {
        // SmallRyeConfig config = new SmallRyeConfigBuilder()
        //         .withMapping(Server.class)
        //         .build();
        // Server server = config.getConfigMapping(Server.class);
        return server.host();
    }
}
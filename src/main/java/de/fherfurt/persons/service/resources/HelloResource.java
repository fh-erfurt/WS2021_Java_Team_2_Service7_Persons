package de.fherfurt.persons.service.resources;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api")
public class HelloResource {

    @GET
    @Path("hello")
    public String giveBackHello(){
        return "Hello";
    }
}

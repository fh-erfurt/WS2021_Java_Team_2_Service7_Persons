package de.fherfurt.persons.service.resources;

//TODO @Milena: Nachvollziehen und siehe Avemarks Repo JPA-Rest-Version
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public class BaseResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info()
    {
        return "Hello from Base Resource";
    }


}

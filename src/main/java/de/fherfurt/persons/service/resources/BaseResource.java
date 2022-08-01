package de.fherfurt.persons.service.resources;

//TODO @Milena: Endpoint der Klasse Editing InputField und InputField (InputField)
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
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


    @GET
    @Path("/getHello")
    @Produces(MediaType.TEXT_PLAIN)
    public String giveBackHello(){
        return "Hello\n";
    }


    @GET
    @Path("/SearchingSystem")
    public SearchingResource getSearchingResource(){
        return new SearchingResource();
    }

    /*
    @PUT
    @Path("/EditingPerson")
    public ...

     */
}

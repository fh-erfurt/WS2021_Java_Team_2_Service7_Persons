package de.fherfurt.persons.service.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;

@Path("/api")
public class BaseResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info() {
        return "Hello from Base Resource";
    }


    @GET
    @Path("/getHello")
    @Produces(MediaType.TEXT_PLAIN)
    public String giveBackHello(){
        return "Hello\n";
    }



    @Path("/SearchingResource")
    public SearchingResource getSearchingResource() throws IOException {
        return new SearchingResource();

    }


    @Path("/EditingPersonResource")  // ist das nicht der Endpoint für editing person?
    public EditingPersonResource getEditingPersonResource() throws IOException {
        return new EditingPersonResource();

    }

    @Path("/EditingAddressResource")
    public EditingAddressResource getEditingAddressResource() throws IOException {
        return new EditingAddressResource();

    }

    @Path("/DeleteAddressResource")
    public EditingAddressResource getDeletedAddressResource() throws IOException {
        return new EditingAddressResource();

    }


}

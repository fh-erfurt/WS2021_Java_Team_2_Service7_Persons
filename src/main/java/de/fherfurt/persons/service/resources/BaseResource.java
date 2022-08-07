package de.fherfurt.persons.service.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;

/**
 * @version 2.0.0.0
 * @Author Tran Anh Hoang
 * The class BaseResource is the the first Entrypoint the API
 */
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
    public String giveBackHello() {
        return "Hello\n";
    }


    /**
     * @return Instace of SearchingResource and the next Endpoint of the API
     * @throws IOException when Avatar of a Person can't be read
     * @Author Tran Anh Hoang
     */
    @Path("/SearchingResource")
    public SearchingResource getSearchingResource() throws IOException {
        return new SearchingResource();

    }

    /**
     * @return Instace of EditingPersonResource and the next Endpoint of the API
     * @throws IOException when Avatar of a Person can't be read
     * @Author Tran Anh Hoang
     */
    @Path("/EditingPersonResource")  // ist das nicht der Endpoint für editing person?
    public EditingPersonResource getEditingPersonResource() throws IOException {
        return new EditingPersonResource();

    }

    /**
     * @return Instace of EditingAddressResource and the next Endpoint of the API
     * @throws IOException when Avatar of a Person can't be read
     * @Author Tran Anh Hoang
     */
    @Path("/EditingAddressResource")
    public EditingAddressResource getEditingAddressResource() throws IOException {
        return new EditingAddressResource();

    }

    /**
     * @return Instace of DeleteAddressResource and the next Endpoint of the API
     * @throws IOException when Avatar of a Person can't be read
     * @Author Tran Anh Hoang
     */
    @Path("/DeleteAddressResource")
    public EditingAddressResource getDeletedAddressResource() throws IOException {
        return new EditingAddressResource();

    }


}

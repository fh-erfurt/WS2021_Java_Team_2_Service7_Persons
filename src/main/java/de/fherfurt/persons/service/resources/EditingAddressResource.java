package de.fherfurt.persons.service.resources;

import de.fherfurt.persons.service.model.Address;
import de.fherfurt.persons.service.persistence.repository.AddressRepository;
import de.fherfurt.persons.service.persistence.repository.RepositoryFactory;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;

/**
 * Endpoints for Update and delete address of a Person
 * @version  2.0.0.0
 */
public class EditingAddressResource {

    final AddressRepository addressRepository;


    public EditingAddressResource() throws IOException {
        this.addressRepository = RepositoryFactory.getInstance().getAddressRepository();

    }

    /**
     * @author Tran Anh Hoang
     * @param addressToUpdate needed a json file with the right Parameter to create an Object to update the address of a Person
     * @return Response Code/Number
     */
    @POST
    @Path("/UpdateAdress")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePerson(Address addressToUpdate) {
        boolean successUpdate = this.addressRepository.updateAddressBy(addressToUpdate);

        if (successUpdate)
            return Response.ok(addressToUpdate).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

    }


    //TODO: @Milena Endpoint zum löschen einer Addresse erstellen - Fertig???


    @DELETE
    @Path("/deleteAddress/{addressId:\\d+}")
    public String deleteAddress(@PathParam("addressId") long addressId) {
        boolean successDelete = this.addressRepository.deleteAddressBy(addressId);

        if (successDelete)
            return "Deleting successful";
        else
            return "Deleting unsuccessful";

    }
}
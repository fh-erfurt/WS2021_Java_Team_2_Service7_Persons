package de.fherfurt.persons.service.resources;

import de.fherfurt.persons.service.model.Address;
import de.fherfurt.persons.service.persistence.repository.AddressRepository;
import de.fherfurt.persons.service.persistence.repository.RepositoryFactory;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;

public class EditingAddressResource {

    final AddressRepository addressRepository;


    public EditingAddressResource() throws IOException {
        this.addressRepository = RepositoryFactory.getInstance().getAddressRepository();

    }

    @POST
    @Path("/UpdateAdress/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePerson(Address addressToUpdate) {
        boolean successUpdate = this.addressRepository.updateAddressBy(addressToUpdate);

        if (successUpdate)
            return Response.ok(addressToUpdate).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

    }


    //TODO: @Milena Endpoint zum löschen einer Addresse erstellen

    /*
    @DELETE
    @Path("/deleteAddress/{addressId:\\d+}")
     */
}
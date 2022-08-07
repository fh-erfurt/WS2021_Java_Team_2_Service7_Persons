package de.fherfurt.persons.service.resources;


import de.fherfurt.persons.service.model.Person;
import de.fherfurt.persons.service.persistence.repository.PersonAvatarRepository;
import de.fherfurt.persons.service.persistence.repository.PersonRepository;
import de.fherfurt.persons.service.persistence.repository.RepositoryFactory;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;


/**
 * @version 2.0.0.0
 * @Author Tran Anh Hoang
 * Endpoints for create, update and delete the data of a person
 */
public class EditingPersonResource {

    final PersonRepository personRepository;
    final PersonAvatarRepository personAvatarRepository;

    public EditingPersonResource() throws IOException {
        this.personRepository = RepositoryFactory.getInstance().getPersonRepository();
        this.personAvatarRepository = RepositoryFactory.getInstance().getPersonAvatarRepository();

    }


    /**
     * Endpoint to create a new person
     *
     * @param personToCreate need Json File with the right parameter to create a new Person Object
     * @return Response Code/Number
     */
    @POST
    @Path("/createPerson")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPerson(Person personToCreate) {
        boolean success = this.personRepository.createPerson(personToCreate);

        if (success)
            return Response.ok(personToCreate).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * Endpoint to update a person
     *
     * @param personToUpdate need Json File with the right parameter to update a person
     * @return Response Code/Number
     */
    @POST
    @Path("/UpdatePerson/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePerson(Person personToUpdate) {
        boolean successUpdate = this.personRepository.updatePersonById(personToUpdate);

        if (successUpdate)
            return Response.ok(personToUpdate).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * Endpoint to delete a person
     *
     * @param personId specific Id to find and delete all the data of the person
     * @return Response Code/Number
     */
    @DELETE
    @Path("/deletePerson/{personId:\\d+}")
    public Response deletePerson(@PathParam("personId") long personId) {

        Person p = this.personRepository.findPersonBy(personId);

        if (p != null) {
            this.personRepository.deletePersonById(personId);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}

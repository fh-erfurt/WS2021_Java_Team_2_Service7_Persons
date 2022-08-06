package de.fherfurt.persons.service.resources;


import de.fherfurt.persons.service.model.Person;
import de.fherfurt.persons.service.persistence.repository.PersonAvatarRepository;
import de.fherfurt.persons.service.persistence.repository.PersonRepository;
import de.fherfurt.persons.service.persistence.repository.RepositoryFactory;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;

public class EditingPersonResource {

    final PersonRepository personRepository;
    final PersonAvatarRepository personAvatarRepository;

    public EditingPersonResource() throws IOException {
        this.personRepository = RepositoryFactory.getInstance().getPersonRepository();
        this.personAvatarRepository = RepositoryFactory.getInstance().getPersonAvatarRepository();

    }

    @POST
    @Path("/createPerson")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPerson(Person personToCreate ) {
        boolean success = this.personRepository.createPerson( personToCreate );

        if( success )
            return Response.ok( personToCreate ).build();
        else
            return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).build();
    }


    @POST
    @Path("/UpdatePerson/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePerson(Person personToUpdate) {
        boolean successUpdate = this.personRepository.updatePersonById(personToUpdate);

        if( successUpdate )
            return Response.ok( personToUpdate ).build();
        else
            return Response.status( Response.Status.INTERNAL_SERVER_ERROR ).build();
    }

    @DELETE
    @Path("/deletePerson/{personId:\\d+}")
    public Response deletePerson( @PathParam("personId") long  personId ) {

        Person p = this.personRepository.findPersonBy( personId );

        if( p != null ) {
            this.personRepository.deletePersonById( personId );
            return Response.ok().build();
        }
        else {
            return Response.status( Response.Status.NOT_FOUND ).build();
        }
    }

}

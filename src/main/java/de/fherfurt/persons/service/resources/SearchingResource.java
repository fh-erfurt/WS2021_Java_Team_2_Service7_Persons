package de.fherfurt.persons.service.resources;

import de.fherfurt.persons.service.model.Person;
import de.fherfurt.persons.service.persistence.repository.PersonRepository;
import de.fherfurt.persons.service.persistence.repository.RepositoryFactory;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author Tran Anh Hoang
 * The class SearchingResource includes iterator search methode for a person (by personId or personinformation)
 * and a search methode for the Avatar of a certain InputField
 */
public class SearchingResource {

    final PersonRepository personRepository;


    public SearchingResource() {
        this.personRepository = RepositoryFactory.getInstance().getPersonRepository();
    }


    @GET
    @Path("{personId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("personId") long  personId ) {

        Person p = this.personRepository.getPersonBy( personId );

        if( p != null )
            return Response.ok( p ).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();
    }
}
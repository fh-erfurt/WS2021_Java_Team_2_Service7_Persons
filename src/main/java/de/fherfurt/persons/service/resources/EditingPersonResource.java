package de.fherfurt.persons.service.resources;


import de.fherfurt.persons.service.model.Person;
import de.fherfurt.persons.service.persistence.repository.PersonAvatarRepository;
import de.fherfurt.persons.service.persistence.repository.PersonRepository;
import de.fherfurt.persons.service.persistence.repository.RepositoryFactory;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;

/**
 * @author Milena Neumann
 * methods to find a person and change attributes
 * TODO: @Milena: Klasse modifizieren, so dass die Endpoints von außen erreichbar sind: BaseRessource --> EditingPerson
 * TODO: PersonRepository Interface auf die jeweilige Methoden anpassen und die dazugehörige Klasse RepositoryImp erweitern
 */
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

}

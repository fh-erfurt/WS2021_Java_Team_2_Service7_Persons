package de.fherfurt.persons.service.resources;

import de.fherfurt.persons.service.model.Person;
import de.fherfurt.persons.service.model.PersonAvatar;
import de.fherfurt.persons.service.persistence.repository.PersonAvatarRepository;
import de.fherfurt.persons.service.persistence.repository.PersonRepository;
import de.fherfurt.persons.service.persistence.repository.RepositoryFactory;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tran Anh Hoang
 * The class SearchingResource includes iterator search methode for a person (by personId or personinformation)
 * and a search methode for the Avatar of a certain InputField
 */
public class SearchingResource {

    final PersonRepository personRepository;
    final PersonAvatarRepository personAvatarRepository;


    public SearchingResource() throws IOException {
        this.personRepository = RepositoryFactory.getInstance().getPersonRepository();
        this.personAvatarRepository = RepositoryFactory.getInstance().getPersonAvatarRepository();
        System.out.println("ist drinne im Konstruktor");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String printTest(){
        return "SearchingResource Endpoint is avaible!";
    }


    @GET
    @Path("/findPerson/{personId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPersonBy(@PathParam("personId") long  personId ) {

        Person p = this.personRepository.findPersonBy( personId );

        if( p != null )
            return Response.ok( p ).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();
    }

    @GET
    @Path("/findAllPerson")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllPerson() {

        List<Person> p = this.personRepository.findAll();

        if( p != null )
            return Response.ok( p ).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();
    }

    @GET
    @Path("/getAllPersonWithDeletedFlag")
    public Response findAllPersonWithoutDeletedFlag() {
        List PersonList = new ArrayList<Person>();

        PersonList = this.personRepository.findAll();

        if( PersonList != null )
            return Response.ok( PersonList ).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();
    }

    @GET
    @Path("/getAllPersonWithDeletedFlag")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllPersonWithDeletedFlag() {
        List PersonList = new ArrayList<Person>();

        PersonList = this.personRepository.findAll();

        if( PersonList != null )
            return Response.ok( PersonList ).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();
    }


    /*
    @GET
    @Path("{personAvatarid:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPersonAvatarById(@PathParam("personAvatarid") long  personAvatarid ) {


        byte[] PersonAvatar  = this.personAvatarRepository.findPersonAvatarById(personAvatarid);

        if( PersonAvatar != null )
            return Response.ok( PersonAvatar ).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();
    }
    */


}
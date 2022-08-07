package de.fherfurt.persons.service.resources;

import de.fherfurt.persons.service.model.Address;
import de.fherfurt.persons.service.model.Person;
import de.fherfurt.persons.service.model.PersonAvatar;
import de.fherfurt.persons.service.persistence.repository.AddressRepository;
import de.fherfurt.persons.service.persistence.repository.PersonAvatarRepository;
import de.fherfurt.persons.service.persistence.repository.PersonRepository;
import de.fherfurt.persons.service.persistence.repository.RepositoryFactory;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Tran Anh Hoang
 * @version  2.0.0.0
 * The class SearchingResource includes search methode the find specifics Parameter of Person or all the data of a Person
 */
public class SearchingResource {

    final PersonRepository personRepository;
    final PersonAvatarRepository personAvatarRepository;
    final AddressRepository addressRepository;


    public SearchingResource() throws IOException {
        this.personRepository = RepositoryFactory.getInstance().getPersonRepository();
        this.personAvatarRepository = RepositoryFactory.getInstance().getPersonAvatarRepository();
        this.addressRepository = RepositoryFactory.getInstance().getAddressRepository();
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
    @Path("/findPersonBy/{firstname}/{lastname}/{major}/{faculty}")
    public Response findPersonByUserInput(@PathParam("firstname") String firstname, @PathParam("lastname") String lastname,
                                          @PathParam("major") String major, @PathParam("faculty") String faculty ) {

        this.personRepository.findAllPersonsByUserInput(firstname, lastname, major, faculty);

        if( this.personRepository.findAllPersonsByUserInput(firstname, lastname, major, faculty) != null )
            return Response.ok( this.personRepository.findAllPersonsByUserInput(firstname, lastname, major, faculty) ).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();

    }

    @GET
    @Path("/findAllPersonWithDeletedFlag")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllPersonWithDeletedFlag() {
        if( this.personRepository.findAllPersonWithDeletedFlag() != null )
            return Response.ok(this.personRepository.findAllPersonWithDeletedFlag()).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();

    }

    @GET
    @Path("/findAllPersonWithOutDeletedFlag")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllPersonWithOutDeletedFlag() {
        if( this.personRepository.findAllPersonsWithoutDeletedFlag() != null )
            return Response.ok(this.personRepository.findAllPersonsWithoutDeletedFlag()).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();

    }


    @GET
    @Path("/findPersonAvatar/{personAvatarid:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPersonAvatarById(@PathParam("personAvatarid") long  personAvatarid ) {



        if( this.personAvatarRepository.findPersonAvatarById(personAvatarid) != null )
            return Response.ok( new BigInteger(this.personAvatarRepository.findPersonAvatarById(personAvatarid)).intValue() ).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();
    }



    @GET
    @Path("/findAllPersonWithEqualAddressId/{street}/{city}/{zipCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllPersonWithEqualAddressId(@PathParam("street") String street,
                                                    @PathParam("city") String city,
                                                    @PathParam("zipCode") String zipCode) {


        if( this.personRepository.findAllPersonWithEqualAddress(street, city, zipCode) != null )
            return Response.ok(this.personRepository.findAllPersonWithEqualAddress(street, city, zipCode)).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();
    }


    /**
     * findAddressById returns an address of a person if you put in a addressID
     * @author  Milena Neumann
     * @version  2.0.0.0
     */
    @GET
    @Path("/findAddressById/{addressId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAddressById(
        @PathParam("addressId") long addressId
    ) {
        if( this.addressRepository.findAddressBy(addressId) != null)
            return Response.ok(this.addressRepository.findAddressBy(addressId)).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();
    }



    /**
     * findPersonByAddressId returns an PersonDataSet if you put in a addressId of the person
     * @author  Milena Neumann
     * @version  2.0.0.0
     */
    @GET
    @Path("/findPersonByAddressId/{addressId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPersonsByAddressId(@PathParam("addressId") long addressId                                                 ) {


        if( this.personRepository.findPersonsByAddressId(addressId) != null )
            return Response.ok(this.personRepository.findPersonsByAddressId(addressId)).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();
    }

    /**
     * findAllPersonsByFaculty returns all persons with the input faculty
     * @author  Milena Neumann
     * @version  2.0.0.0
     */
    @GET //überall bei find all, über find all person(personrepo) alle perspm reinholen, über stram nach gesuchten attribut
    @Path("/findAllPersonsByFaculty/{facultyName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllPersonByFaculty(
        @PathParam("facultyName") String facultyName)
    {
        if( this.personRepository.findPersonsByFacultyName(facultyName) != null )
            return Response.ok(this.personRepository.findPersonsByFacultyName(facultyName)).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();
    }
}


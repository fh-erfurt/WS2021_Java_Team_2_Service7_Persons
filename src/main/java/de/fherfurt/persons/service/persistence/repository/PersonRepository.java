package de.fherfurt.persons.service.persistence.repository;


import de.fherfurt.persons.service.model.Address;
import de.fherfurt.persons.service.model.Person;
import jakarta.ws.rs.PathParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The interface PersonRepository represent the abstract layer between Resources-Layer and Repository-Layer.
 * @author  Tran Anh Hoang
 * @version  2.0.0.0
 */
public interface PersonRepository {
    
    boolean createPerson( Person person );
    
    List<Person> findAllPersonsByUserInput(String firstname, String lastname, String major, String faculty);

    Person findPersonBy(long personId );

    List<Person> findAll();

    boolean updatePersonById(Person person );
    
    boolean deletePersonById( long personId );

    List<Person> findAllPersonWithDeletedFlag();

    List<Person> findAllPersonsWithoutDeletedFlag();

    List<Person> findAllPersonWithEqualAddress(String street, String city, String zipCode);
}

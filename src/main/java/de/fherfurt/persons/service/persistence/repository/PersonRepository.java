package de.fherfurt.persons.service.persistence.repository;


import de.fherfurt.persons.service.model.Address;
import de.fherfurt.persons.service.model.Person;
import jakarta.ws.rs.PathParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Tran Anh Hoang
 * Repository to storage person objects. The PersonRepository has a Singleton Pattern, and it exists only one instance of this class!
 */
public interface PersonRepository {
    
    boolean createPerson( Person person );
    
    List<Person> findAllPersonsByUserInput(String firstname, String lastname, String major, String faculty);

    Person findPersonBy(long personId );

    List<Person> findAll();

    List<Person> findPersonsByAddressId(long addressId);

    List<Person> findPersonsByFacultyName(String facultyName);

    boolean updatePersonById(Person person );
    
    boolean deletePersonById( long personId );

    List<Person> findAllPersonWithDeletedFlag();

    List<Person> findAllPersonsWithoutDeletedFlag();

    List<Person> findAllPersonWithEqualAddress(String street, String city, String zipCode);
}

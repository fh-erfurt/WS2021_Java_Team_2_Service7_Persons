package de.fherfurt.persons.service.persistence.repository;


import de.fherfurt.persons.service.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Luisa Oswald, Tran Anh Hoang
 * Repository to storage person objects. The PersonRepository has a Singleton Pattern, and it exists only one instance of this class!
 */
public interface PersonRepository {
    
    boolean createPerson( Person person );
    
    List<Person> findAllPersonsByUserInput(String inFirstName, String inLastName, String inMajor, String inFaculty);

    Person findPersonBy(long personId );

    List<Person> findAll();


    boolean updatePersonById(long personId, Person person );
    
    boolean deletePersonId( long personId );
    
    List<Person> getPersonsWithAddress(long addressId );

    List<Person> findAllPersonWithDeletedFlag();

    List<Person> findAllPersonsWithoutDeletedFlag();


    
}

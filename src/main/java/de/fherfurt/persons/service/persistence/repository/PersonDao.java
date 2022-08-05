package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.model.Person;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PersonDao extends GenericDao<Person>{
    /**
     * This Methode "findPersonUsingIteratorByPersonID" will find a InputField from the ArrayList by the personId with an Iterator.
     * @param //personId this Parameter is needed for the Searching
     * @return Optional (InputField) with all her/his values
     */
    Person findPersonById(long personId);

    Collection<Person> findPersonBy(String firstname, String lastname, String major, String faculty );



    Collection<Person> findAllPersonWithDeletedFlag();

    Collection<Person> findAllPersonsWithoutDeletedFlag();

}

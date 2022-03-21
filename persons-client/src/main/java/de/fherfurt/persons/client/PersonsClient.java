package de.fherfurt.persons.client;
import java.util.Optional;

/**
 * @author Tran Anh Hoang
 * @version 1.0.0.0
 * This Interface defines the provided functionality for Person Service.
 * It should be used by other services.
 */
public interface PersonsClient {

    /**
     * This Methode "findPersonUsingIteratorByPersonID" will
     * find a Person from the ArrayList by
     * the personId with an Iterator.
     * @param personId - this Parameter is needed for the Searching.
     * @return Optional (Person) with all her/his values
     */
    Optional findPersonUsingIteratorBy(int personId);

    /**
     * This methode "findPersonAvatarBy" will find a Person Avatar from a HashMap
     * through a personId - Key.
     * @param personId Id of a person
     * @return byte Code which
     */
    byte[] findPersonAvatarBy(int personId);
}

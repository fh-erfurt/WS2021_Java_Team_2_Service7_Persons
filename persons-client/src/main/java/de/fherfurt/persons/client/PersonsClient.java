package de.fherfurt.persons.client;

import java.io.IOException;
import java.util.Optional;

/**
 * @author Tran Anh Hoang
 * @version 1.0.0.0
 */
public interface PersonsClient
{
    /**
     *
     * This Methode "findPersonUsingIteratorByPersonID" will
     * find a Person from the ArrayList by
     * the PersonID with an Iterator
     * @param PersonID - this Parameter is needed for the Searching.
     * @return Person with all her/his values
     *
     */
    Optional findPersonUsingIteratorBy(int PersonID);


    byte[] findPersonAvatarBy(int PersonID);


    /**
     * This Methode can be used to get an Image of a Person
     * @param PersonID - this Parameter is needed for the Searching for an Image/avara of a Person
     * @throws IOException
     */
    void convertByteArrayIntoAvatarImage(int PersonID) throws IOException;
}

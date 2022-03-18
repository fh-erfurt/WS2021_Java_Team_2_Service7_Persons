package de.fherfurt.persons.service.core;
import de.fherfurt.persons.client.PersonsClient;
import de.fherfurt.persons.service.persistence.PersonAvatarRepository;
import de.fherfurt.persons.service.persistence.PersonRepository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
/**
 * @author Tran Anh Hoang
 * The Class SearchingSystem include Iterator Search Methode for a Person (by PersonID or Personinformation)
 * and a search Methode for the Avator of an certain Person
 */
public class SearchingSystem implements PersonsClient
{
    private ArrayList<String> SearchInputData = new ArrayList<>();

    /**
     * set ArrayList with the Inputdata of the User from the class Inputfield
     * @param searchInputData ArrayList from class Inpufield, which includes the the User Search Parameters
     *
     * */
    public void setSearchInputData(ArrayList<String> searchInputData) {
        this.SearchInputData = searchInputData;
    }

    public ArrayList<String> getSearchInputData() {
        return SearchInputData;
    }

    /**
     * This Methode "findPersonUsingIteratorByPersonID" will find a Person from the ArrayList by the PersonID with an Iterator
     * @param PersonID Unique Key-Value to find a certain Person from the ArrayList
     * @return Person with all her/his values
     */
    @Override
    public Optional<Person> findPersonUsingIteratorBy(int PersonID) {

        return PersonRepository.getInstance().getPersonList().stream().
                filter(person -> Objects.equals(person.getPersonID(), PersonID)).
                findAny();
    }



    /**
     * This Methode will find a Person from FirstName, LastName and Major
     * @param firstname
     * @param lastname
     * @param major
     * @param faculty
     * @return a Person with all his/her Attributes in a Form of an Array
     */
    public List<Person> findPersonUsingIteratorBy(String firstname, String lastname, String major, String faculty ) {

        return PersonRepository.getInstance().getPersonList().stream()
                .filter(person -> Objects.equals(person.getFirstname() , firstname)
                        || Objects.equals(person.getLastname() , lastname )
                        || Objects.equals(person.getMajor(), major)
                        || Objects.equals(person.getFaculty(), faculty))
                .collect(toList());
    }

    /**
     * The "findPersonAvatarBy"-Method use the Singleton Pattern to access the class PersonAvatarRepository
     * @param PersonID unique Key-Value to find in certain Avator of Person
     * @return returns a byte Array of an Image of a Person
     */
    @Override
    public byte[] findPersonAvatarBy(int PersonID) {
        PersonAvatarRepository Repo = PersonAvatarRepository.getInstance();
        return Repo.getAvatarStorageBy(PersonID);
    }

    /**
     * The "convertByteArrayIntoAvatarImage"-Methode convert a Byte-Array back to an Image
     * @param PersonID unique Key-Value to find in certain Avator of a Person
     * return Image of a Person
     */
    public BufferedImage convertByteArrayIntoAvatarImage(int PersonID) throws IOException {
        return ImageIO.read(new ByteArrayInputStream(findPersonAvatarBy(PersonID)));
    }

    /**
     * The "findAllPersonWithDeleteFlag" . will find all Person with a DeleteFlag add them get it into a List
     * @return List of all Person with a Delete-Flag
     */
    public List<Person> findAllPersonWithDeleteFlag() {
        return PersonRepository.getInstance().getPersonList().stream().
                filter(person -> Objects.equals(person.getDeletedFlag() ,true)).toList();
    }
}
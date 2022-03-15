package de.fherfurt.persons.service.core;
import de.fherfurt.persons.client.PersonsClient;
import de.fherfurt.persons.service.persistence.PersonAvatarRepository;
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
    private List<Person> PersonStorage = new ArrayList<>();
    private int pos = 0;

    /**
     * set ArrayList with the Inputdata of the User from the class Inputfield
     * @param searchInputData ArrayList from class Inpufield, which includes the the User Search Parameters
     */
    public void setSearchInputData(ArrayList searchInputData)
    {
        SearchInputData = searchInputData;
    }


    public void setStorageBy(List<Person> PersonStorage)
    {
        this.PersonStorage = PersonStorage;
    }


    public ArrayList<String> getSearchInputData()
    {
        return SearchInputData;
    }

    public List<Person> getPersonStorage()
    {
        return PersonStorage;
    }


    /**
     * This Methode "findPersonUsingIteratorByPersonID" will find a Person from the ArrayList by the PersonID with an Iterator
     * @param PersonID Unique Key-Value to find a certain Person from the ArrayList
     * @return Person with all her/his values
     */
    @Override
    public Optional<Person> findPersonUsingIteratorBy(int PersonID) {
                return PersonStorage.stream()
                .filter(person -> Objects.equals(person.getPersonID(), PersonID))
                .findAny();
    }


    /**
     * This Methode will find a Person from FirstName, LastName and Major
     * @param FirstName
     * @param LastName
     * @param Major
     * @return a Person with all his/her Attributes in a Form of an Array
     */
    public Person findPersonUsingIteratorBy(String FirstName, String LastName, String Major)
    {

        return (Person) PersonStorage.stream()
                .filter(str -> Objects.equals(Person.builder().getFirstname() , FirstName) && Objects.equals(Person.builder().getLastname(), LastName ) && Objects.equals(Person.builder().getMajor(), Major) )
                .collect(toList());

        /*
        return  PersonStorage.stream()
                .filter(str -> str.equals(this.SearchInputData))
                .findAny()
                .orElse(null);

        return WantedPerson;
        */
    }


    /**
     * The "findPersonAvatarBy"-Method use the Singleton Pattern to access the class PersonAvatarRepository
     * @param PersonID unique Key-Value to find in certain Avator of Person
     * @return returns a byte Array of an Image of a Person
     */
    @Override
    public byte[] findPersonAvatarBy(int PersonID)
    {
        PersonAvatarRepository Repo = PersonAvatarRepository.getInstance();
        return Repo.getAvatarStorageBy(PersonID);
    }

    /**
     * The "convertByteArrayIntoAvatarImage"-Methode convert a Byte-Array back to an Image
     * @param PersonID unique Key-Value to find in certain Avator of a Person
     * @return Image of a Person
     */
    @Override
    public void convertByteArrayIntoAvatarImage(int PersonID) throws IOException
    {
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(findPersonAvatarBy(PersonID)));
    }

}
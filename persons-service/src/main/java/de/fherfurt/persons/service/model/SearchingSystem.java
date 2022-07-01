package de.fherfurt.persons.service.model;
import de.fherfurt.persons.client.PersonsClient;
import de.fherfurt.persons.service.persistence.repository.PersonAvatarRepository;
import de.fherfurt.persons.service.persistence.repository.PersonRepository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * @author Tran Anh Hoang
 * The class SearchingSystem includes iterator search methode for a person (by personId or personinformation)
 * and a search methode for the Avatar of a certain Person
 */
public class SearchingSystem implements PersonsClient
{
    /**
     * This methode "findPersonUsingIteratorByPersonId" will find a person from the ArrayList by the personId with an iterator
     * @param personId Unique Key-Value to find a certain Person from the ArrayList
     * @return Person with all her/his values
     */
    @Override
    public Optional<Person> findPersonBy(int personId) {

        return PersonRepository.getInstance().getPersonList().stream().
                filter(person -> Objects.equals(person.getPersonId(), personId)).
                findAny();
    }

    /**
     * This Methode will find a Person from firstName, lastName and major
     * @param firstname - Firstname of a Person
     * @param lastname - Last of a Person
     * @param major - Major of a Person
     * @param faculty - attended faculty of a Person
     * @return a Person with all his/her Attributes in a Form of an Array
     */
    public List<Person> findPersonBy(String firstname, String lastname, String major, String faculty ) {

        return PersonRepository.getInstance().getPersonList().stream()
                .filter(person -> Objects.equals(person.getFirstname(),firstname)
                        || Objects.equals(person.getLastname(),lastname)
                        || Objects.equals(person.getMajor(),major)
                        || Objects.equals(person.getFaculty(),faculty))
                .collect(toList());
    }

    /**
     * The "findPersonAvatarBy"- method use the Singleton Pattern to access the class PersonAvatarRepository
     * @param personId unique Key-Value to find in certain avatar of a person
     * @return returns a byte array of an image of a person
     */
    @Override
    public byte[] findPersonAvatarBy(int personId) {
        PersonAvatarRepository avatarRepo = PersonAvatarRepository.getInstance();
        return avatarRepo.getAvatarStorageBy(personId);
    }

    /**
     * The "convertByteArrayIntoAvatarImage"-method convert a Byte-Array back to an image
     * @param personId unique Key-Value to find in certain avatar of a Person
     * return Image of a person
     */
    public BufferedImage convertByteArrayIntoAvatarImage(int personId) throws IOException {
        return ImageIO.read(new ByteArrayInputStream(findPersonAvatarBy(personId)));
    }

    /**
     * The "findAllPersonWithDeleteFlag" will find all Person with a DeleteFlag add them into a list
     * @return List of all persons with a deleted-Flag
     */
    public List<Person> findAllPersonWithDeletedFlag() {
        return PersonRepository.getInstance().getPersonList().stream().
                filter(person -> Objects.equals(person.getDeletedFlag() ,true)).toList();
    }

    /**
     * @author Milena Neumann
     * finds all persons without deletedFlag
     * @return List of persons without deleted Flag
     */
    public List<Person> findAllPersonsWithoutDeletedFlag() {
        return PersonRepository.getInstance().getPersonList().stream().
                filter(person -> Objects.equals(person.getDeletedFlag() ,false)).toList();
    }
}
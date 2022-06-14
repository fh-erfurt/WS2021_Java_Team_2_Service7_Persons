package de.fherfurt.persons.service.persistence;


import de.fherfurt.persons.service.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Luisa Oswald, Tran Anh Hoang
 * Repository to storage person objects. The PersonRepository has a Singleton Pattern, and it exists only one instance of this class!
 */
public class PersonRepository {

    private static final PersonRepository personStorage = new PersonRepository();

    private final List<Person> storage = new ArrayList<>();

    private PersonRepository(){
    }

    /**
     * Save a person object with all his/her data structures and methods in an ArrayList
     * @param person Person object from class Person
     */
    public void persist(Person person) {
        if (!checkIfPersonIdAlreadyExistBy(person.getPersonId())) {
            storage.add(person);
        }
        else {
            System.out.println("Person already Exist!");
        }
    }

    /**
     * @return storage Arraylist
     */
    public List<Person> getPersonList()
    {
        return storage;
    }

    /**
     * Accessing point of the PersonRepository class
     * @return Instance of PersonRepository
     */
    public static PersonRepository getInstance(){
        return personStorage;
    }

    /**
     * Check if a person with this personId already exist in the Arraylist
     * @param personId unique key value for a person
     * @return true -> personId exist, false -> personId don't exist
     */
    public boolean checkIfPersonIdAlreadyExistBy(int personId){
        return PersonRepository.getInstance().getPersonList().stream().
                anyMatch(personResult -> Objects.equals(personResult.getPersonId(), personId));
    }
}

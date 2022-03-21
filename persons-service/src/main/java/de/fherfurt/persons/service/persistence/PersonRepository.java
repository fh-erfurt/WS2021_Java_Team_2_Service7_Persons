package de.fherfurt.persons.service.persistence;


import de.fherfurt.persons.service.core.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Luisa Oswald, Tran Anh Hoang
 */
public class PersonRepository {

    private static final PersonRepository PersonStorage = new PersonRepository();

    private final List<Person> storage = new ArrayList<>();

    private PersonRepository(){
    }

    public void persist(Person person) {
        if (!checkIfPersonIdAlreadyExistBy(person.getPersonId())) {
            storage.add(person);
        }
        else {
            System.out.println("Person already Exist!");
        }
    }

    public List<Person> getPersonList()
    {
        return storage;
    }

    public static PersonRepository getInstance(){
        return PersonStorage;
    }

    public boolean checkIfPersonIdAlreadyExistBy(int personId){
        return PersonRepository.getInstance().getPersonList().stream().
                anyMatch(personResult -> Objects.equals(personResult.getPersonId(), personId));
    }



}

package de.fherfurt.persons.service.persistence;


import de.fherfurt.persons.service.core.Person;
import java.util.ArrayList;
import java.util.List;
public class PersonRepository {

    private static final PersonRepository PersonStorage = new PersonRepository();

    private final List<Person> storage = new ArrayList<>();

    public void persist(Person person) {
        storage.add(person);
    }

    public List<Person> getPersonList()
    {
        return storage;
    }

    public void printArrayList()
    {
        System.out.println(storage);
    }

    public static PersonRepository getInstance(){
        return PersonStorage;
    }
}

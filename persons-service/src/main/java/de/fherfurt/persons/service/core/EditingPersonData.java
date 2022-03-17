package de.fherfurt.persons.service.core;

import de.fherfurt.persons.service.persistence.PersonRepository;

import java.util.Optional;

public class EditingPersonData {

    public void editFirstNameOfPersonBy(int PersonID, String FirstName) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(PersonID);
        wantedPerson.get().setFirstname(FirstName);
    }

    public void editLastNameOfPersonBy(int PersonID, String FirstName) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(PersonID);
        wantedPerson.get().setFirstname(FirstName);
    }



}

package de.fherfurt.persons.service.core;

import java.util.Optional;

public class EditingPerson {
    public void editFirstNameOfPersonBy(int PersonID, String FirstName) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(PersonID);
        wantedPerson.orElseThrow().setFirstname(FirstName);
    }

    public void editLastNameOfPersonBy(int PersonID, String FirstName) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(PersonID);
        wantedPerson.orElseThrow().setFirstname(FirstName);
    }
}

package de.fherfurt.persons.service.core;

import de.fherfurt.persons.service.persistence.PersonRepository;

import java.util.Optional;

public class EditingPersonData {

    public void editFirstNameOfPersonBy(int PersonID, String firstname) {
        SearchingSystem Search = new SearchingSystem();
        Search.findPersonUsingIteratorBy(PersonID).get().setFirstname(firstname);

    }

    public void editLastNameOfPersonBy(int PersonID, String lastname) {
        SearchingSystem Search = new SearchingSystem();
        Search.findPersonUsingIteratorBy(PersonID).get().setFirstname(lastname);;

    }
}

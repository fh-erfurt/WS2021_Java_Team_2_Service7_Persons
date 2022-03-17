package de.fherfurt.persons.service.core;

import de.fherfurt.persons.service.persistence.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;

public class EditingPersonDataTest  {

    @Test
    public void testEditFirstNameOfPersonBy() {

        int PersonID = 12;

        //given
        PersonRepository PersonStorage = new PersonRepository();
        SearchingSystem Search = new SearchingSystem();


        //when
        PersonStorage.persist(Person.student(12,"Julie", "Moldau", "Julie123@abc.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false));

        PersonStorage.persist(Person.student(12,"Anna", "Rheinhard", "Anna@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false));

        PersonStorage.persist(Person.otherEmployee(36,"Peter", "Franz", "Peter@fherfurt.de",
                "Hausmeister"));


        Optional<Person> wantedPerson = PersonStorage.getPersonList().stream().
                filter(person -> Objects.equals(person.getPersonID(), PersonID)).
                findAny();

        wantedPerson.get().setFirstname("Henriette");
        System.out.println(wantedPerson.toString());

        //then
        String PersonNewFirstName = wantedPerson.get().getFirstname();
        Assertions.assertThat(PersonNewFirstName)
                .isEqualTo("Henriette");

        System.out.println(PersonNewFirstName);
    }

    @Test
    public void testEditLastNameOfPersonBy() {
    }
}
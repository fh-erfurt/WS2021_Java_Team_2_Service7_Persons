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
        SearchingSystem Search = new SearchingSystem();


        //when
        PersonRepository.getInstance().persist(Person.student(12,"Julie", "Moldau", "Julie123@abc.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false));

        PersonRepository.getInstance().persist(Person.student(12,"Anna", "Rheinhard", "Anna@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false));

        PersonRepository.getInstance().persist(Person.otherEmployee(36,"Peter", "Franz", "Peter@fherfurt.de",
                "Hausmeister"));


        Search.findPersonUsingIteratorBy(PersonID).get().setFirstname("Henriette");


        //then
        Assertions.assertThat(Search.findPersonUsingIteratorBy(PersonID).get().getFirstname())
                .isEqualTo("Henriette");

        System.out.println(Search.findPersonUsingIteratorBy(PersonID).get().getFirstname());
    }

    @Test
    public void testEditLastNameOfPersonBy() {
    }
}
package de.fherfurt.persons.service.model;

import de.fherfurt.persons.service.persistence.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;


public class EditingPersonTest {

    /**
     * @author Hoang
     */
    @Test
    public void testEditFirstNameOfPersonByPersonIdAndFirstname() {
        int personId = 12;

        //given
        SearchingSystem testSearch = new SearchingSystem();

        PersonRepository.getInstance().persist(Person.student(12,"Julie", "Moldau", "Julie123@abc.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false, false));

        PersonRepository.getInstance().persist(Person.student(13,"Anna", "Rheinhard", "Anna@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false, false));

        PersonRepository.getInstance().persist(Person.otherEmployee(14,"Peter", "Franz", "Peter@fherfurt.de",
                "Hausmeister", false));

        //when
        Optional<Person> wantedPerson = testSearch.findPersonUsingIteratorBy(personId);
        
        //then
        EditingPerson personToEdit = new EditingPerson();
        personToEdit.editFirstNameOfPersonBy(12, "Mira");
        Assertions.assertThat(wantedPerson.orElseThrow().getFirstname())
                .isEqualTo("Mira");
    }

    /**
     * @author Milena Neumann
     */
    @Test
    public void testEditLastNameOfPersonByPersonId() {

        //given
        int personId = 15;
        PersonRepository.getInstance().persist(Person.student(15,"Sandy", "Cheeks", "sandycheeks@abc.de",
                "Angewandte Informatik", "01.11.2020", "01.12.2024",
                false, false, false));

        PersonRepository.getInstance().persist(Person.student(16,"Frank", "Enstein", "frank@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false, false));

        PersonRepository.getInstance().persist(Person.otherEmployee(17,"Gandalf", "der Weiße", "gandalf@fherfurt.de",
                "Hausmeister", false));

        SearchingSystem testSearch = new SearchingSystem();

        //when
        EditingPerson personToEdit = new EditingPerson();
        Optional<Person> wantedPerson = testSearch.findPersonUsingIteratorBy(personId);
        personToEdit.editLastNameOfPersonBy(15, "Schlumpfmetzger");

        //then
        Assertions.assertThat(wantedPerson.orElseThrow().getLastname())
                .isEqualTo("Schlumpfmetzger");
    }

    /**
     * @author Milena Neumann
     */
    @Test
    public void testEditDeletedFlagOfPersonByPersonId() {

        //given
        int personId = 18;
        SearchingSystem testSearch = new SearchingSystem();
        EditingPerson personToEdit = new EditingPerson();

        PersonRepository.getInstance().persist(Person.otherEmployee(18,"Eugene", "Krabs", "Eugene@fherfurt.de",
                "Meister der Münze", false));
        //when
        Optional<Person> wantedPerson = testSearch.findPersonUsingIteratorBy(personId);
        personToEdit.editDeletedFlagOfPersonBy(18, true);

        //then
        Assertions.assertThat(wantedPerson.orElseThrow().getDeletedFlag())
                .isEqualTo(true);
    }
}
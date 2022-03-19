package de.fherfurt.persons.service.core;

import de.fherfurt.persons.service.persistence.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;


public class EditingPersonTest {


    /**
     * @author Hoang
     */
    @Test
    public void testEditFirstNameOfPersonBy() {
        int PersonID = 12;

        //given
        SearchingSystem Search = new SearchingSystem();


        //when
        PersonRepository.getInstance().persist(Person.student(12,"Julie", "Moldau", "Julie123@abc.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false, false));

        PersonRepository.getInstance().persist(Person.student(14,"Anna", "Rheinhard", "Anna@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false, false));

        PersonRepository.getInstance().persist(Person.otherEmployee(36,"Peter", "Franz", "Peter@fherfurt.de",
                "Hausmeister", false));


        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(PersonID);

        System.out.println(wantedPerson.toString());

        wantedPerson.orElseThrow().setFirstname("Henriette");

        //then
        Assertions.assertThat(wantedPerson.get().getFirstname())
                .isEqualTo("Henriette");

        System.out.println(wantedPerson.get().getFirstname());
    }

    /**
     * @author Milena Neumann
     */
    @Test
    public void testEditLastNameOfPersonBy() {

        //given
        int PersonID = 12;
        SearchingSystem Search = new SearchingSystem();
        PersonRepository.getInstance().persist(Person.student(12,"Julie", "Moldau", "Julie123@abc.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false, false));

        PersonRepository.getInstance().persist(Person.student(14,"Anna", "Rheinhard", "Anna@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false, false));

        PersonRepository.getInstance().persist(Person.otherEmployee(36,"Peter", "Franz", "Peter@fherfurt.de",
                "Hausmeister", false));

        //when
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(PersonID);
        EditingPerson.editLastNameOfPersonBy(12, "Schlumpfmetzger");

        //then

        System.out.println(wantedPerson);
        Assertions.assertThat(wantedPerson.get().getLastname())
                .isEqualTo("Schlumpfmetzger");
    }

    /**
     * @author Milena Neumann
     */
    @Test
    public void testEditDeletedFlagOfPersonBy() {

        //given
        int PersonID = 245;
        SearchingSystem Search = new SearchingSystem();
        PersonRepository.getInstance().persist(Person.student(12,"Julie", "Moldau", "Julie123@abc.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false, false));

        PersonRepository.getInstance().persist(Person.student(14,"Anna", "Rheinhard", "Anna@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false, false));

        PersonRepository.getInstance().persist(Person.otherEmployee(36,"Peter", "Franz", "Peter@fherfurt.de",
                "Hausmeister", false));

        PersonRepository.getInstance().persist(Person.otherEmployee(245,"Eugene", "Krabs", "Eugene@fherfurt.de",
                "Meister der Münze", false));
        //when
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(PersonID);
        EditingPerson.editDeletedFlagOfPersonBy(245, true);

        //then
        System.out.println(wantedPerson);
        System.out.println(Search.findAllPersonWithDeleteFlag());
        Assertions.assertThat(wantedPerson.get().getDeletedFlag())
                .isEqualTo(true);
    }
}
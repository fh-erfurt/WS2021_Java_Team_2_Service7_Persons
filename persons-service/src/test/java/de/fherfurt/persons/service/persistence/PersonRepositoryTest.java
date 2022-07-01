package de.fherfurt.persons.service.persistence;

import de.fherfurt.persons.service.model.Person;
import de.fherfurt.persons.service.persistence.repository.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Tran Anh Hoang
 */
class PersonRepositoryTest {

    @Test
    void shouldPersist() {
        //given
        Person testPerson1 =  Person.student(121,"Anne", "Ludwid", "AnneLudwig@gmail.de",
                "BWL", "01.10.2020", "01.10.2024",
                false, false, false);


        //then
        PersonRepository.getInstance().persist(testPerson1);

        //when
        Assertions.assertThat(PersonRepository.getInstance().getPersonList().contains(testPerson1))
                .isNotNull()
                .isTrue();


    }

    @Test
    void shouldCheckIfPersonIdAlreadyExistBy() {

        //given
        Person testPerson2 =  Person.student(1,"Marie", "Curie", "MarieCurie@Nobelpreis.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false, false);

        Person testPerson3 =  Person.student(1,"Marie", "Curie", "MarieCurie@Nobelpreis.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false, false);

        Person testPerson4 =  Person.student(2,"Andre", "Dorfstein", "Andre@Dorfstein.de",
                "BWL", "01.10.2020", "01.10.2024",
                false, false, false);

        //then
        PersonRepository.getInstance().persist(testPerson2);

        //when
        Assertions.assertThat(PersonRepository.getInstance().checkIfPersonIdAlreadyExistBy(testPerson3.getPersonId())).isTrue();
        Assertions.assertThat(PersonRepository.getInstance().checkIfPersonIdAlreadyExistBy(testPerson4.getPersonId())).isFalse();

    }
}
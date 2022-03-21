package de.fherfurt.persons.service.persistence;

import de.fherfurt.persons.service.core.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Tran Anh Hoang
 */
class PersonRepositoryTest {

    @Test
    void shouldPersist() {
        //given
        Person TestPerson1 =  Person.student(121,"Anne", "Ludwid", "AnneLudwig@gmail.de",
                "BWL", "01.10.2020", "01.10.2024",
                false, false, false);


        //then
        PersonRepository.getInstance().persist(TestPerson1);

        //when
        Assertions.assertThat(PersonRepository.getInstance().getPersonList().contains(TestPerson1))
                .isNotNull()
                .isTrue();


    }

    @Test
    void shouldCheckIfPersonIdAlreadyExistBy() {

        //given
        Person TestPerson2 =  Person.student(1,"Marie", "Curie", "MarieCurie@Nobelpreis.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false, false);

        Person TestPerson3 =  Person.student(1,"Marie", "Curie", "MarieCurie@Nobelpreis.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false, false);

        Person TestPerson4 =  Person.student(2,"Andre", "Dorfstein", "Andre@Dorfstein.de",
                "BWL", "01.10.2020", "01.10.2024",
                false, false, false);

        //then
        PersonRepository.getInstance().persist(TestPerson2);

        //when
        Assertions.assertThat(PersonRepository.getInstance().checkIfPersonIdAlreadyExistBy(TestPerson3.getPersonId())).isTrue();
        Assertions.assertThat(PersonRepository.getInstance().checkIfPersonIdAlreadyExistBy(TestPerson4.getPersonId())).isFalse();

    }
}
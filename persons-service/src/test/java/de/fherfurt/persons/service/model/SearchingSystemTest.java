package de.fherfurt.persons.service.model;

import de.fherfurt.persons.service.persistence.repository.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

/**
 * @author Tran Anh Hoang
 * Testing Class for the Core-Class SearchingSystem
 * only include business-methods
 */
class SearchingSystemTest {
    
    @Test
    void testFindPersonUsingIteratorByFirstNameLastNameMajor() {
        //given
        String firstName = "Anna";
        String lastName = "Rheinhard";
        String major = "BWL";
        String modul = "";

        Person testStudent = (Person.student(1,"Anna", "Rheinhard", "Anna@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false, false));

        PersonRepository.getInstance().persist(testStudent);

        PersonRepository.getInstance().persist(Person.student(2,"Julie", "Moldau", "Julie123@abc.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false, false));

        SearchingSystem personsSearch = new SearchingSystem();

        //when
        List<Person> result = personsSearch.findPersonBy(firstName, lastName, major, modul);

        //then
        Assertions.assertThat(result)
                .isNotEmpty()
                .doesNotHaveDuplicates()
                .contains(testStudent);
    }

    @Test
    void shouldConvertByteArrayIntoAvatarImage() throws IOException {
        //given
        SearchingSystem imageSearch = new SearchingSystem();
        String imagePath = Paths.get("Meme_Macron.png").toAbsolutePath().toString();
        System.out.println(imagePath);
        int personId = 1;

        //when
        PersonAvatar testAvatar = new PersonAvatar();
        testAvatar.convertImageToByteArray(imagePath);
        testAvatar.setAvatarByteArrayIntoAvatarRepositoryBy(personId);

        //then
        imageSearch.convertByteArrayIntoAvatarImage(personId);
    }

    @Test
    void shouldPersonUsingIteratorByPersonID() {
        //given
        SearchingSystem personsSearch = new SearchingSystem();
        int personId = 3;
        Person testPerson1 = Person.student(3,"Julie", "Moldau", "Julie123@abc.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false, false);

        //when
        PersonRepository.getInstance().persist(Person.student(3,"Julie", "Moldau", "Julie123@abc.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false, false));
      
        PersonRepository.getInstance().persist(Person.student(4,"Anna", "Rheinhard", "Anna@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false, false));

        PersonRepository.getInstance().persist(Person.otherEmployee(5,"Peter", "Franz", "Peter@fherfurt.de",
                "Hausmeister", false));

        Optional<Person> result = personsSearch.findPersonBy(personId);

        //then
        Assertions.assertThat(result.equals(testPerson1));
    }



    @Test
    public void shouldFindAllPersonWithDeleteFlag() {
        //given
        SearchingSystem personsSearch = new SearchingSystem();

        PersonRepository.getInstance().persist(Person.student(111,"Fritz", "Leonard", "Fritz@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false, true));

        PersonRepository.getInstance().persist(Person.student(112,"Hannah", "Ahrens", "Hannah@abc.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false, true));

        //then

        List<Person> personsWithDeleteFlags = personsSearch.findAllPersonWithDeletedFlag();
        //when
        Assertions.assertThat(personsWithDeleteFlags)
                .isNotEmpty();

        Assertions.assertThat(personsWithDeleteFlags.get(0).getDeletedFlag())
                .isTrue();
    }

    @Test
    public void shouldFindAllPersonWithoutDeleteFlag(){
        //given
        Person testPerson2 = Person.student(114,"Ernst", "Rutherford", "Ernst@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false, false);

        PersonRepository.getInstance().persist(testPerson2);
        SearchingSystem searchPersonWithoutDeleteFlag = new SearchingSystem();

        //then
        List<Person> resultPersonWithoutDeleteFlag = searchPersonWithoutDeleteFlag.findAllPersonsWithoutDeletedFlag();

        //when
        Assertions.assertThat(resultPersonWithoutDeleteFlag).isNotEmpty().contains(testPerson2);
    }
}
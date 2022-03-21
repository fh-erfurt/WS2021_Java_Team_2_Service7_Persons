package de.fherfurt.persons.service.core;

import de.fherfurt.persons.service.persistence.PersonAvatarRepository;
import de.fherfurt.persons.service.persistence.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import static java.util.stream.Collectors.toList;

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

        PersonRepository.getInstance().persist(Person.student(1,"Anna", "Rheinhard", "Anna@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false, false)  );

        PersonRepository.getInstance().persist(Person.student(2,"Julie", "Moldau", "Julie123@abc.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false, false));

        //when
        List<Person> result = PersonRepository.getInstance().getPersonList().stream()
                .filter(person -> Objects.equals(person.getFirstname(), firstName))
                .filter(person -> Objects.equals(person.getLastname(), lastName))
                .filter(person -> Objects.equals(person.getMajor(), major)).toList();

        //then
        Assertions.assertThat(result)
                .isNotEmpty()
                .doesNotHaveDuplicates();
    }

    @Test
    public byte[] shouldFindPersonAvatarBy(int personId)
    {
        PersonAvatarRepository testRepo = PersonAvatarRepository.getInstance();
        return testRepo.getAvatarStorageBy(personId);
    }

    @Test
    void shouldConvertByteArrayIntoAvatarImage() throws IOException {
        //given
        String imagePath = Paths.get("Meme_Macron.png").toAbsolutePath().toString();
        System.out.println(imagePath);
        int personId = 1;

        //when
        PersonAvatar testAvatar = new PersonAvatar();
        testAvatar.convertImageToByteArray(imagePath);
        testAvatar.setAvatarByteArrayIntoAvatarRepositoryBy(personId);

        //then
        BufferedImage testImage = ImageIO.read(new ByteArrayInputStream(shouldFindPersonAvatarBy(personId)));
    }

    @Test
    void shouldPersonUsingIteratorByPersonID() {
        //given
        int personId = 3;

        //when
        PersonRepository.getInstance().persist(Person.student(3,"Julie", "Moldau", "Julie123@abc.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false, false));
      
        PersonRepository.getInstance().persist(Person.student(4,"Anna", "Rheinhard", "Anna@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false, false));

        PersonRepository.getInstance().persist(Person.otherEmployee(5,"Peter", "Franz", "Peter@fherfurt.de",
                "Hausmeister", false));

        Optional<Person> result =  PersonRepository.getInstance().getPersonList().stream()
                .filter(person -> Objects.equals(person.getPersonId(),personId))
                .findAny();


        //then
        Assertions.assertThat(PersonRepository.getInstance().getPersonList().get(2).getPersonId())
                .as("Check if personId: " + personId + " is equals to ").isEqualTo(3);
        }


    @Test
    public void shouldFindAllPersonWithDeleteFlag() {
        //given
        PersonRepository.getInstance().persist(Person.student(111,"Fritz", "Leonard", "Fritz@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false, true));

        PersonRepository.getInstance().persist(Person.student(112,"Hannah", "Ahrens", "Hannah@abc.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false, true));

        //then
        List<Person> personsWithDeleteFlags = PersonRepository.getInstance().getPersonList().stream().
                filter(person -> Objects.equals(person.getDeletedFlag() ,true)).toList();

        //when
        Assertions.assertThat(personsWithDeleteFlags)
                .isNotEmpty()
                .hasSize(2);

        Assertions.assertThat(personsWithDeleteFlags.get(0).getDeletedFlag())
                .isTrue();
    }
}
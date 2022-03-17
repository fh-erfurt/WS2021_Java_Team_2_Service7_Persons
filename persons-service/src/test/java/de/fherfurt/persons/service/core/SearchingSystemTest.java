package de.fherfurt.persons.service.core;

import de.fherfurt.persons.service.persistence.PersonAvatarRepository;
import de.fherfurt.persons.service.persistence.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.stream.Collectors.toList;


/**
 * @author Tran Anh Hoang
 * Testing Class for the Core-Class SearchingSystem
 * only include business-methods
 */
class SearchingSystemTest
{

    @Test
    void shouldPersonUsingIteratorByPersonID() {
        //given
        int PersonID = 36;
        PersonRepository PersonStorage = new PersonRepository();


        //when
        PersonRepository.getInstance().persist(Person.student(3,"Julie", "Moldau", "Julie123@abc.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false));

        PersonRepository.getInstance().persist(Person.student(4,"Anna", "Rheinhard", "Anna@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false));

        PersonRepository.getInstance().persist(Person.otherEmployee(36,"Peter", "Franz", "Peter@fherfurt.de",
                "Hausmeister"));

        Optional<Person> result =  PersonRepository.getInstance().getPersonList().stream()
                .filter(person -> Objects.equals(person.getPersonID(),PersonID))
                .findAny();


        //then
        Assertions.assertThat(result.orElseThrow())
                .isEqualTo(PersonRepository.getInstance().getPersonList().get(2));

        Assertions.assertThat(PersonRepository.getInstance().getPersonList().get(2).getPersonID())
                .as("Check if PersonID: " + PersonID + " is equals to ").isEqualTo(36);

        System.out.println(result.get());
    }

    @Test
    void testFindPersonUsingIteratorByFirstNamLastNameMajor() {
        //given
        String FirstName = "Anna";
        String LastName = "Rheinhard";
        String Major = "BWL";


        PersonRepository.getInstance().persist(Person.student(1,"Anna", "Rheinhard", "Anna@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false));


        PersonRepository.getInstance().persist(Person.student(2,"Julie", "Moldau", "Julie123@abc.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                 false, false));


        //when
        List<Person> result = PersonRepository.getInstance().getPersonList().stream()
                .filter(person -> Objects.equals(person.getFirstname(), FirstName))
                .filter(person -> Objects.equals(person.getLastname(), LastName))
                .filter(person -> Objects.equals(person.getMajor(), Major)).toList();

        //then
        Assertions.assertThat(result)
                .isNotEmpty()
                .hasSize(1)
                .doesNotHaveDuplicates();

        //für ein Eingiff auf die Datensätze
        System.out.println(result.get(0).getFirstname());

    }

    @Test
    public byte[] shouldFindPersonAvatarBy(int PersonID)
    {
        PersonAvatarRepository Repo = PersonAvatarRepository.getInstance();
        return Repo.getAvatarStorageBy(PersonID);
    }

    @Test
    void shouldConvertByteArrayIntoAvatarImage() throws IOException
    {
        //given
        String ImagePath = "/home/hoang/Desktop/WS2021_Java_Team_2_Service_Persons_local_new/Meme_Macron.png";
        int PersonID = 1;

        //when
        PersonAvatar Avatars = new PersonAvatar();
        Avatars.convertImageToByteArray(ImagePath);
        Avatars.setAvatarByteArrayIntoAvatarRepositoryBy(PersonID);

        //then
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(shouldFindPersonAvatarBy(PersonID)));
    }

}
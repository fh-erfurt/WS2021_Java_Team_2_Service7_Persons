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

import static java.util.stream.Collectors.toList;


/**
 * @author Tran Anh Hoang
 * Testing Class for the Core-Class SearchingSystem
 * only include business-methods
 */
class SearchingSystemTest
{

    @Test
    void shouldPersonUsingIteratorByPersonID()
    {
        //given
        int PersonID = 36;
        PersonRepository PersonStorage = new PersonRepository();


        //when
        PersonStorage.persist(Person.student(12,"Julie", "Moldau", "Julie123@abc.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                false, false));
        /*
        PersonStorage.persist(Person.student(12,"Anna", "Rheinhard", "Anna@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false));

         */

        PersonStorage.persist(Person.otherEmployee(36,"Franz", "Rheinhard", "Anna@abc.de",
                "Hausmeister"));

        List<Person> result =  PersonStorage.getPersonList().stream()
                .filter(person -> Objects.equals(person.getPersonID(),PersonID))
                .collect(toList());

        //then
        Assertions.assertThat(result)
                .isNotEmpty()
                .hasSize(2)
                .doesNotHaveDuplicates();



        /*
        Assertions.assertThat(Person.getPersonID())
                .as("Check if PersonID: " + PersonID + "is equals to ", Person.getPersonID()).isEqualTo(12);
        /*
        System.out.println(result.toString());
        */
    }

    @Test
    void testFindPersonUsingIteratorByFirstNamLastNameMajor()
    {

        //given
        String FirstName = "Anna";
        String LastName = "Rheinhard";
        String Major = "BWL";

        PersonRepository PersonStorage = new PersonRepository();
        PersonStorage.persist(Person.student(12,"Anna", "Rheinhard", "Anna@abc.de",
                "BWL", "01.10.2019", "01.10.2023",
                false, false));


        PersonStorage.persist(Person.student(12,"Julie", "Moldau", "Julie123@abc.de",
                "Angewandte Informatik", "01.10.2020", "01.10.2024",
                 false, false));


        //when
        List<Person> result = PersonStorage.getPersonList().stream()
                .filter(person -> Objects.equals(person.getFirstName(), FirstName))
                .filter(person -> Objects.equals(person.getLastname(), LastName))
                .filter(person -> Objects.equals(person.getMajor(), Major)).toList();


        //then
        Assertions.assertThat(result)
                .isNotEmpty()
                .hasSize(1)
                .doesNotHaveDuplicates();

        /*
        Assertions.assertThat(.getFirstName())
                .isNotNull()
                .as("Check if FirstName: " + FirstName + " is equals to ", Person.getFirstName()).isEqualTo("Anna");

        Assertions.assertThat(Person.getLastname())
                .isNotNull()
                .as("Check if LastName: " + LastName + "is equals to ", Person.getLastname()).isEqualTo("Rheinhard");


        Assertions.assertThat(Person.getMajor())
                .isNotNull()
                .as("Check if Major: " + Major + "is equals to ", Person.getMajor()).isEqualTo("BWL");
         */

        System.out.println(result.toString());
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
        String ImagePath =  "/home/hoang/Desktop/WS2021_Java_Team_2_Service_Persons_local_new/Meme_Macron.png";
        int PersonID = 1;

        //when
        PersonAvatar Avatars = new PersonAvatar();
        Avatars.convertImageToByteArray(ImagePath);
        Avatars.setAvatarByteArrayIntoAvatarRepositoryBy(PersonID);

        //then
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(shouldFindPersonAvatarBy(PersonID)));
    }
}
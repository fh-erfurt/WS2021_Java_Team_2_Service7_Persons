package de.fherfurt.persons.service.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import de.fherfurt.persons.service.model.Address;
import de.fherfurt.persons.service.model.Faculty;
import de.fherfurt.persons.service.model.Person;
import de.fherfurt.persons.service.model.PersonAvatar;
import lombok.Getter;

import javax.imageio.ImageIO;

public class DataProvider {

    public static ArrayList<Person> createTestData() throws IOException {

        final ArrayList <Person> personTestList = new ArrayList();
        //String imagePath = Paths.get("Meme_Macron.png").toAbsolutePath().toString();
        //PersonAvatar personAvatar01 = new PersonAvatar("imagePath");

        Address address01 = new Address( "Altonaer Strasse 25",     "Erfurt", "99085" );
        Faculty faculty01 = new Faculty("Gebaeudetechnik und Informatik");



        Address address02 = new Address( "Altonaer Strasse 2",     "Erfurt", "99085" );
        Faculty faculty02 = new Faculty("Gebaeudetechnik und Informatik");

        personTestList.add(Person.student("Max", "Mustermann", "m.m@m.com",
                "AI", "21.10.2021", null, false,
                false, false, address01, faculty01));

        return personTestList;

    }


}

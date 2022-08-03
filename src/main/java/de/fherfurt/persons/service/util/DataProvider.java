package de.fherfurt.persons.service.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import de.fherfurt.persons.service.model.Address;
import de.fherfurt.persons.service.model.Faculty;
import de.fherfurt.persons.service.model.Person;
import de.fherfurt.persons.service.model.PersonAvatar;
import lombok.Getter;

import javax.imageio.ImageIO;

public class DataProvider {

    public static ArrayList<Person> createTestData(){

        final ArrayList <Person> personTestList = new ArrayList();
        String imageUrl = "./Meme_Macron.png";
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imageUrl));
        }
        catch (IOException e) {
        }


        Address address01 = new Address( "Altonaer Strasse 25",     "Erfurt", "99085" );
        Faculty faculty01 = new Faculty("Gebaeudetechnik und Informatik");


        personTestList.add(Person.student("Max",    "Mustermann",   "m.m@m.com",
               "AI", "21.10.2021", null, false,
                false, false, address01));

        return personTestList;

    }


}

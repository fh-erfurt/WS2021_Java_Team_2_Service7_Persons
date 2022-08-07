package de.fherfurt.persons.service.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import de.fherfurt.persons.service.model.Address;
import de.fherfurt.persons.service.model.Faculty;
import de.fherfurt.persons.service.model.Person;
import de.fherfurt.persons.service.model.PersonAvatar;
import de.fherfurt.persons.service.persistence.repository.RepositoryFactory;
import lombok.Getter;

public class DataProvider {

    public static ArrayList<Person> createTestData() throws IOException {

        final ArrayList <Person> personTestList = new ArrayList<>();
        final Logger LOGGER = Logger.getLogger( RepositoryFactory.class.getSimpleName() );
        LOGGER.info("Init Data Provider");

        //out comment this code for the issue tracking and in comment the personAvatar01
        //PersonAvatar personAvatar01 = new PersonAvatar(new File("images\\Meme_Macron.png").getAbsoluteFile().toString());


        //Random Byte Array which represent the converting byte array of a image
        byte [] testByteAsImage1 = {80, 61, 41 ,18 ,110 };
        byte [] testByteAsImage2 = {32, 45, 21 ,41 ,92 };
        byte [] testByteAsImage3 = {45, 42, 23 ,48 ,111 };


        Address address01 = new Address( "Altonaer Strasse 25", "Erfurt", "99085" );
        Faculty faculty01 = new Faculty("Gebaeudetechnik und Informatik");
        PersonAvatar personAvatar01 = new PersonAvatar(testByteAsImage1);


        Address address02 = new Address( "Altonaer Strasse 2", "Erfurt", "99085" );
        Faculty faculty02 = new Faculty("Gebaeudetechnik und Informatik");
        PersonAvatar personAvatar02 = new PersonAvatar(testByteAsImage2);


        Address address03 = new Address( "Altonaer Strasse 12", "Erfurt", "99085" );
        Faculty faculty03 = new Faculty("Architektur und Stadtplanung");
        PersonAvatar personAvatar03 = new PersonAvatar(testByteAsImage3);

        personTestList.add(Person.student("Max", "Mustermann", "m.m@m.com",
                "AI", "21.10.2021", null, false,
                false, false, address01, faculty01, personAvatar01));


        personTestList.add(Person.lecturer("Lector", "Lorem",
                "L.L@fh-erfufrt.de","0152485614", "Prof. Dr.",
                "22.02.2012", faculty02, address02,"2.02.E2",true,
                false, personAvatar02 ));


       personTestList.add(Person.otherEmployee("Hans", "Peter","01547568458","Hausmeister"
               ,"H.P@fh-erfufrt.de","3.02.01", faculty03, address03 ,  true,personAvatar03));


        return personTestList;

    }


}

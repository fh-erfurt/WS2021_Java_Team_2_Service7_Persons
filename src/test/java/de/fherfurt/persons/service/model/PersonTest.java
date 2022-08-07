package de.fherfurt.persons.service.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;


/**
 * @Author Tran Anh Hoang
 */
class PersonTest {

    @Test
    void testCreateOtherEmployee() {

        //given
        ArrayList<Person> otherEmployeeList = new ArrayList<>();
        byte [] testByteAsImage1 = {80, 61, 41 ,18 ,110 };
        byte [] testByteAsImage2 = {32, 45, 21 ,41 ,92 };
        byte [] testByteAsImage3 = {45, 42, 23 ,48 ,111 };

        Address address01 = new Address( "Altonaer Strasse 25", "Erfurt", "99085" );
        Faculty faculty01 = new Faculty("Gebaeudetechnik und Informatik");
        PersonAvatar personAvatar01 = new PersonAvatar(testByteAsImage1);
        Person person1 =  Person.otherEmployee("Hannah", "Ahrens","0154551751","Marketing"
                ,"hannah.Ahnrens@fh-erfufrt.de","1.02.11",address01, false, personAvatar01);

        Address address02 = new Address( "Altonaer Strasse 2", "Erfurt", "99085" );
        Faculty faculty02 = new Faculty("Gebaeudetechnik und Informatik");
        PersonAvatar personAvatar02 = new PersonAvatar(testByteAsImage2);
        Person person2 = Person.otherEmployee("Rudolf", "Meyer","015448561","Techniker"
                ,"R.Meyer@fh-erfufrt.de","1.01.02",address02, false, personAvatar02);


        Address address03 = new Address( "Altonaer Strasse 12", "Erfurt", "99085" );
        PersonAvatar personAvatar03 = new PersonAvatar(testByteAsImage3);
        Person person3 = Person.otherEmployee("Hans", "Peter","01547568458","Hausmeister"
                ,"H.P@fh-erfufrt.de","3.02.01",address03, true, personAvatar03);


        //then
        otherEmployeeList.add(person1);
        otherEmployeeList.add(person2);
        otherEmployeeList.add(person3);


        //when
        Assertions.assertThat(otherEmployeeList.stream().filter(person -> person.getPhonenumber().equals("015448561"))).
                isNotEmpty().
                contains(person2);
    }

    @Test
    void testCreatelecturer() {

        //given
        ArrayList<Person> lectureList = new ArrayList<>();
        byte [] testByteAsImage1 = {80, 61, 41 ,18 ,110 };
        byte [] testByteAsImage2 = {32, 45, 21 ,41 ,92 };
        byte [] testByteAsImage3 = {45, 42, 23 ,48 ,111 };

        Address address01 = new Address( "Altonaer Strasse 25", "Erfurt", "99085" );
        Faculty faculty01 = new Faculty("Gebaeudetechnik und Informatik");
        PersonAvatar personAvatar01 = new PersonAvatar(testByteAsImage1);
        Person lecture01 = Person.lecturer("Volker", "Herwig",
                "volker.herwig@fh-erfurt.de","036167005512", "Prof. Dr.",
                "01.01.2010", faculty01, address01," 4.2.25",true,
                false, personAvatar01);



        Address address02 = new Address( "Altonaer Strasse 2", "Erfurt", "99085" );
        Faculty faculty02 = new Faculty("Landschaftsarchitektur, Gartenbau und Forst");
        PersonAvatar personAvatar02 = new PersonAvatar(testByteAsImage2);
        Person lecture02 = Person.lecturer("Lector", "Lorem",
                "L.L@fh-erfufrt.de","0152485614", "Prof. Dr.",
                "22.02.2012", faculty02, address02,"2.02.E2",true,
                false, personAvatar02 );



        Address address03 = new Address( "Altonaer Strasse 12", "Erfurt", "99085" );
        PersonAvatar personAvatar03 = new PersonAvatar(testByteAsImage3);
        Person lecture03 = Person.lecturer("Steffen", "Avemarg",
                "steffen.avemarg@fh-erfurt.de","036167005511 ", "Prof. Dr.",
                "01.01.2010", faculty01, address03," 4.2.25",true,
                false, personAvatar03 );


        //then
        lectureList.add(lecture01);
        lectureList.add(lecture02);
        lectureList.add(lecture03);


        //when
        Assertions.assertThat(lectureList.stream().filter(person -> person.getEmail().equals("steffen.avemarg@fh-erfurt.de"))).
                isNotEmpty().
                contains(lecture03);
    }

    @Test
    void testCreatestudent() {
        //given
        ArrayList<Person> studentList = new ArrayList<>();
        byte [] testByteAsImage1 = {80, 61, 41 ,18 ,110 };
        byte [] testByteAsImage2 = {32, 45, 21 ,41 ,92 };
        byte [] testByteAsImage3 = {45, 42, 23 ,48 ,111 };



        Address address01 = new Address( "Altonaer Strasse 25", "Erfurt", "99085" );
        Faculty faculty01 = new Faculty("Landschaftsarchitektur, Gartenbau und Forst");
        PersonAvatar personAvatar01 = new PersonAvatar(testByteAsImage1);
        Person student01 = Person.student("Max", "Mustermann", "m.m@m.com",
                "Gartenbau", "21.10.2021", null, false,
                false, false, address01, faculty01, personAvatar01);



        Address address02 = new Address( "Altonaer Strasse 2", "Erfurt", "99085" );
        Faculty faculty02 = new Faculty("Gebaeudetechnik und Informatik");
        PersonAvatar personAvatar02 = new PersonAvatar(testByteAsImage2);
        Person student02 =  Person.student("Tran", "Anh Hoang", "tran@fh-erfurt.de",
                "AI", "01.10.2020", null, false,
                true, false, address02, faculty02, personAvatar02);



        Address address03 = new Address( "Altonaer Strasse 12", "Erfurt", "99085" );
        PersonAvatar personAvatar03 = new PersonAvatar(testByteAsImage3);
        Person student03 = Person.student("Milena", "Neumann",
                "Neumann@fh-erfurt.de","AI ", "01.10.2020",
                null ,true, false ,false, address02, faculty02 , personAvatar03 );

        //then
        studentList.add(student01);
        studentList.add(student02);
        studentList.add(student03);

        //when
        Assertions.assertThat(studentList.stream().filter(person -> person.getFirstname().equals("Tran"))).
                isNotEmpty().
                contains(student02);

    }
}
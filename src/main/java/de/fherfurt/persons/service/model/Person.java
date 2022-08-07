package de.fherfurt.persons.service.model;


import de.fherfurt.persons.service.persistence.core.AbstractDatabaseEntity;
import lombok.*;

import javax.persistence.*;

/**
 * The class Person is an Entity class, and it includes all the information about a Person. This class will be safe in the Database This class was created with a builder Pattern in Java 1 and get rework in java 2 with Lombok
 *
 * @author Tran Anh Hoang
 * @version 2.0.0.0
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Builder(access = AccessLevel.PRIVATE, setterPrefix = "set")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Getter
public class Person extends AbstractDatabaseEntity {


    private String firstname;
    private String lastname;
    private String email;
    private String phonenumber;
    private String title;
    private String hireDate;
    private Boolean teachingFlag;
    private String room;
    private String major;
    private String immatriculationDate;
    private String exmatriculationDate;
    private Boolean tutorFlag;
    private Boolean scientificWorkerFlag;
    private String jobTitle;
    private Boolean deletedFlag;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @OneToOne(cascade = {CascadeType.ALL})
    private PersonAvatar avatar;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Faculty facultyName;


    /**
     * This methode will create a Person of the Instance of an otherEmployee and save it into the Database
     *
     * @return a new person instance that only requires the specific parameters for an employee
     */
    public static Person otherEmployee(String firstname, String lastname, String phonenumber, String email, String jobTitle, String room, Faculty faculty, Address address, boolean deletedFlag, PersonAvatar personAvatar) {
        return builder().setFirstname(firstname).setLastname(lastname).setPhonenumber(phonenumber).setEmail(email).
                setJobTitle(jobTitle).setRoom(room).setAddress(address).setFacultyName(faculty).setDeletedFlag(deletedFlag).setAvatar(personAvatar).build();
    }

    /**
     * This methode will create a Person of the Instance of a lecture and save it into the Database
     *
     * @return a new person instance that only requires the specific parameters for a lecturer
     */
    public static Person lecturer(String firstname, String lastname, String email, String phonenumber,
                                  String title, String hireDate, Faculty faculty, Address address, String room, Boolean teachingFlag,
                                  boolean deletedFlag, PersonAvatar personAvatar) {
        return builder().setFirstname(firstname).setLastname(lastname).setEmail(email).
                setPhonenumber(phonenumber).setTitle(title).setHireDate(hireDate).setFacultyName(faculty).setAddress(address).setRoom(room).
                setTeachingFlag(teachingFlag).setRoom(room).setDeletedFlag(deletedFlag).setAvatar(personAvatar).build();
    }

    /**
     * This methode will create a Person of the Instance of a student and save it into the Database
     *
     * @return a new person instance that only requires the specific parameter for a student
     */
    public static Person student(String firstname, String lastname, String email, String major,
                                 String immatriculationDate, String exmatriculationDate,
                                 Boolean tutorFlag, Boolean scientificWorkerFlag,
                                 boolean deletedFlag, Address address,
                                 Faculty facultyName, PersonAvatar personAvatar) {
        return builder().setFirstname(firstname).setLastname(lastname).setEmail(email)
                .setMajor(major).setImmatriculationDate(immatriculationDate).
                setExmatriculationDate(exmatriculationDate).setTutorFlag(tutorFlag).
                setScientificWorkerFlag(scientificWorkerFlag).setDeletedFlag(deletedFlag).
                setAddress(address).setFacultyName(facultyName).setAvatar(personAvatar).build();
    }


}
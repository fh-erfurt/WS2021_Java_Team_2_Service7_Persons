package de.fherfurt.persons.service.core;

import java.util.Optional;

public class EditingPerson {
    public static void editFirstNameOfPersonBy(int personId, String firstName) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setFirstname(firstName);
    }

    public static void editLastNameOfPersonBy(int personId, String lastName) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setLastname(lastName);
    }

    public static void editEmailOfPersonBy(int personId, String email) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setEmail(email);
    }

    public static void editPhonenumberOfPersonBy(int personId, String phonenumber) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setPhonenumber(phonenumber);
    }

    public static void editTitleOfPersonBy(int personId, String title) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setTitle(title);
    }

    public static void editHireDateOfPersonBy(int personId, String hireDate) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setHireDate(hireDate);
    }

    public static void editFacultyOfPersonBy(int personId, String faculty) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setFaculty(faculty);
    }

    public static void editTeachingFlagOfPersonBy(int personId, Boolean teachingFlag) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setTeachingFlag(teachingFlag);
    }

    public static void editRoomOfPersonBy(int personId, String room) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setRoom(room);
    }

    public static void editMajorOfPersonBy(int personId, String major) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setMajor(major);
    }

    public static void editImmatriculationDateOfPersonBy(int personId, String immatriculationDate) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setImmatriculationDate(immatriculationDate);
    }

    public static void editExmatriculationDateOfPersonBy(int personId, String exmatriculationDate) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setExmatriculationDate(exmatriculationDate);
    }

    public static void editTutorFlagOfPersonBy(int personId, Boolean tutorFlag) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setTutorFlag(tutorFlag);
    }

    public static void editScientificWorkerFlagOfPersonBy(int personId, Boolean scientificWorkerFlag) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setScientificWorkerFlag(scientificWorkerFlag);
    }

    public static void editJobTitleOfPersonBy(int personId, String jobTitle) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setJobTitle(jobTitle);
    }

    public static void editDeletedFlagOfPersonBy(int personId, Boolean deletedFlag) {
        SearchingSystem Search = new SearchingSystem();
        Optional<Person> wantedPerson = Search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setDeletedFlag(deletedFlag);
    }
    
}

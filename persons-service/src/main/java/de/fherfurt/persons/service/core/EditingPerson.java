package de.fherfurt.persons.service.core;

import java.util.Optional;


/**
 * @author Milena Neumann
 * methods to find a person and change attributes
 */
public class EditingPerson {

    public void editFirstNameOfPersonBy(int personId, String firstName) {
        SearchingSystem search = new SearchingSystem();
        Optional<Person> wantedPerson = search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setFirstname(firstName);
    }

    public void editLastNameOfPersonBy(int personId, String lastName) {
        SearchingSystem search = new SearchingSystem();
        Optional<Person> wantedPerson = search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setLastname(lastName);
    }

    public void editEmailOfPersonBy(int personId, String email) {
        SearchingSystem search = new SearchingSystem();
        Optional<Person> wantedPerson = search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setEmail(email);
    }

    public void editPhonenumberOfPersonBy(int personId, String phonenumber) {
        SearchingSystem search = new SearchingSystem();
        Optional<Person> wantedPerson = search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setPhonenumber(phonenumber);
    }

    public void editTitleOfPersonBy(int personId, String title) {
        SearchingSystem search = new SearchingSystem();
        Optional<Person> wantedPerson = search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setTitle(title);
    }

    public void editHireDateOfPersonBy(int personId, String hireDate) {
        SearchingSystem search = new SearchingSystem();
        Optional<Person> wantedPerson = search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setHireDate(hireDate);
    }

    public void editFacultyOfPersonBy(int personId, String faculty) {
        SearchingSystem search = new SearchingSystem();
        Optional<Person> wantedPerson = search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setFaculty(faculty);
    }

    public void editTeachingFlagOfPersonBy(int personId, Boolean teachingFlag) {
        SearchingSystem search = new SearchingSystem();
        Optional<Person> wantedPerson = search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setTeachingFlag(teachingFlag);
    }

    public void editRoomOfPersonBy(int personId, String room) {
        SearchingSystem search = new SearchingSystem();
        Optional<Person> wantedPerson = search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setRoom(room);
    }

    public void editMajorOfPersonBy(int personId, String major) {
        SearchingSystem search = new SearchingSystem();
        Optional<Person> wantedPerson = search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setMajor(major);
    }

    public static void editImmatriculationDateOfPersonBy(int personId, String immatriculationDate) {
        SearchingSystem search = new SearchingSystem();
        Optional<Person> wantedPerson = search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setImmatriculationDate(immatriculationDate);
    }

    public void editExmatriculationDateOfPersonBy(int personId, String exmatriculationDate) {
        SearchingSystem search = new SearchingSystem();
        Optional<Person> wantedPerson = search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setExmatriculationDate(exmatriculationDate);
    }

    public void editTutorFlagOfPersonBy(int personId, Boolean tutorFlag) {
        SearchingSystem search = new SearchingSystem();
        Optional<Person> wantedPerson = search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setTutorFlag(tutorFlag);
    }

    public void editScientificWorkerFlagOfPersonBy(int personId, Boolean scientificWorkerFlag) {
        SearchingSystem search = new SearchingSystem();
        Optional<Person> wantedPerson = search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setScientificWorkerFlag(scientificWorkerFlag);
    }

    public void editJobTitleOfPersonBy(int personId, String jobTitle) {
        SearchingSystem search = new SearchingSystem();
        Optional<Person> wantedPerson = search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setJobTitle(jobTitle);
    }

    public void editDeletedFlagOfPersonBy(int personId, Boolean deletedFlag) {
        SearchingSystem search = new SearchingSystem();
        Optional<Person> wantedPerson = search.findPersonUsingIteratorBy(personId);
        wantedPerson.orElseThrow().setDeletedFlag(deletedFlag);
    }
    
}

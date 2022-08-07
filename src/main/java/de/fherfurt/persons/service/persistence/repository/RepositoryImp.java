package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.model.Address;
import de.fherfurt.persons.service.model.Faculty;
import de.fherfurt.persons.service.model.Person;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RepositoryImp implements PersonRepository, AddressRepository, PersonAvatarRepository, FacultyRepository {

    private final PersonDao personDao;
    private final GenericDao<Address> addressDao;
    private final PersonAvatarDao personAvatarDao;
    private final GenericDao<Faculty> facultyGenericDao;


    RepositoryImp(PersonDao personDao, GenericDao<Address> addressDao, GenericDao<Faculty> FacultyDao, PersonAvatarDao personAvatarDao) {
        this.personDao = personDao;
        this.addressDao = addressDao;
        this.personAvatarDao = personAvatarDao;
        this.facultyGenericDao = FacultyDao;
    }


    @Override
    public boolean createPerson(Person person) {
        return this.personDao.create(person);
    }

    @Override
    public List<Person> findAllPersonsByUserInput(String firstname, String lastname, String major, String faculty) {
        return findAll().stream().filter(Objects::nonNull).filter(person -> (Objects.equals(person.getFirstname(), firstname)
                && Objects.equals(person.getLastname(), lastname))
                || (Objects.equals(person.getMajor(), major)
                && Objects.equals(person.getFacultyName().getFacultyName(), faculty))).collect(Collectors.toList());
    }

    @Override
    public Person findPersonBy(long personId) {
        return this.personDao.findBy(personId);
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>) this.personDao.findAll();
    }

    @Override
    public List<Person> findPersonsByAddressId(long addressId) {

        return this.findAll()
                .stream()
                .filter(c -> c.getAddress().getId().equals(addressId))
                .collect(Collectors.toList());
    }


    @Override
    public List<Person> findPersonsByFacultyName(String facultyName) {

        return findAll().stream().
                filter(person -> person.getFacultyName().getFacultyName().contains(facultyName)).collect(Collectors.toList());
    }

    @Override
    public byte[] findPersonAvatarById(long avatarId) {
        return this.personAvatarDao.findPersonAvatarById(avatarId);
    }


    @Override
    public boolean updatePersonById(Person person) {
        this.personDao.update(person);
        return findPersonBy(person.getId()).getId().equals(person.getId());

    }

    @Override
    public boolean deletePersonById(long personId) {
        return this.personDao.delete(personId);
    }


    @Override
    public List<Person> findAllPersonWithDeletedFlag() {
        return findAll().stream().filter(p -> Objects.equals(p.getDeletedFlag(), true)).collect(Collectors.toList());

    }

    @Override
    public List<Person> findAllPersonsWithoutDeletedFlag() {
        return findAll().stream().filter(p -> Objects.equals(p.getDeletedFlag(), false)).collect(Collectors.toList());

    }

    @Override
    public List<Person> findAllPersonWithEqualAddress(String street, String city, String zipCode) {

        return findAll().stream().filter(person -> Objects.equals(person.getAddress().getStreet(), street) && Objects.equals(person.getAddress().getCity(), city)
                && Objects.equals(person.getAddress().getZipCode(), zipCode)).collect(Collectors.toList());
    }

    @Override
    public boolean createAddress(Address address) {
        return this.addressDao.create(address);
    }

    @Override
    public List<Address> findAllAddresses() {
        return new ArrayList<>(this.addressDao.findAll());
    }

    @Override
    public Address findAddressBy(Long addressId) {
        return this.addressDao.findBy(addressId);
    }

    @Override
    public boolean updateAddressBy(Address address) {
        this.addressDao.update(address);
        return findAddressBy(address.getId()).getId().equals(address.getId());

    }

    @Override
    public boolean deleteAddressBy(long addressId) {
        return this.addressDao.delete(addressId);
    }


    @Override
    public List<Faculty> findAllFaculty() {
        return new ArrayList<>(this.facultyGenericDao.findAll());
    }

    @Override
    public Faculty findFacultyBy(Long facultyId) {
        return this.facultyGenericDao.findBy(facultyId);
    }

    @Override
    public boolean updateFacultyBy(Faculty faculty) {
        this.facultyGenericDao.update(faculty);
        return findAddressBy(faculty.getId()).getId().equals(faculty.getId());
    }

    @Override
    public boolean deleteFacultyBy(Long facultyId) {
        return false;
    }

}

package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.model.Address;
import de.fherfurt.persons.service.model.Person;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImp implements PersonRepository, AddressRepository{

    private final PersonDao personDao;
    private final GenericDao<Address> addressDao;


    RepositoryImp(PersonDao personDao, GenericDao<Address> addressDao) {
        this.personDao = personDao;
        this.addressDao = addressDao;
    }


    @Override
    public boolean createAddress(Address address) {
        return this.addressDao.create( address);
    }

    @Override
    public List<Address> getAllAddresses() {
        return new ArrayList<>(this.addressDao.findAll());
    }

    @Override
    public Address getAddress(Long addressId) {
        return this.addressDao.findBy(addressId);
    }

    @Override
    public boolean updateAddress(long addressId, Address address) {
        this.addressDao.update(addressId, address);
        return getAddress(addressId).equals(address);
    }

    @Override
    public boolean deleteAddress(Long addressId) {
        return this.addressDao.delete(addressId);
    }




    @Override
    public boolean createPerson(Person person) {
        return this.personDao.create( person ) ;
    }

    @Override
    public List<Person> getAllPersonsByUserInput(String inFirstName, String inLastName, String inMajor, String inFaculty) {
        return new ArrayList<>(this.personDao.findPersonBy(inFirstName, inLastName, inMajor, inFaculty));
    }

    @Override
    public Person getPersonBy(long personId){
        return this.personDao.findPersonById(personId);
    }

    @Override
    public boolean updatePersonById(long personId, Person person ){
        this.personDao.update(personId, person);
        return getPersonBy(personId).getId() == personId;
    }

    @Override
    public boolean deletePersonId( long personId ){
        return this.personDao.delete(personId);
    }

    @Override
    public List<Person> getPersonsWithAddress(long addressId ){
        return new ArrayList<>(this.personDao.findAll());
    }
    

}

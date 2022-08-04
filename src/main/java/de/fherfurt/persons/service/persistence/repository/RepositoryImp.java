package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.model.Address;
import de.fherfurt.persons.service.model.Person;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImp implements PersonRepository, AddressRepository, PersonAvatarRepository{

    private final PersonDao personDao;
    private final GenericDao<Address> addressDao;
    private final PersonAvatarDao personAvatarDao;


    RepositoryImp(PersonDao personDao, GenericDao<Address> addressDao, PersonAvatarDao personAvatarDao) {
        this.personDao = personDao;
        this.addressDao = addressDao;
        this.personAvatarDao = personAvatarDao;
    }


    @Override
    public boolean createAddress(Address address) {
        return this.addressDao.create( address);
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
    public boolean updateAddressBy(long addressId, Address address) {
        this.addressDao.update(addressId, address);
        return findAddressBy(addressId).equals(address);
    }


    @Override
    public boolean deleteAddressBy(long addressId) {
        return this.addressDao.delete(addressId);
    }


    @Override
    public boolean createPerson(Person person) {
        return this.personDao.create( person ) ;
    }

    @Override
    public List<Person> findAllPersonsByUserInput(String inFirstName, String inLastName, String inMajor, String inFaculty) {
        return new ArrayList<>(this.personDao.findPersonBy(inFirstName, inLastName, inMajor, inFaculty));
    }

    @Override
    public Person findPersonBy(long personId){
        return this.personDao.findBy(personId);
    }

    @Override
    public List<Person> findAll(){
        return (List<Person>) this.personDao.findAll();
    }

    @Override
    public byte [] findPersonAvatarByPersonId(long personId){
        return this.personAvatarDao.findPersonAvatarByPersonId(personId);
    }
    @Override
    public byte [] findPersonAvatarById(long avatarId){
        return this.personAvatarDao.findPersonAvatarById(avatarId);
    }


    @Override
    public boolean updatePersonById(long personId, Person person ){
        this.personDao.update(personId, person);
        return findPersonBy(personId).getId() == personId;
    }

    @Override
    public boolean deletePersonId( long personId ){
        return this.personDao.delete(personId);
    }

    @Override
    public List<Person> getPersonsWithAddress(long addressId ){
        return new ArrayList<>(this.personDao.findAll());
    }

    @Override
    public List<Person> findAllPersonWithDeletedFlag() {
        return new ArrayList<>(this.personDao.findAllPersonWithDeletedFlag());
    }

    @Override
    public List<Person> findAllPersonsWithoutDeletedFlag() {
        return new ArrayList<>(this.personDao.findAllPersonsWithoutDeletedFlag());
    }


}

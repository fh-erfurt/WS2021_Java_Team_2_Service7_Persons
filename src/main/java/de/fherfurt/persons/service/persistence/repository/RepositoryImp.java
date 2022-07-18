package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.model.Address;
import de.fherfurt.persons.service.model.Person;

public class RepositoryImp implements PersonRepository, AddressRepository{

    private final PersonDao personDao;
    private final GenericDao<Address> addressDao;


    RepositoryImp(PersonDao personDao, GenericDao<Address> addressDao) {
        this.personDao = personDao;
        this.addressDao = addressDao;
    }

    @Override
    public boolean createPerson(Person person) {
        return this.personDao.create( person ) ;
    }

    @Override
    public boolean createAddress(Address address) {
        return this.addressDao.create(address);
    }



}

package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.model.Address;

public class RepositoryImp {

    private final PersonDao personDao;
    private final GenericDao<Address> addressDao;


    RepositoryImp(PersonDao personDao, GenericDao<Address> addressDao) {
        this.personDao = personDao;
        this.addressDao = addressDao;
    }

}

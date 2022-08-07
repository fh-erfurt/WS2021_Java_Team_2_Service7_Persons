package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.model.Person;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * The interface PersonDao represent the abstract layer between PersonDao, GenericDao and Repository-Layer.
 * @author  Tran Anh Hoang
 * @version  2.0.0.0
 */
public interface PersonDao extends GenericDao<Person>{

    Person findPersonById(long personId);

}

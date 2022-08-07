package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.persistence.core.AbstractDatabaseEntity;

import java.util.Collection;
import java.util.Optional;

/**
 * The interface GenericDao represent the abstract layer between PersonAvatarDao,PersonDao,GenericDao and Repository-Layer. It has the goal to isolate the application/business layer from the persistence layer (
 *
 * @author Tran Anh Hoang
 * @version 2.0.0.0
 */
public interface GenericDao<T extends AbstractDatabaseEntity> {
    T findBy(long id);

    Collection<T> findAll();


    boolean create(T entity);

    boolean createAll(Collection<T> newEntities);

    T update(T entity);

    boolean delete(Long id);

    boolean delete(T entity);


}

package de.fherfurt.persons.service.persistence.repository;
import de.fherfurt.persons.service.persistence.core.AbstractDatabaseEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * DAO = Data Access Object
 * isolate the application/business layer from the persistence layer (
 */
public interface GenericDao<T extends AbstractDatabaseEntity> {
    Optional<T> findById(long id);
    Collection<T> findAll();



    boolean create( T entity );
    boolean createAll( Collection<T> newEntities );


    Optional<T> update( T entity );

    boolean delete( Long id );
    boolean delete( T entity );
    boolean delete( Collection<T> entries );

}

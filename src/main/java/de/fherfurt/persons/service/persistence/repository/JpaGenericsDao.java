package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.persistence.core.AbstractDatabaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Optional;

public class JpaGenericsDao <T extends AbstractDatabaseEntity> implements GenericDao<T>{
    protected final Class<T> persistentClass;
    protected final EntityManager entityManager;


    public JpaGenericsDao( Class<T> type, EntityManager em ) {
        this.persistentClass = type;
        this.entityManager = em;
    }

    public Class<T> getEntityClass() {
        return persistentClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }


    @Override
    public T findBy(long id) {
        return getEntityManager().find( persistentClass, id );
    }

    @Override
    public Collection<T> findAll() {
        Query query = getEntityManager().createQuery(
                "SELECT e FROM " + getEntityClass().getCanonicalName() + " e" );
        return (Collection<T>) query.getResultList();
    }

    @Override
    public boolean create( T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist( entity );
        getEntityManager().getTransaction().commit();

        return true;
    }

    @Override
    public boolean createAll( Collection<T> newEntities ) {
        getEntityManager().getTransaction().begin();

        for( T entry : newEntities )
            getEntityManager().persist( entry );

        getEntityManager().getTransaction().commit();

        return true;
    }

    @Override
    public Optional<T> update(long personId, T entity) {
        getEntityManager().getTransaction().begin();
        final T savedEntity = getEntityManager().merge( entity );
        getEntityManager().getTransaction().commit();

        return Optional.ofNullable(savedEntity);
    }

    @Override
    public boolean delete( Long id ) {
        T entity = this.findBy( id );
        return this.delete( entity );
    }

    @Override
    public boolean delete( T entity ) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove( entity );
        getEntityManager().getTransaction().commit();

        return true;
    }


}

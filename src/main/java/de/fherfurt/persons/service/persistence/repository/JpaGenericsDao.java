package de.fherfurt.persons.service.persistence.repository;

import de.fherfurt.persons.service.persistence.core.AbstractDatabaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Optional;


/**
 * The class JpaGenericsDao is the implementation class of the interface GenericDao.
 * @author  Tran Anh Hoang
 * @version  2.0.0.0
 */
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
    public T update( T entity) {
        getEntityManager().getTransaction().begin();
        final T savedEntity = getEntityManager().merge( entity );
        getEntityManager().getTransaction().commit();

        return savedEntity;
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

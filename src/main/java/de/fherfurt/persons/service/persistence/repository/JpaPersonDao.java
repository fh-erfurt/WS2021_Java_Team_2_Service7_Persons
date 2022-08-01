package de.fherfurt.persons.service.persistence.repository;

import javax.persistence.EntityManager;
import de.fherfurt.persons.service.model.Person;

import java.util.Collection;
import java.util.Optional;


public class JpaPersonDao extends JpaGenericsDao<Person> implements PersonDao {

    public JpaPersonDao( EntityManager em ){
        super( Person.class, em );
    }


    @Override
    public Person findPersonById(long personId) {
        return null;
    }

    @Override
    public Collection<Person> findPersonBy(String firstname, String lastname, String major, String faculty) {
        return null;
    }

    @Override
    public byte[] findPersonAvatarBy(int personId) {
        return new byte[0];
    }

    @Override
    public Collection<Person> findAllPersonWithDeletedFlag() {
        return null;
    }

    @Override
    public Collection<Person> findAllPersonsWithoutDeletedFlag() {
        return null;
    }
}
